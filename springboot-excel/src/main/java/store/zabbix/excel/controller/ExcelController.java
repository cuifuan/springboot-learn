package store.zabbix.excel.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.zabbix.excel.utils.ExcelUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;

@RequestMapping("/api/v1/excel")
@RestController
public class ExcelController {
    /**
     * 导出模板
     */
    @GetMapping("export")
    public void export(HttpServletResponse response) throws IOException {
        LinkedHashMap<String, String> titleMap = new LinkedHashMap<>(16);
        titleMap.put("id", "编号");
        titleMap.put("name", "姓名");
        titleMap.put("sex", "性别");
        titleMap.put("age", "年龄");
        ExcelUtil.exportExcel(response,
                titleMap,
                null,
                "sheet",
                "Excel模板");
    }
}
