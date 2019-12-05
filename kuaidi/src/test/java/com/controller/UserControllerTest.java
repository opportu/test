package com.controller;

import com.pojo.User;
import com.service.UserService;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author sulayman
 * @create 2019-12-03
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserControllerTest {

    @Autowired
    UserService userService;

    private static Logger logger = Logger.getLogger(UserControllerTest.class);

    @Before
    public void before(){
    }

    @Test
    public void testAddUser(){
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("nickname", "lily");
        paramMap.put("telephone", "15595473217");
        paramMap.put("password", "123456make_more_time");
        paramMap.put("sex", "true");
        try{
            userService.addUser(paramMap);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void getBasicInfo(){
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("userID", 2);
        try{
            Map<String, Object> map = userService.getBasicUser(paramMap);
            Set<Map.Entry<String, Object>> keyset = map.entrySet();
            Iterator iter = keyset.iterator();
            while(iter.hasNext()){
                System.out.println(iter.next());
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void loginWithCode(){
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("telephone", "15595473217");
        try{
            User user = userService.getAllInfo(paramMap);
            System.out.println(user.toString());
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void realUser(){
        HashMap<String, Object> paramMap = new HashMap<>();
        String path = "E:/6wanDownload/photo.jpg";
        paramMap.put("userID", 2L);
        paramMap.put("name", "罗纳尔多");
        paramMap.put("address", "曼联");
        paramMap.put("id_card", "1801050858");
        paramMap.put("idCardImage", path);
        paramMap.put("stuCardImage", path);
        try{
            userService.realUser(paramMap);
            logger.info("用户实名制成功");
        }catch(Exception e){
            logger.error("用户实名制失败", e);
            e.printStackTrace();
        }
    }


    @After
    public void tearDown() throws Exception {
    }
}
