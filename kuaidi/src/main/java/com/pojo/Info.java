package com.pojo;

public class Info {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String kind;

    private String geta;

    private String senda;

    private String note;

    private String money;

    private String telephone;

    private String receive_tel;

    private int confirm;

    private int confirm_send;

    private int confirm_get;

    private int confirmhim;

    private int pageconfirm;

    public String getReceive_tel() {
        return receive_tel;
    }

    public void setReceive_tel(String receive_tel) {
        this.receive_tel = receive_tel;
    }

    public int getPageconfirm() {
        return pageconfirm;
    }

    public void setPageconfirm(int pageconfirm) {
        this.pageconfirm = pageconfirm;
    }

    public int getConfirmhim() {
        return confirmhim;
    }

    public void setConfirmhim(int confirmhim) {
        this.confirmhim = confirmhim;
    }

    public int getConfirm_get() {
        return confirm_get;
    }

    public void setConfirm_get(int confirm_get) {
        this.confirm_get = confirm_get;
    }

    public int getConfirm_send() {
        return confirm_send;
    }

    public void setConfirm_send(int confirm_send) {
        this.confirm_send = confirm_send;
    }

    public int getConfirm() {
        return confirm;
    }

    public void setConfirm(int confirm) {
        this.confirm = confirm;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getSenda() {
        return senda;
    }

    public void setSenda(String senda) {
        this.senda = senda;
    }

    public String getGeta() {
        return geta;
    }

    public void setGeta(String geta) {
        this.geta = geta;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }


    @Override
    public String toString(){
        return "种类为："+kind+"  取件地址："+geta+"  送货地址："+senda+"  工资："+money+"  备注："+note+" 电话:"+telephone;
    }

}
