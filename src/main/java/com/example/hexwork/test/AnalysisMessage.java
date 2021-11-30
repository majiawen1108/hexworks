package com.example.hexwork.test;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 解析交行报文 映射到实体类
 * @author jw.ma
 * @title: AnalysisMessage
 * @description: TODO
 * @date 2021/11/25 10:24
 */
@Slf4j
public class AnalysisMessage {
    private static String serial_record = "户名|账号|币种|余额|可用余额|开户日期|账户类型|开户行|错误信息|成功标志|XXX公司|" +
            "310066661010121088868|CNY|85317882.08|85317882.08|19951117|1|310999||0|";
    private static int field_num = 10;

//    private static Map<String,String> nameMap = null;

    public static void main(String[] args) {
        //获取报文对应的名称和实体中的名称的关系映射
        Map<String, String> stringStringMap = setMapValue();
        //拆分报文
        String[] split = serial_record.split("\\|");
        //取出报文中key的部分
        List<String> keyList = Arrays.asList(split).subList(0, field_num);
        //取出报文中value的部分
        List<String> valueList = Arrays.asList(split).subList(field_num, split.length);
        //将key和value进行组合
        Map<String, String> newMsg = getNewMsg(keyList, valueList,stringStringMap);

        System.out.println(newMsg.toString());

        log.debug("=================");
        //将生成的关系map转成相应的实体类
        AccountInfo user = JSON.parseObject(JSON.toJSONString(newMsg), AccountInfo.class);

        System.out.println(user.toString());

        log.debug("=================");

    }

    /**
     * 将两个相同长度的数组重新组成一个map
     * @param arr1
     * @param arr2
     * @return Map<String,String> map
     */
    private static Map<String,String> getNewMsg(List arr1, List arr2,Map<String,String> nameMap){
        Map<String, String> stringObjectHashMap = new HashMap<>();
        for (int i = 0; i < field_num; i++) {
            stringObjectHashMap.put(nameMap.get(String.valueOf(arr1.get(i)).replace(" ","")),String.valueOf(arr2.get(i)));
        }
        return stringObjectHashMap;
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
