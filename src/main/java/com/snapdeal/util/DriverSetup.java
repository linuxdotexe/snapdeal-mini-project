package com.snapdeal.util;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup {
	
	// Method to setup Chrome driver.
	public static WebDriver getChromeDriver() {
		WebDriverManager.chromedriver().setup();
		// Prevents 403 access denied error.
		ChromeOptions options = new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	// Method to setup Edge driver.
	public static WebDriver getEdgeDriver() {
		WebDriverManager.edgedriver().setup();
		// Prevents 403 access denied error.
		EdgeOptions options = new EdgeOptions();
		options.addArguments("remote-allow-origins=*");
		WebDriver driver = new EdgeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
}
