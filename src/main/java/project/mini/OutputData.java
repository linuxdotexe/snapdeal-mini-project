package project.mini;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class OutputData {
	
	public static void outputData (Map<String, String> data) throws Exception {
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\Output.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Output");
		
		List<String> keys = new ArrayList<String>();
		List<String> values = new ArrayList<String>();
		
		for (Map.Entry<String, String> entry : data.entrySet()) {
			keys.add(entry.getKey());
			values.add(entry.getValue());
		}
		
		for (int i=0; i<5; i++) {
			XSSFRow row = sheet.createRow(i);
			row.createCell(0).setCellValue(keys.get(i));
			row.createCell(1).setCellValue(values.get(i));
		}
		workbook.write(file);
		workbook.close();
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	}

}
