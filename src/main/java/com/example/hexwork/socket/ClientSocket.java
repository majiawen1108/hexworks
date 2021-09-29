package com.example.hexwork.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author jw.ma
 * @title: ClientSocket
 * @description: socket及时通信 模拟用户登录
 * @date 2021/9/28 14:43
 */
public class ClientSocket {
    public static void main(String[] args) {
        try {
            // 创建Socket对象
            Socket socket = new Socket("127.0.0.1", 8384);
            // 打开和服务器的链接  打开输出流
            OutputStream os = socket.getOutputStream();
            // 发送信息
            Scanner sc=new Scanner(System.in);//模拟用户登录
            System.out.println("请输入姓名:");
            String name=sc.next();
            System.out.println("请输入密码");
            String pwd=sc.next();
            os.write(name.getBytes());
            os.write("\r\n".getBytes());
            os.write(pwd.getBytes());
            // 告诉服务器，客户端发送完毕
            socket.shutdownOutput();
            // 读取服务器响应的内容
            String s;
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(s=br.readLine().toString());
            if(s.equals("no")){//判断用户信息的正确性
                System.out.println("登录失败!");
            }else{
                System.out.println("登录成功!");
            }
            // 关闭
            br.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
