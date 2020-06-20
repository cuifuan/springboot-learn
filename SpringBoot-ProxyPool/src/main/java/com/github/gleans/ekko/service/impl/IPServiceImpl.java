package com.github.gleans.ekko.service.impl;

import com.github.gleans.ekko.model.IPData;
import com.github.gleans.ekko.service.IPService;
import com.github.gleans.ekko.utils.HttpCustom;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
public class IPServiceImpl implements IPService {


    @Override
    public List<IPData> getIpList() {
        String html = HttpCustom.getIpStore("https://www.xicidaili.com/nn/1", null, null);
        //将html解析成DOM结构
        Document document = Jsoup.parse(html);

        //提取所需要的数据
        Elements trs = document.select("table[id=ip_list]").select("tbody").select("tr");

        if (null == trs || trs.size() == 0) {
            return new ArrayList<>();
        }

        return trs.stream()
                .map(tr -> {
                    Elements trd = tr.select("td");
                    if (trd != null && trd.size() > 0) {
                        String country = tr.select("td").get(0).text();
                        String ipAddress = tr.select("td").get(1).text();
                        Integer port = Integer.valueOf(tr.select("td").get(2).text());
                        String serverAddress = tr.select("td").get(3).text();
                        String anonymous = tr.select("td").get(4).text();
                        String ipType = tr.select("td").get(5).text();
                        String speed = tr.select("td").get(6).select("div[class=bar]").attr("title");

                        return new IPData().setIpAddress(ipAddress)
                                .setPort(port).setType(ipType)
                                .setCountry(country).setSpeed(speed)
                                .setAnonymous(anonymous).setServerAddress(serverAddress);
                    } else {
                        return null;
                    }

                }).filter(Objects::nonNull).collect(Collectors.toList());
    }
}
