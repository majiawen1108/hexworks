package com.example.hexwork.personal_20211225;

import java.util.concurrent.CountDownLatch;

/**
 * 计数器 当countDownLatch为0的时候会执行阻塞的线程
 * @author jw.ma
 * @title: test_countDownLatch
 * @description: TODO
 * @date 2021/12/25 17:08
 */
public class test_countDownLatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName() + "\t上完自习，离开教室");
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "班长最后走，关好门");
    }
}
