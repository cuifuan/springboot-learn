package com.github.cuifuan.excel.service;

import com.github.cuifuan.excel.utils.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@Service
public class ExcelService {


    /**
     *  read Excel file
     * @param file 导入的 excel 文件
     * @return 读取到的数据
     * @throws Exception 过程中的报错信息
     */
    public List<List<String>> readExcel(MultipartFile file) throws Exception {
        return ExcelUtil.readExcel(file);
    }

}
