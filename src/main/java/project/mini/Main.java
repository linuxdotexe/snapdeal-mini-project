package project.mini;

import java.util.Map;

import org.openqa.selenium.WebDriver;

public class Main {

	public static void main(String[] args) throws Exception {
		String inputData = ImportInputData.getExcelData();
		WebDriver driver = AppAutomation.setupDriver("chrome");
		AppAutomation.search(inputData);
		AppAutomation.sort();
		Map<String, String> outputData = AppAutomation.returnTopFive();
		OutputData.outputData(outputData);
		driver.close();

	}

}
