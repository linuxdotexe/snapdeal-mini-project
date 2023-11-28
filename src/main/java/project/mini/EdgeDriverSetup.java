package project.mini;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeDriverSetup {
	
	public static WebDriver getWebDriver() {
		WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();
		options.addArguments("remote-allow-origins=*");
		WebDriver driver = new EdgeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		EdgeDriverSetup.getWebDriver();

	}

}
