function checkTel() {
    var tel = $.trim($("#findPwd-tel").val());
    if (tel == "") {
        document.getElementsByClassName("findPwd-errorInfo")[0].innerHTML = "账号为空";
        return false;
    } else if (tel.length != 11) {
        document.getElementsByClassName("findPwd-errorInfo")[0].innerHTML = "请填写正确的格式";
        return false;
    } else {
        document.getElementsByClassName("findPwd-errorInfo")[0].innerHTML = "&nbsp";
        return true;
    }
}

function checkCode() {
    var pwd = $.trim($("#findPwd-code").val());
    if (pwd.length < 9) {
        document.getElementsByClassName("findPwd-errorInfo")[0].innerHTML = "验证码过短";
        return false;
    } else {
        document.getElementsByClassName("findPwd-errorInfo")[0].innerHTML = "&nbsp";
        return true;
    }
}

function getSecurityCode(obj) {
    var Telephone = $.trim($("#findPwd-tel").val());
    var getCode = true;
    var countdown = 60;
    var data = { "Telephone": "Telephone", "getCode": "getCode" };
    $.ajax({
        url: "/userInfo/getCode",
        type: "POST",
        dataType: "json",
        async: true,
        data: data,
        contentType:"application/json",
        success: function (result) {
            if (result.isSuccess) {
                function setTime(obj) {
                    if (countdown == 0) {
                        $("#findPwd-getCode").attr("disabled", false);
                        $("#findPwd-getCode").attr("value", "发送验证码");
                        countdown = 60;
                        return;
                    } else {
                        $("#findPwd-getCode").attr("disabled", true);
                        $("#findPwd-getCode").attr("value", "(" + countdown + ")s重新发送");
                        countdown--;
                    }
                    setTimeout(() => { setTime(obj) }, 1000);
                }
                setTime(obj);
            }else{
                alert("获取验证码失败");
            }
        }
    })
}

function submitForm(){
    var tel=checkTel();
    var securityCode=checkCode();
    if(tel&&securitCode){
        var telephone=$.trim($("#findPwd-tel").val());
        var code=$.trim($("#findPwd-code").val());
        var data={"telephone":"telephone","code":"code"};
        $.ajax({
            url:"userInfo/loginUserWithCode",
            type:"POST",
            dataType:"json",
            async:true,
            data:data,
            contentType:"application/json",
            success:function(result){
                if(result.isSuccess){
                    alert("验证成功");
                    window.location.href("resetPassword.html");
                }else{
                    if(result.code==400){
                        alert("验证码失效");
                    }else if(result.code==500){
                        alert("验证码错误");
                    }else if(result.code==300){
                        alert("提供的号码有误");
                    }else{
                        alert("重置密码失败");
                    }
                }
            }
        });
    }
}