package project.mini;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ImportInputData {
	
	public static String getExcelData() throws Exception {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\Input.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		String data = sheet.getRow(0).getCell(0).toString();
		workbook.close();
		file.close();
		return data;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(ImportInputData.getExcelData());

	}

}
