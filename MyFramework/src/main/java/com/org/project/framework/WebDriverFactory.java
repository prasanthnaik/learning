package com.org.project.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory extends FrameworkParameters{

	public WebDriverFactory() {
		// TODO Auto-generated constructor stub
	}
	static Configurations globalConfig=new Configurations();
	public static void launchWebDriver() {
		String Browser=globalConfig.getGlobalProperty("Browser");
		switch (Browser.toUpperCase()) {
		case "CHROME":
			WebDriverManager.chromedriver().setup();
			chromeOptions.addArguments("headless");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "FIREFOX":
			WebDriverManager.firefoxdriver().setup();
			firefoxOptions.addArguments("headless");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		case "EDGE":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			break;
		default:
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
			break;
		}
		
	}

}
