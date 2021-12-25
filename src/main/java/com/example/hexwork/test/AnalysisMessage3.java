package com.example.hexwork.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 */
public class AnalysisMessage3 {
    private static String serial_record = "户名|账号|币种|余额|可用余额|开户日期|账户类型|开户行|错误信息|成功标志" +
            "|XXX公司|310066661010121088868|CNY|85317882.08|85317882.08|19951117|1|310999||0" +
            "|XXX公司2|310066661010121088868|CNY|853178822.08|853178822.08|19951117|1|310999||0|";
    private static int field_num = 10;
    public static void main(String[] args) {
        List<Map<String,Object>> list=new ArrayList<>();
        String[] split = serial_record.split("\\|");
        int j=1;
        Map<String,Object> map=new HashMap<>();
        for(int i=0;i<field_num;i++){
            map.put(split[i],split[j*field_num+i]);
            //一条记录遍历完
            if(i==9){
                Map<String,Object> copyMap = new HashMap<>();
                copyMap.putAll(map);
                list.add(copyMap);
                map.clear();
                //跳出循环
                if(j*field_num+i>=split.length-1){
                    break;
                }
                j++;
                i=-1;
            }
        }


        System.out.println(list);;
    }
}