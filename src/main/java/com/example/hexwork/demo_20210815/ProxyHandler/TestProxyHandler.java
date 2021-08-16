package com.example.hexwork.demo_20210815.ProxyHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author jw.ma
 * @title: TestProxyHandler
 * @description: TODO
 * @date 2021/8/16 20:58
 */
public class TestProxyHandler {
    public static void main(String[] args) {
        station station = new person();
        InvocationHandler handler = new ProxyHandler(station);
        station proxyStation = (station) Proxy.newProxyInstance(station.getClass().getClassLoader(), station.getClass().getInterfaces(), handler);
        proxyStation.getNumber();
        proxyStation.lineUp();
        proxyStation.ticket();
        proxyStation.train();
    }
}
