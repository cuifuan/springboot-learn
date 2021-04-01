package com.github.luca;

import com.github.luca.utils.ExcelUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootExcelApplicationTests {

	@Test
	void contextLoads() throws Exception {
		List<List<String>> dataList = ExcelUtil.readExcel("C:\\Users\\Dynasty\\Documents\\springboot-learn\\springboot-excel\\src\\main\\resources\\employees.xlsx");
		ExcelUtil.exportExcel(dataList);
	}

}
