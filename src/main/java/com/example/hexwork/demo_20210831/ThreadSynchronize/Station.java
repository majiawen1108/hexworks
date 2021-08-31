package com.example.hexwork.demo_20210831.ThreadSynchronize;

/**
 * @author jw.ma
 * @title: Station
 * @description: 车站买票案例
 * @date 2021/9/1 00:18
 */
public class Station {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        //创建三个窗口对象
        Thread t1 = new Thread(ticket, "窗口1");
        Thread t2 = new Thread(ticket, "窗口2");
        Thread t3 = new Thread(ticket, "窗口3");
        //卖票
        t1.start();
        t2.start();
        t3.start();
    }
}
