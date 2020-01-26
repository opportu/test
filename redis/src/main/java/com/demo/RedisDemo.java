package com.demo;

import redis.clients.jedis.Jedis;

public class RedisDemo {

    public static void main(String[] args){
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String value = jedis.get("k1");
        System.out.println("k1 = " + value);
        jedis.del("k1");
        System.out.println("k1 = " + value);
    }
}
