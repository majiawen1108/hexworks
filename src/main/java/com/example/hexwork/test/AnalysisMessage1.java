package com.example.hexwork.test;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * 解析交行报文 映射到实体类
 * @author jw.ma
 * @title: AnalysisMessage
 * @description: TODO
 * @date 2021/11/25 10:24
 */
@Slf4j
public class AnalysisMessage1 {
    private static String serial_record = "户名|账号|币种|余额|可用余额|开户日期|账户类型|开户行|错误信息|成功标志" +
            "|XXX公司|310066661010121088868|CNY|85317882.08|85317882.08|19951117|1|310999||0" +
            "|XXX公司2|310066661010121088868|CNY|853178822.08|853178822.08|19951117|1|310999||0|";
    private static int field_num = 10;

    private static Map<String,String> nameMap = null;

    public static void main(String[] args) {
        nameMap = setMapValue();
        //拆分报文
        String[] split = serial_record.split("\\|");
        List<String> strings = Arrays.asList(split);
        int count = split.length / field_num;
        List<Map<String, String>>  mapList = new ArrayList<>();
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<String> strings1 = strings.subList(i * field_num, (i == count - 1) ? strings.size(): (i + 1) * field_num);
            list.add(strings1);
            if (i>0){
                Map<String, String> newMsg = getNewMsg(list.get(0), list.get(i), field_num);//可替换成实体类
                mapList.add(newMsg);
            }
        }
        System.out.println(mapList.toString());

    }

   private static Map<String,String> getNewMsg(List arr1,List arr2,int fieldNum){
        Map<String,String> map = new HashMap<>();
       for (int i = 0; i < fieldNum; i++) {
            String key = String.valueOf(arr1.get(i)).replace(" ","");
            map.put(StringNameToNo(key), String.valueOf(arr2.get(i)));
       }
         return map;
   }

    private static String StringNameToNo(String name){
        return nameMap.get(name);
    }

    /**
     * 塞入中文和实体中字段的对应关系
     * @return map
     */
    private static Map<String,String> setMapValue(){
        Map<String,String> nameMap = new HashMap<>();
        nameMap.put("户名","accountName");
        nameMap.put("账号","accountNo");
        nameMap.put("币种","currency");
        nameMap.put("余额","balance");
        nameMap.put("可用余额","availableBalance");
        nameMap.put("开户日期","openDate");
        nameMap.put("账户类型","type");
        nameMap.put("开户行","openBank");
        nameMap.put("错误信息","errMsg");
        nameMap.put("成功标志","sucSign");
        return nameMap;
    }
}
