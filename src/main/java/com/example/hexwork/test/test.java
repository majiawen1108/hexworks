package com.example.hexwork.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jw.ma
 * @title: test
 * @description: TODO
 * @date 2021/11/15 16:37
 */
public class test {
    public static void main(String[] args) {
        List<demo> demos = addMasg();
        int size = demos.size();
        int out = size % 3;
        int count = (int) Math.floor(size / 3);
        int first = count + out + 1;
        List<demo> demos1 = demos.subList(0, first);
        int second = demos1.size()+count+1;
        if (second >demos.size()){
            second = demos.size();
        }
        List<demo> demos2 = demos.subList(demos1.size(), second);
        int third = second +count+1;
        if (third > demos.size()){
            third = demos.size();
        }
        List<demo> demos3 = demos.subList(demos2.size() + demos1.size(), third);
        System.out.println(demos1.toString());
        System.out.println(demos2.toString());
        System.out.println(demos3.toString());

    }

    private static List<demo> addMasg(){
        List<demo> list  = new ArrayList<>();
        demo d1 = new demo();
        d1.setCaseNo("11111");
        d1.setName("001");
        demo d2 = new demo();
        d2.setCaseNo("2222");
        d2.setName("002");
        demo d3 = new demo();
        d3.setCaseNo("3333");
        d3.setName("003");
        demo d4 = new demo();
        d4.setCaseNo("44444");
        d4.setName("004");
        demo d5 = new demo();
        d5.setCaseNo("55555");
        d5.setName("005");
        demo d6 = new demo();
        d6.setCaseNo("6666");
        d6.setName("006");
        demo d7 = new demo();
        d7.setCaseNo("7777");
        d7.setName("007");
        demo d8 = new demo();
        d8.setCaseNo("88888");
        d8.setName("008");
        list.add(d1);
        list.add(d2);
        list.add(d3);
        list.add(d4);
        list.add(d5);
        list.add(d6);
        list.add(d7);
        list.add(d8);
        return list;
    }
}
