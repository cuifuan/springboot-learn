package com.github.cuifuan.mail.service;

import com.github.cuifuan.mail.model.Weather;

import java.util.List;

public interface EmailService {
    boolean sendSimpleMessage();

    List<Weather> getWeather();
}
