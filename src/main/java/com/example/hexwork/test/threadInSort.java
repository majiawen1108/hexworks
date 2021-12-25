package com.example.hexwork.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * countDownLatch控制线程顺序
 * @author jw.ma
 * @title: threadInSort
 * @description: TODO
 * @date 2021/12/25 15:50
 */
public class threadInSort {
    static class Task implements Runnable {

        private CountDownLatch countDownLatch;

        private String name;

        public Task(CountDownLatch countDownLatch, String name) {
            this.countDownLatch = countDownLatch;
            this.name = name;
        }

        @Override
        public void run() {
            if ("A".equals(name)) {
                try {
                    this.countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(name + "线程" + i);
            }
            this.countDownLatch.countDown();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Task task1 = new Task(countDownLatch,"A");
        Task task2 = new Task(countDownLatch,"B");
        executorService.execute(task1);
        executorService.execute(task2);
        executorService.shutdown();

    }
}
