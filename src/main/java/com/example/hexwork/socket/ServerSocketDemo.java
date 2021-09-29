package com.example.hexwork.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jw.ma
 * @title: ServerSocketDemo
 * @description: socket及时通信 模拟用户登录
 * @date 2021/9/28 14:37
 */
public class ServerSocketDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("C:info.txt");//用户信息提前存入硬盘

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));//创建对象流实现添加用户默认信息

        List list = new ArrayList();//以集合为单位存取信息

        User u1 = new User("zm", "123456");

        User u2 = new User("lx", "12345");

        list.add(u1);

        list.add(u2);

        oos.writeObject(list);//提前预存用户信息  方便以后用户登录核实

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

        List<User> list2 = new ArrayList();

        list2 = (List) ois.readObject();//从文件中读取信息存入list2集合

        for (User u : list2) {
            System.out.println(u);

        }

        try {//socket 编程

            ServerSocket ss = new ServerSocket(8384);

            Socket socket = ss.accept();

            InputStream is = socket.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String s;

            String str[] = new String[2];//用户名和信息存入字符串数组以便和文件中数据比较判断用户信息的正确性

            int t = 0;

            while ((s = br.readLine()) != null) {
                str[t++] = s;

                System.out.println(s);

            }

            // 响应客户端

            String flag = "no";

            for (User u : list2) {
                //判断用户信息的正确性
                if (u.getUsername().equals(str[0].trim()) && u.getPassword().equals(str[1].trim())) {
                    flag = "yes";

                }

            }

            OutputStream os = socket.getOutputStream();

            os.write(flag.getBytes());//与客户端交互

            os.close();

            br.close();

            is.close();

            ss.close();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }

}
