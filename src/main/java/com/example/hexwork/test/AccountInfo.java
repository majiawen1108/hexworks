package com.example.hexwork.test;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author jw.ma
 * @title: AccountInfo
 * @description: TODO
 * @date 2021/11/25 10:27
 */
@Data
public class AccountInfo {
//    户名|账号|币种|余额|可用余额|开户日期|账户类型|开户行|错误信息|成功标志|XXX公司|
    private String accountName;
    private String accountNo;
    private String currency;
    private BigDecimal balance;
    private BigDecimal availableBalance;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date openDate;
    private String type;
    private String openBank;
    private String errMsg;
    private String sucSign;
}
