package com.example.hexwork.personal_20211225;

import java.util.concurrent.TimeUnit;

/**
 * @author jw.ma
 * @title: test_deadLock
 * @description: 一个死锁的案例
 * 定位死锁问题的方法是：1、jps -l 查看java进程；2、jstack 进程号：查看该进程中情况分析
 * @date 2021/12/26 13:43
 */
public class test_deadLock {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new newThread(lockA,lockB),"ThreadA").start();
        new Thread(new newThread(lockB,lockA),"ThreadB").start();
    }
}

class newThread implements Runnable{
    private String lockA;
    private String lockB;

    public newThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"拥有锁"+lockA+"尝试获取"+lockB );
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"拥有锁"+lockB+"尝试获取"+lockA );
            }
        }
    }
}
