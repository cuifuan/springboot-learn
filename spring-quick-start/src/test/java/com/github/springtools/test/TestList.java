package com.github.springtools.test;

import com.google.common.collect.ImmutableList;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestList {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("jack");
        stringList.add("pony");
        stringList.add("ekko");

        List<String> stringList2 = new ArrayList<String>(4) {{
            add("jack");
            add("pony");
            add("ekko");
        }};


        List<String> stringList3 = ImmutableList.of("jack", "pony", "ekko");

        List<String> nameList = new ArrayList<>();
        List<String> noNullList = new ArrayList<>();
        nameList.add("jack");
        nameList.add("pony");
        nameList.add("ekko");
        nameList.add(null);
        for (String o : stringList) {
            if (o != null) {
                noNullList.add(o);
            }
        }
        List<String> noNullListFun = nameList
                .stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        List<BigDecimal> numList = new ArrayList<BigDecimal>(10) {{
            add(BigDecimal.valueOf(111L));
            add(BigDecimal.valueOf(8888.22));
            add(BigDecimal.valueOf(333.22));
            add(BigDecimal.valueOf(857857.22));
            add(BigDecimal.valueOf(5331.22));
        }};
        BigDecimal total = BigDecimal.ZERO;
        for (BigDecimal num : numList) {
            total = total.add(num);
        }
        System.out.println(total);

        List<BigDecimal> numListSimple = ImmutableList.of(BigDecimal.valueOf(111L)
                , BigDecimal.valueOf(8888.22), BigDecimal.valueOf(333.22)
                , BigDecimal.valueOf(857857.22), BigDecimal.valueOf(5331.22));
        BigDecimal totalNum = BigDecimal.valueOf(numListSimple.stream().mapToDouble(BigDecimal::doubleValue).sum());


        // 模拟调用服务
        String username = getUserName();
        String res;
        if (username != null) {
            res = username;
        } else {
            res = "游客";
        }
        String userName = Optional.ofNullable(username).orElse("游客");
        System.out.println(userName);

    }

    public static String getUserName() {
        return null;
    }
}
