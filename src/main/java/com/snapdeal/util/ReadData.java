package com.snapdeal.util;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {

	// Reads data from Input.xlsx
	public static String getExcelData() throws Exception {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\Input.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		String data = sheet.getRow(0).getCell(0).toString();
		workbook.close();
		file.close();
		return data;
	}
}
