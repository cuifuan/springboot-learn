package com.github.gleans.ekko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class SpringBootProxyPoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootProxyPoolApplication.class, args);
    }

}
