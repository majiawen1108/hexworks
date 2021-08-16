package com.example.hexwork.demo_20210815.TemplatePattern;

/**
 * @author jw.ma
 * @title: BackToXinYang
 * @description: TODO
 * @date 2021/8/16 20:43
 */
public class BackToXinYang extends station{
    @Override
    void ticket() {
        System.out.println("买一张去信阳的车票！");
    }

    @Override
    void train() {
        System.out.println("乘坐去信阳的火车！");
    }
}
