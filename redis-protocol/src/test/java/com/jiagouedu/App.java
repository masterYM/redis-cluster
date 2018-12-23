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

import com.jiagouedu.api.Client;

public class App {

   public static void main(String[] args) {
      Client jedis = new Client("192.168.0.31",6379);
      for (int i=0;i<100;i++) {
         jedis.set("wukong"+i, "20181212"+i);
         String value = jedis.get("wukong"+i);
         System.out.println(value);
         try {
            Thread.sleep(200);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
   }
}
