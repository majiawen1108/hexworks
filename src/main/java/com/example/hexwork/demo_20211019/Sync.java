package com.example.hexwork.demo_20211019;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author jw.ma
 * @title: Sync
 * @description: TODO
 * @date 2021/10/19 23:26
 */
public class Sync extends AbstractQueuedSynchronizer {
    @Override
    protected int tryAcquireShared(int arg) {
        return (getState() == 1) ? 1 : -1;
    }

    @Override
    protected boolean tryReleaseShared(int arg) {
        setState(1);
        return true;
    }
}
