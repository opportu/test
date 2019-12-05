package com.service;

import com.pojo.Info;
import com.pojo.User;

import java.util.List;

public interface InfoService {

     void add(Info info);

//     查找数据库中所有的待领取的单
     List<Info> findall();


//    查找发过的单
     List<Info> find(String telephone);

//    查找接收过的单
    List<Info> findget(String telephone);

    /**
     * 发单用户确认让接单用户接单
     * @param
     * @return
     */
    void confirms(Info info);


    void pageconfirms(Info info);

    void confirmshim(Info info);

     int deleteinfo(int id);

     int updateinfo(int id);

     Info check(int id);

     int alter(int i);

     void deletereceives_tel(int id);
}
