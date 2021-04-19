package com.org.project.framework;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public abstract class FrameworkParameters {
	
	//Global Congifurations
	public static Properties property=new Properties();
	public static FileInputStream globalConfigFile;
	
	
	//Webdriver Parameters
	public static WebDriver driver;
	public static ChromeOptions chromeOptions=new ChromeOptions();
	public static FirefoxOptions firefoxOptions=new FirefoxOptions();
	public static InternetExplorerOptions ieOptions=new InternetExplorerOptions();
	public static EdgeOptions edgeOptions=new EdgeOptions();
	
	
	//Excel parameters
	public static Fillo RunmanagerFillo=new Fillo();
	public static Fillo TestDatafillo=new Fillo();
	public static Recordset RunManagerRecordSet;
	public static Recordset TestDataRecordSet;
	public static Connection ConnectRunManager;
	public static Connection ConnectTestData;
	
	
	
	
	
	

}
