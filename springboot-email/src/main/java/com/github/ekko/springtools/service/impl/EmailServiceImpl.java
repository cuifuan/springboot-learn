package com.github.ekko.springtools.service.impl;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.github.ekko.springtools.model.Weather;
import com.github.ekko.springtools.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmailServiceImpl implements EmailService {
    private final static String FROM_MAIL = "你的发送邮箱，和配置文件中相同";
    private final static String TO_MAIL = "接收人邮箱";
    private final static String APPID = "你申请的天气api的appid，自行替换";
    private final static String APPSECRET = "你申请的天气api的APPSECRET，自行替换";

    public JavaMailSender emailSender;

    @Autowired
    public void setEmailSender(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public boolean sendSimpleMessage() {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
            mimeMessageHelper.setTo(TO_MAIL);
            mimeMessageHelper.setFrom(FROM_MAIL);
            mimeMessageHelper.setSubject("今日份天气到了~~");
            mimeMessageHelper.setText(buildHtml(getWeather().get(0)), true);
            emailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Weather> getWeather() {
        HttpRequest httpRequest = HttpUtil.createGet("https://www.tianqiapi.com/api?version=v1&" + "appid=" + APPID + "&appsecret=" + APPSECRET + "&cityid=101020100");
        String res = httpRequest.execute().body();
        Object data = JSON.parseObject(res).get("data");

        return JSON.parseArray(JSON.toJSONString(data), Weather.class);
    }

    private String buildHtml(Weather weather) {
        StringBuffer html = new StringBuffer("");
        html.append("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta charset=\"utf-8\">\n" +
                "<title>文档标题</title>\n" +
                "</head><body>");
        if (weather.getWea().contains("雨")) {
            html.append("<h1>今日有雨，狗子请带伞！</h1>");
        }
        html.append("<hr/><h3>今日天气如下</h3><table><tr><th>时间</th><th>天气</th><th>温度</th></tr>");
        Optional.ofNullable(weather.getHours())
                .orElse(new ArrayList<>())
                .forEach(whours -> {
                    html.append("<tr><td>")
                            .append(whours.getDay())
                            .append("</td><td>")
                            .append(whours.getWea())
                            .append("</td><td>")
                            .append(whours.getTem())
                            .append("</td></tr>");
                });

        html.append("</table></body>" +
                "</html>");
        return html.toString();
    }
}
