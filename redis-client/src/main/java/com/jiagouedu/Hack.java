package com.jiagouedu;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Hack {
   public static void main(String[] args) throws IOException {
      ServerSocket serverSocket=new ServerSocket(6380);
      Socket accept = serverSocket.accept();
      byte[] b=new byte[1024];
      accept.getInputStream().read(b);
      System.out.println(new String(b));
   }
}
