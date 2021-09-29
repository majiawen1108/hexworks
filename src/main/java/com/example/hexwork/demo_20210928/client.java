package com.example.hexwork.demo_20210928;

import java.util.concurrent.Semaphore;

/**
 * @author jw.ma
 * @title: client
 * @description: TODO
 * @date 2021/9/29 16:46
 */
public class client {
    Semaphore semaphore2 = new Semaphore(0);
    Semaphore semaphore3 = new Semaphore(0);

    public client() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        semaphore2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphore2.acquire();
        printSecond.run();
        semaphore3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        semaphore3.acquire();
        printThird.run();
    }
}
