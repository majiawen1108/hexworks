package com.example.hexwork.demo_20211019;

import java.util.concurrent.TimeUnit;

/**
 * @author jw.ma
 * @title: testMain
 * @description: 模拟联盟等待玩家准备
 * @date 2021/10/19 23:28
 */
public class testMain {

    //游戏开始倒计时
    private static MyCountDownLatch countDownLatchStart = new MyCountDownLatch();


    static class Runner implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "开始准备");
            countDownLatchStart.await();
            System.out.println(Thread.currentThread().getName() + "开始游戏");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runner(), "亚瑟").start();
        new Thread(new Runner(), "卡莎").start();
        new Thread(new Runner(), "阿卡丽").start();
        new Thread(new Runner(), "皇子").start();
        new Thread(new Runner(), "剑圣").start();
        //给足时间让玩家加载游戏
        TimeUnit.SECONDS.sleep(5);
        System.out.println("进入游戏!");
        countDownLatchStart.countDown();
    }
}
