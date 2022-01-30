package com.example.hexwork.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

/**
 * @author jw.ma
 * @title: demo
 * @description: TODO
 * @date 2022/1/14 12:34
 */
public class demo {
    public static void main(String[] args) {

        Double a = 0.0000000001;
        System.out.println(a);
        System.out.println(BigDecimal.valueOf(a));

        NumberFormat nf = NumberFormat.getInstance();
        BigDecimal d = BigDecimal.valueOf(a);
        nf.setRoundingMode(RoundingMode.UNNECESSARY);
        nf.setMaximumFractionDigits(100);
        String format = nf.format(d);
        System.out.println(nf.format(d));
    }
}
