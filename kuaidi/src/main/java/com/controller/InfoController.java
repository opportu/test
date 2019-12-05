package com.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Info;
import com.commons.Result;
import com.pojo.User;
import com.service.InfoService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/orderInfo")
public class InfoController {

    @Autowired
    private UserService userService;

    @Autowired
    private InfoService infoService;

    /**
     *  接单人接单，并添加接单人的电话信息
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping("/readdinformation")
    public Result readdinformation(@RequestParam("id") int id, HttpSession session){
        Result rs = new Result();
        User user =(User) session.getAttribute("LOGIN_USER");
        String telephone = user.getTelephone();
        User user1 = new User();
/**
 * get_id为所发的单号的id，
 */
//        user1.setGet_id(id);
        user1.setTelephone(telephone);
//        userService.readdinformation(user1);
        Info info = new Info();
        info.setId(id);
        info.setPageconfirm(1);
        infoService.pageconfirms(info);
//        用户接单信息
        List<Info> list3 = infoService.findget(telephone);
        rs.setIsSuccess(true);
        return rs;
    }

    /**
     * 发单人取消发单
     * @param id 单号
     * @return
     */
      @ResponseBody
      @RequestMapping("/a")
      public Result a(@RequestParam("id") int id){
          Result rs = new Result();
          Info info=infoService.check(id);
          if (info.getPageconfirm() == 0){
            infoService.deleteinfo(id);
            infoService.updateinfo(id);
              rs.setIsSuccess(true);
          }else{
              rs.setIsSuccess(false);
          }
          return rs;

      }

    /**
     * 接单人取消接单
     * @param id
     * @return
     */
     @ResponseBody
     @RequestMapping("/b")
     public Result b(@RequestParam("id") int id){
          Result rs = new Result();
          Info info = infoService.check(id);
          if (info.getConfirmhim() == 0){
              info.setPageconfirm(0);
              info.setId(id);
              infoService.pageconfirms(info);
              infoService.deletereceives_tel(id);
              rs.setIsSuccess(true);
          }else{
              rs.setIsSuccess(false);
          }
           return rs;
     }

    /**
     * 发单用户确认让接单用户接单
     * @param id
     * @return
     */
     @ResponseBody
     @RequestMapping("/c")
     public Result c(@RequestParam("id") int id){
         Result rs = new Result();
         Info info = new Info();
             info.setConfirmhim(1);
             info.setId(id);
             infoService.confirmshim(info);
             rs.setIsSuccess(true);
         return rs;
     }

    /**
     * 发单用户不让接单用户接单
     * @param id
     * @return
     */
     @ResponseBody
     @RequestMapping("/d")
     public Result d(@RequestParam("id") int id){
         Result rs = new Result();
         Info info = new Info();
         info.setConfirmhim(0);
         info.setPageconfirm(0);
         info.setId(id);
         infoService.pageconfirms(info);
         infoService.confirmshim(info);
         rs.setIsSuccess(true);
         return rs;
     }


    /**
     * 向数据库中添加快递的详尽信息,发单
     */

    @ResponseBody
    @RequestMapping("/addinformation")
    public Result addinformation(@RequestParam("kind") String kind, @RequestParam("geta") String geta,
                                 @RequestParam("senda") String senda, @RequestParam("money") String money,
                                 @RequestParam("note") String note, @RequestParam("telephone") String telephone){
        Result rs = new Result();
        Info info = new Info();
        info.setKind(kind);
        info.setTelephone(telephone);
        info.setGeta(geta);
        info.setSenda(senda);
        info.setMoney(money);
        info.setNote(note);
        info.setConfirm(0);
        info.setConfirm_send(0);
        info.setConfirm_get(0);
        info.setPageconfirm(0);
        rs.setIsSuccess(true);

/**
 *  infoService.alter(1);
 *  该方法解决了数据库中删除数据之后，再插入数据时id不能连续的问题
 *  在插入数据之前，让数据库中的id每一次都在最大值的id后加1
 *
 */
        infoService.alter(1);
        infoService.add(info);/*添加订单信息*/
        return rs;
    }

    /**
     * 展示数据库中所有用户下单的信息
     * @return
     */
  /*  @RequestMapping("/showallInfo")
    public ModelAndView showallInfo(){
        ModelAndView modelAndView = new ModelAndView() ;
        List<Info> list = infoService.findall();
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        modelAndView.addObject("list",list);
        modelAndView.setViewName("jsp/我要取快递.jsp");
        return modelAndView;
    }*/

    /**
     * 将快递信息展示给用户观看
     * @param pageNo
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getPageinfo",method = RequestMethod.GET)
    public Result getPageinfo(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize",required = false) Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<Info> List = infoService.findall();
        Result rs = new Result();
        if (List != null){
            PageInfo pageInfo = new PageInfo(List,10);
            rs.setIsSuccess(true);
            rs.setData(pageInfo);
        }else {
            rs.setIsSuccess(false);
        }
        return rs;
    }

}
