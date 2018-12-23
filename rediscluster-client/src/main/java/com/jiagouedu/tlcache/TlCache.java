package com.jiagouedu.tlcache;
import com.tl.flasher.IRedis;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/application-tlcache.xml"})
public class TlCache {
   @Autowired
   IRedis iredis;

   @Test
    public void testKey(){
      for (int i=0;i<100;i++) {
         iredis.set("trade", "wukong" + i, "20181214" + i);
         System.out.println(iredis.get("trade","wukong"+i));
         try {
            Thread.sleep(2000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }
      try {
         Thread.sleep(Long.MAX_VALUE);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }

   @Test
   public void testKey2(){
      System.out.println(iredis.get("trade","wukong"));
   }

}
