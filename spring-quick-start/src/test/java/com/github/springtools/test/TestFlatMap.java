package com.github.springtools.test;

import com.google.common.collect.ImmutableList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestFlatMap {
    public static void main(String[] args) {
        /*
         *  匹配到姓马的并去重然后放入一个新的集合中
         */
        List<String> nameListA = ImmutableList.of("素云云", "马云云", "腾花花", "阿娇娇", "马飞飞", "廖妹妹");
        List<String> nameListB = ImmutableList.of("素云涛", "唐三三", "小五五", "马中山", "马僻静", "马肥羊");
        List<String> nameListC = ImmutableList.of("张三", "李四", "王二", "麻子", "上官玩儿", "马可菠萝");
        Set<String> nameSet = new HashSet<>();
        nameListA.forEach(n -> {
            if (n.startsWith("马")) {
                nameSet.add(n);
            }
        });
        nameListB.forEach(n -> {
            if (n.startsWith("马")) {
                nameSet.add(n);
            }
        });
        nameListC.forEach(n -> {
            if (n.startsWith("马")) {
                nameSet.add(n);
            }
        });
        System.out.println(nameSet.toString());
    }
}