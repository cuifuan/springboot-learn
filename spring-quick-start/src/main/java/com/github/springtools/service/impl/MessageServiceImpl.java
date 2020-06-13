package com.github.springtools.service.impl;

import com.github.springtools.model.WxXmlData;
import com.github.springtools.service.MessageService;
import com.thoughtworks.xstream.XStream;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Slf4j
@Service
public class MessageServiceImpl implements MessageService {

    @Override
    public WxXmlData resolveXmlData(InputStream in) throws IOException {
        String xmlData = FileUtils.getInputToString(in);
        log.info("【receive  xmlData str : {}】", xmlData);
        WxXmlData wxXmlData = null;
        try {
            XStream xstream = new XStream();
            //这个必须要加 不然无法转换成WxXmlData对象
            xstream.setClassLoader(WxXmlData.class.getClassLoader());
            xstream.processAnnotations(WxXmlData.class);
            xstream.alias("xml", WxXmlData.class);
            wxXmlData = (WxXmlData) xstream.fromXML(xmlData);
            log.info("【wxXmlData: {}】 ", wxXmlData);
        } catch (Exception e) {
            log.error("【error】{}", e.getMessage());
        }
        return wxXmlData;
    }

    @Override
    public String autoResponse(WxXmlData wxData) {


        WxXmlData resultXmlData = new WxXmlData();
        resultXmlData.setToUserName(wxData.getFromUserName());  //收到的消息是谁发来的再发给谁
        resultXmlData.setFromUserName(wxData.getToUserName());  //
        if (!StringUtils.isEmpty(wxData.getEvent())) {
            if (WxSubscribeEnum.SUBSCRIBE.getValue().equals(wxData.getEvent())) {
                resultXmlData.setMsgType("text");
                resultXmlData.setCreateTime(System.currentTimeMillis());
                resultXmlData.setContent("欢迎来到Johnny屋,本公众号会定期更新技术干货,愿与 读者共同成长。\n\n" +
                        "-<a href=\"https://www.askajohnny.com\">我的博客(建议PC端打开,移动端适配正在紧张开发中)</a>");
            }
        } else if (wxData.getContent().equalsIgnoreCase("vip")) {
            resultXmlData.setMsgType("text");
            resultXmlData.setCreateTime(System.currentTimeMillis());
            resultXmlData.setContent("<a href=\"https://my.openwrite.cn/code/generate?blogId=18931-1576559666626-322\">点击该链接，获取博客解锁验证码</a>");
        } else {
            resultXmlData.setMsgType("text");
            resultXmlData.setCreateTime(System.currentTimeMillis());
            resultXmlData.setContent("公众号正在开发中。后期请多多关注！");
        }
        XStream xstream = new XStream();
        xstream.processAnnotations(WxXmlData.class);
        xstream.setClassLoader(WxXmlData.class.getClassLoader());
        return xstream.toXML(resultXmlData);  //XStream的方法，直接将对象转换成 xml数据
    }
}
