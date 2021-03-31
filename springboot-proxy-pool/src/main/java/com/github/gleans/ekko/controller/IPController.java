package com.github.gleans.ekko.controller;

import com.github.gleans.ekko.common.ResultBean;
import com.github.gleans.ekko.model.IPData;
import com.github.gleans.ekko.service.IPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ip")
public class IPController {

    private IPService ipService;

    @Autowired
    public void setIpService(IPService ipService) {
        this.ipService = ipService;
    }

    @GetMapping("list")
    public ResultBean<List<IPData>> getIpList() {
        return new ResultBean<>(ipService.getIpList());
    }

}
