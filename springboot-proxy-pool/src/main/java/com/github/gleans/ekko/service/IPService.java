package com.github.gleans.ekko.service;

import com.github.gleans.ekko.common.ResultBean;
import com.github.gleans.ekko.model.IPData;

import java.util.List;

public interface IPService {
    List<IPData> getIpList();
}
