package store.zabbix.ekko.springtools.service;

import store.zabbix.ekko.springtools.model.Weather;

import java.util.List;

public interface EmailService {
    boolean sendSimpleMessage();

    List<Weather> getWeather();
}
