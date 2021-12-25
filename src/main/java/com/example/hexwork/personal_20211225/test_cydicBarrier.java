package com.example.hexwork.personal_20211225;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 等待线程数到达cyclicBarrier设置的值后才执行目标线程，与countDownLatch不同的是cyclicBarrier可以重复使用，调用reset()方法即可
 * @author jw.ma
 * @title: test_cydicBarrier
 * @description: TODO
 * @date 2021/12/25 17:19
 */
public class test_cydicBarrier {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,() ->{
            System.out.println("七颗龙珠收集齐了，可以召唤神龙了");
        });

        for (int i = 1; i <= 7; i++) {
            final int count = i;
            new Thread(() ->{
                System.out.println("收集到了第"+ count +"号龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
