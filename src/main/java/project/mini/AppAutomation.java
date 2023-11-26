package project.mini;

import java.util.ArrayList;
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
			driver = ChromeDriverSetup.getWebDriver();
		}
		else {
//			driver = EdgeDriverSetup.getWebDriver();
		}
		return driver;
	}
	
	public static void search(String data) {
		driver.manage().window().maximize();
		driver.get("https://www.snapdeal.com/");
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
	
	public static void returnTopFive() {
		List<WebElement> nameElements = driver.findElements(By.className("product-title"));
		List<String> names = new ArrayList<String>();
		for (WebElement name: nameElements) {
			names.add(name.getText());
		}
		
		List<WebElement> priceElements = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		List<String> prices = new ArrayList<String>();
		for (WebElement price: priceElements) {
			prices.add(price.getText());
		}
		
		Map<String, String> nameAndPrice = new HashMap<String, String>();
		for (Map.Entry<String, String> entry : nameAndPrice.entrySet()) {
			System.out.println(entry.getKey() + entry.getValue());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = AppAutomation.setupDriver("chrome");
		AppAutomation.search("Bluetooth headphone");
		AppAutomation.sort();
		AppAutomation.returnTopFive();

	}

}
