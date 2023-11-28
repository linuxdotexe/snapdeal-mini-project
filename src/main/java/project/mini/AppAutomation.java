package project.mini;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AppAutomation {
	
	public static WebDriver driver;
	
	public static WebDriver setupDriver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = DriverSetup.getChromeDriver();
		}
		else {
			driver = DriverSetup.getEdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
		return driver;
	}
	
	public static void search(String data) {
		driver.findElement(By.id("inputValEnter")).sendKeys(data);
		driver.findElement(By.xpath("//button[contains(@class, 'searchformButton')]")).click();
	}
	
	public static void sort() {
		
		driver.findElement(By.xpath("//div[contains(@class, 'sort-drop')]")).click();
		driver.findElement(By.xpath("//*[@id=\"content_wrapper\"]/div[7]/div[5]/div[3]/div[1]/div/div[2]/ul/li[2]")).click();
		
		WebElement fromVal = driver.findElement(By.name("fromVal"));
		fromVal.clear();
		fromVal.sendKeys("700");
		
		WebElement toVal = driver.findElement(By.name("toVal"));
		toVal.clear();
		toVal.sendKeys("1400");
		
		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
	}
	
	public static Map<String, String> returnTopFive() throws Exception {
		Thread.sleep(2000);
		List<WebElement> nameAndPrice = driver.findElements(By.className("product-tuple-description"));
		Map<String, String> namesAndPricesMap = new HashMap<String, String>();
		for (int i=0; i<5; i++) {
			String productText[] = nameAndPrice.get(i).getText().split("\n");
			namesAndPricesMap.put(productText[0], productText[2]);
		}
		// System.out.println(namesAndPricesMap);
		return namesAndPricesMap;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		driver = AppAutomation.setupDriver("chrome");
		String inputData = ImportInputData.getExcelData();
		AppAutomation.search(inputData);
		AppAutomation.sort();
		AppAutomation.returnTopFive();
		driver.close();

	}

}
