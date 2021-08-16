package com.example.hexwork.demo_20210815.ProxyHandler;

/**
 * @author jw.ma
 * @title: person
 * @description: TODO
 * @date 2021/8/16 21:05
 */
public class person implements station{
    public void station(){
        this.getNumber();
        this.lineUp();
        this.ticket();
        this.train();
    }
    @Override
    public void getNumber() {
        System.out.println("取号");
    }

    @Override
    public void lineUp() {
        System.out.println("排队");
    }

    @Override
    public void ticket() {
        System.out.println("购票");
    }

    @Override
    public void train() {
        System.out.println("乘车");
    }
}
