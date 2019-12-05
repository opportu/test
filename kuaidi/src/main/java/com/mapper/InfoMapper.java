package com.mapper;

import com.pojo.Info;

import com.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfoMapper {
     void addinfo(Info info);

//    查找数据库中所有的待领取的单
     List<Info> findAllInfo();

//    查找发过的单
    List<Info> findInfo(String telephone);

//    查找接收过的单
    List<Info> findgetInfo(String telephone);

//    发单用户确认收到货
    void confirm(Info info);

//    发订单用户在没有接单用户时取消发单

//    页面显示是否被领取
    void pageconfirm(Info info);

//    发单用户确认让接单用户接单
    void confirmhim(Info info);

     int delete(int id);

     int update(int id);

     Info checkInfo(int id);

     int alterinfo(int i);

     void deletereceive_tel(int id);


}
