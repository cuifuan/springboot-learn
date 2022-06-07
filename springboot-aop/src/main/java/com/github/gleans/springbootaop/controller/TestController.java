package store.zabbix.bran.springbootaop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("test")
@RestController
public class TestController {

    @GetMapping("/before")
    public String before() {
        log.info("请求 test/before 接口");
        return "前置通知测试";
    }

    @GetMapping("/after")
    public String after() {
        log.info("请求 test/after 接口");
        return "后置通知测试";
    }

    @GetMapping("/error")
    public String error() {
        int a = 1/0;
        return "异常通知测试";
    }
}