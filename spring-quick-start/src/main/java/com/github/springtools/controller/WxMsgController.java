package com.github.springtools.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class WxMsgController {
    /**
     * 微信成为开发者 接口
     * @param signature : 签名
     * @param timestamp : 时间戳
     * @param nonce     : 随机数
     * @param echostr   : 随机字符串
     * @return
     */
    @GetMapping("/authorize")
    public String authorize(@RequestParam("signature") String signature,
                            @RequestParam("timestamp") Long timestamp,
                            @RequestParam("nonce") String nonce,
                            @RequestParam("echostr") String echostr) {
        log.info("【signature：{}】", signature);
        log.info("【timestamp：{}】", timestamp);
        log.info("【nonce：{}】", nonce);
        log.info("【echostr：{}】", echostr);
        return echostr;
    }
}
