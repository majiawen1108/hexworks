package com.example.hexwork.demo_20210831.ThreadSynchronize;

/**
 * @author jw.ma
 * @title: Ticket
 * @description: TODO
 * @date 2021/9/1 00:15
 */
public class Ticket implements Runnable {
    private int ticket = 100;
    Object object = new Object();
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        while (true) {
            sell(name);
            if (ticket <= 0) {
                break;
            }
        }
    }
    private void sell(String name) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (object){
            if (ticket > 0) {
                System.out.println(name + "卖票，余票还剩：" + ticket);
                ticket--;
            }
        }

    }

}
