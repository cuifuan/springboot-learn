package com.github.ekko.springtools.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Weather {
    private String day;
    private String date;
    private String week;
    //天气情况
    private String wea;
    private String weaImg;
    private String air;
    private String humidity;
    // 空气质量 优
    private String airLevel;
    // 空气质量描述：空气很好，可以外出活动，呼吸新鲜空气，拥抱大自然
    private String airTips;
    private String tem1;
    private String tem2;
    private String tem;

    private List<Whours> hours;
}
