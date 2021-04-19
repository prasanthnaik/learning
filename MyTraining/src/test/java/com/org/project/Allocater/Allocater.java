package com.org.project.Allocater;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import com.org.framework.ConfigurationUtilities;
import com.org.framework.ScreenshotUtility;
import com.org.framework.WebDriverFactory;
import com.org.framework.DataDrivenUtility.ExcelUtilities;
import com.org.framework.DataDrivenUtility.FilloUtility;
import com.org.project.Actions.UserActions;
import com.org.project.BussinessLogic.Guru;
import com.org.project.pageObjects.Gurupage;



public class Allocater extends WebDriverFactory{
	public Allocater() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	static UserActions action;
	Gurupage guruPageObj= new Gurupage();
	//static WebDriverFactory webDriverFactory=new WebDriverFactory();

	//public static Recordset rs;
	public static void main(String[] args) throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, InterruptedException {

		FilloUtility filloUtil=new FilloUtility();

		rs=filloUtil.getRecordSet();

		Guru guru=new Guru();
		ScreenshotUtility screenshot=new ScreenshotUtility();
		String test;
		//Recordset rs=FilloUtility.AllRecords; 
		try { 

			while(rs.next()) {

				test=rs.getField("TestSuite");
				
				action=new UserActions();
				launchDriver();
				System.out.println("BrowserOpened");
				action.launchApplication(); 
				action.enterText(Gurupage.textfield,test);
				//int b =9/0;
				guru.commentsBox();
				
				action.clickElement(Gurupage.checkBox);
				screenshot.takeScreenshot(driver, "C:\\SeleniumFrame\\MyTraining\\src\\main\\resources\\Screenshots\\"+test+".png");
				Thread.sleep(3000);
				
				System.out.println("DONE");
				driver.quit();
			}
		} 

		catch (Exception e) {
				e.printStackTrace();
				screenshot.takeScreenshot(driver, "C:\\SeleniumFrame\\MyTraining\\src\\main\\resources\\Screenshots\\failed.png");
				
		}




		/*Class c=com.org.framework.WebDriverFactory.class;
		Method[] method=c.getDeclaredMethods();
		for(Method MethodName:method) {
			System.out.println(MethodName.getName());
			if(MethodName.getName().equals("launchDriver")) {
				MethodName.invoke(null, null);
			}

		}*/


		/*
		 * action=new UserActions();
		 * 
		 * launchDriver();
		 * 
		 * action.launchApplication(); action.enterText(Gurupage.textfield, "Prasanth");
		 * action.clickElement(Gurupage.checkBox);
		 */
	}

}
