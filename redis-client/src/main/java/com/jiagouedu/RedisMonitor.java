package com.jiagouedu;/* ━━━━━━如来保佑━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　┻　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━永无BUG━━━━━━
 * 图灵学院-悟空老师
 * 以往视频加小乔老师QQ：895900009
 * 悟空老师QQ：245553999
 */

import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;

public class RedisMonitor {

   static class MonitorTask implements Runnable {
      private Jedis client;

      MonitorTask(Jedis jedis) {
         client = jedis;
      }

      @Override
      public void run() {
         client.monitor(new redis.clients.jedis.JedisMonitor() {
            @Override
            public void onCommand(String command) {
               System.out.println(command);
            }
         });
      }
   }



      public static void main(String[] args) throws InterruptedException {
         Jedis monitor = new Jedis("192.168.0.31", 6379);
         Thread monitorTask = new Thread(new MonitorTask(monitor));
         monitorTask.start();

      }


}
