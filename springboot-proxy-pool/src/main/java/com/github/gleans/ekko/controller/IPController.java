package store.zabbix.bran.ekko.controller;

import store.zabbix.bran.ekko.common.ResultBean;
import store.zabbix.bran.ekko.model.IPData;
import store.zabbix.bran.ekko.service.IPService;
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
