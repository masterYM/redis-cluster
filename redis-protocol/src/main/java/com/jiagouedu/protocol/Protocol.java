package com.jiagouedu.protocol;

import java.io.IOException;
import java.io.OutputStream;

public class Protocol {
   public static final String DOLLAR_BYTE="$";
   public static final String ASTERISK_BYTE="*";
   public static final String BLANK_BYTE="\r\n";


   public static  void sendCommand(OutputStream outputStream, Command command, byte[]... b){
      StringBuffer stringBuffer=new StringBuffer();
      stringBuffer.append(ASTERISK_BYTE).append(b.length+1).append(BLANK_BYTE);
      stringBuffer.append(DOLLAR_BYTE).append(command.name().length()).append(BLANK_BYTE);
      stringBuffer.append(command).append(BLANK_BYTE);
      for (byte[] arg:b){ //List<User> all for(User user:all)
         stringBuffer.append(DOLLAR_BYTE).append(arg.length).append(BLANK_BYTE);
         stringBuffer.append(new String(arg)).append(BLANK_BYTE);
      }
      try {
         outputStream.write( stringBuffer.toString().getBytes());
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public static  enum Command{
      SET,GET,PING


   }


}
