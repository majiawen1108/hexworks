package com.example.hexwork.demo_20211019;

/**
 * @author jw.ma
 * @title: MyCountDownLatch
 * @description: TODO
 * @date 2021/10/19 23:25
 */
public class MyCountDownLatch {
    private final Sync sync = new Sync();

    //释放方法
    public void countDown() {
        sync.releaseShared(0);
    }

    //获取方法
    public void await() {
        sync.acquireShared(0);
    }

}
