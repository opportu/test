package com.controller;

import com.mapper.UrlManagerMapper;
import com.pojo.Url;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

/**
 * 该类为测试类
 * 其中的@RunWith注解的意思是：相当于一个运行器，
 * 而@ContextConfiguration 注解的意思是：Spring整合JUnit4测试时，使用注解引入多个配置文件
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class Test {

    /**
     * 自动注入Mapper层接口
     */
    @Autowired
    private UrlManagerMapper urlManagerMapper;

    @Value("${INTERCEPT_URL}")
    private String urlAndMethods;


    @Before
    public void before(){}


    @org.junit.Test
    public void test(){
        try{
            ArrayList<Url> arrays = getUrls(urlAndMethods);
            //批次插入数据库
            batchInsert(arrays);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 从指定properties文件获取接口相对地址以及请求方式
     * @param param
     * @return
     */
    private ArrayList<Url> getUrls (String param) {
        ArrayList<Url> urls = new ArrayList<Url>();
        String[] urlsStr = param.split(",");
        for (String urlStr : urlsStr) {
            Url url = new Url();
            String[] urlAndMethod = urlStr.split("_");
            url.setIntercept_type(Integer.parseInt(urlAndMethod[0]));
            url.setUrl(urlAndMethod[1]);
            url.setRequest_method(urlAndMethod[2]);

            urls.add(url);
        }

        return urls;
    }

    /**
     * 批次插入数据库
     * @param urls
     */
    private void batchInsert (ArrayList<Url> urls) {
        for (Url url : urls) {
            urlManagerMapper.addUrl(url);
        }
    }




}