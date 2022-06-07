package store.zabbix.bran.ekko.service;

import store.zabbix.bran.ekko.common.ResultBean;
import store.zabbix.bran.ekko.model.IPData;

import java.util.List;

public interface IPService {
    List<IPData> getIpList();
}
