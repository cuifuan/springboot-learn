package com.github.cuifuan.excel.controller;


import com.github.cuifuan.excel.service.ExcelService;
import com.github.cuifuan.excel.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

@RequestMapping("/api/v1/excel")
@RestController
public class ExcelController {

    private ExcelService excelService;

    @Autowired
    public void setExcelService(ExcelService excelService) {
        this.excelService = excelService;
    }

    /**
     * 导出模板
     */
    @RequestMapping("export")
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

    /**
     * Import an Excel file
     */
    @PostMapping("import")
    public List<List<String>> importExcelData(@RequestParam("file") MultipartFile file) throws Exception {
        return excelService.readExcel(file);
    }
}
