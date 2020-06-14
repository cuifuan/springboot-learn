package com.github.ekko.springtools.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Whours {
    // 14日20时
    private String day;
    //中雨
    private String wea;
    //28℃ 实时温度
    private String tem;
    //无持续风向
    private String win;
    // 风速 3-4级
    private String winSpeed;
}
