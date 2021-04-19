package com.org.framework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class WebDriverFactory extends dataDrivenAbstract{
	public static WebDriver driver=null;
	static ConfigurationUtilities globalProperties;
	public WebDriverFactory() throws IOException {
		
		
	}
	
	public static void launchDriver() throws IOException {
		globalProperties=new ConfigurationUtilities();
		String Browser=globalProperties.getGlobalProperty("Browser");
		switch (Browser.toUpperCase()) {
			case "CHROME":
				ChromeOptions options=new ChromeOptions();
				options.addArguments("headless");
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver(options);
				break;
			case "FIREFOX":
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				break;
			case "EDGE":
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
				break;
				
			default:
				WebDriverManager.iedriver().setup();
				driver=new InternetExplorerDriver();
		}
	
		
	}
	

}
