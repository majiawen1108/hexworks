package com.example.hexwork.demo_20210928;

/**
 * @author jw.ma
 * @title: demo1
 * @description: TODO
 * @date 2021/9/29 16:46
 */
public class demo1 {

    public static void main(String[] args) throws InterruptedException {
        client foo = new client();

        for(int i = 0; i < 3; i++){
            if(i == 0){
                foo.first(()-> System.out.println("first"));
            }else if(i == 1){
                foo.second(()-> System.out.println("second"));
            }else if(i == 2){
                foo.third(()-> System.out.println("third"));
            }
        }
    }
}
