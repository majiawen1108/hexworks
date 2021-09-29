package com.example.hexwork.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author jw.ma
 * @title: SocketClientdemo1
 * @description: 模拟实时聊天
 * @date 2021/9/29 11:00
 */
public class SocketServerdemo1 {
    public static void main(String[] args) {
        ServerSocket server;
        try {
            server = new ServerSocket(8090);
            Socket socket=server.accept();
            while(true){
                System.out.println("----------");
                InputStream in;
                try {
                    in = socket.getInputStream();
                    byte [] b=new byte[1024];
                    StringBuffer sb=new StringBuffer();
                    String s;
                    if(in.read(b) !=-1){
                        s=new String(b);
                        sb.append(s);
                    }
                    OutputStream out=socket.getOutputStream();
                    System.out.println("客户端信息:"+sb);
                    Scanner sc=new Scanner(System.in);
                    String str=sc.next();
                    System.out.println("我："+str);
                    out.write(str.getBytes());
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
