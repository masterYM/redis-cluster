package com.jiagouedu;
import redis.clients.jedis.Jedis;

public class Test {

   public static void main(String[] args) {
      Jedis jedis = new Jedis("localhost",6380);
      jedis.set("duli", "good");
      String value = jedis.get("duli");
      System.out.println(value);
   }
}
