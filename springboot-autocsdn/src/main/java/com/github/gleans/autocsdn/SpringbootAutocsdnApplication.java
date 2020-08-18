package com.github.gleans.autocsdn;

import com.github.gleans.autocsdn.utils.CSDNUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringbootAutocsdnApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAutocsdnApplication.class, args);
        load();
    }

    @GetMapping("ref")
    public static void load() {
        CSDNUtils csdnUtils = new CSDNUtils();
        csdnUtils.autoRefresh("https://blog.csdn.net/Fine_Cui", 50);
    }

}
