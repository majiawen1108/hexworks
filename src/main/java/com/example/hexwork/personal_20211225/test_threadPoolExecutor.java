package com.example.hexwork.personal_20211225;

import java.util.concurrent.*;

/**
 * @author jw.ma
 * @title: test_threadPoolExecutor
 * @description: 手写线程池
 * 核心线程数、
 * 最大线程数、
 * 等待时间、
 * 时间单位、
 * 阻塞队列（可设置长度，默认最大）、
 * 线程工厂（一般用默认的）、
 * 拒绝策略（1、抛出异常；2、退回调用方执行；3、丢弃等待时间最长的；4、直接丢弃）
 * @date 2021/12/26 13:03
 */
public class test_threadPoolExecutor {

    public static void main(String[] args) {
        ExecutorService thread = new ThreadPoolExecutor(2,
                5,
                1l,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());

        try {
            for (int i = 0; i <= 100; i++) {
                thread.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            thread.shutdown();
        }
    }
}
