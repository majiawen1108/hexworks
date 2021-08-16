package com.example.hexwork.demo_20210815.TemplatePattern;

/**
 * @author jw.ma
 * @title: station
 * @description: TODO
 * @date 2021/8/16 20:33
 */
public abstract class station {

    public final void gohome() {
        getNumber();
        lineUp();
        ticket();
        train();
    }
    /**
     * 取号
     */
    public void getNumber(){
        System.out.println("进门先取一张号！");
    };

    /**
     * 排队
     */
    public void lineUp(){
        System.out.println("按照取得号有秩序的排队！");
    };

    /**
     * 买票
     */
    abstract void ticket();

    /**
     * 上车
     */
    abstract void train();
}
