package com.github.ekko.springtools.controller;

import com.github.ekko.springtools.model.Weather;
import com.github.ekko.springtools.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableScheduling
public class MailController {

    private EmailService emailService;

    @Autowired
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/send")
    @Scheduled(cron = "0 0 23 * * ? ")
    public boolean sendEmail() {
        return emailService.sendSimpleMessage();
    }

    @GetMapping("get-weather")
    public List<Weather> getWeather() {
        return emailService.getWeather();
    }
}
