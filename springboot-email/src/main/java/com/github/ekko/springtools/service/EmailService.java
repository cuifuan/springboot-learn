package com.github.ekko.springtools.service;

import com.github.ekko.springtools.model.Weather;

import java.util.List;

public interface EmailService {
    boolean sendSimpleMessage();

    List<Weather> getWeather();
}
