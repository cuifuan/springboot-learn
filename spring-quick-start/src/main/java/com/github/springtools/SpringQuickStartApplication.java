package com.github.springtools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 这里的@RestController相当于 @ResponseBody+@Controller
 * 使用@RestController 相当于使每个方法都加上了 @ResponseBody 注解
 **/
@RestController
@SpringBootApplication
public class SpringQuickStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringQuickStartApplication.class, args);
    }

    /**
     * 这里的@GetMapping相当于@RequestMapping(value = "/hello", method = RequestMethod.GET)
     **/
    @GetMapping("hello")
    public String halo() {
        return "hello world";
    }
}
