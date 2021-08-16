package com.example.hexwork.demo_20210815.TemplatePattern;

/**
 * @author jw.ma
 * @title: BackToNanJiing
 * @description: TODO
 * @date 2021/8/16 20:40
 */
public class BackToNanJiing extends station{

    @Override
    void ticket() {
        System.out.println("买一张去南京的车票！");
    }

    @Override
    void train() {
        System.out.println("乘坐去南京的火车！");
    }
}
