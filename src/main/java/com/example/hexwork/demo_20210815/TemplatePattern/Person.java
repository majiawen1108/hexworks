package com.example.hexwork.demo_20210815.TemplatePattern;

/**
 * @author jw.ma
 * @title: Person
 * @description: TODO
 * @date 2021/8/16 20:44
 */
public class Person {
    public static void main(String[] args) {
        station xiaming = new BackToNanJiing();
        xiaming.gohome();
        station xiaohua = new BackToXinYang();
        xiaohua.gohome();
    }
}
