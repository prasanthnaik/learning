package com.org.project.Commands;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.org.project.framework.Configurations;
import com.org.project.framework.WebDriverFactory;

public class UserActions extends WebDriverFactory{

	public UserActions() {
		super();
	}
	Configurations globalproperty=new Configurations();
	
	public void launchApplication() {
		String url=globalproperty.getGlobalProperty("URL");
		driver.get(url);
	}
	public void quitBrowser() {
		driver.close();
		driver.quit();
	}
	public void clickElement(By Locator) {
		waitUntilElementVisible(Locator);
		driver.findElement(Locator).click();
	}
	public void enterText(By Locator, String Data) {
		waitUntilElementVisible(Locator);
		driver.findElement(Locator).sendKeys(Data);
	}
	
	public void waitUntilElementVisible(By Locater) {
		int implicitwait=Integer.parseInt(globalproperty.getGlobalProperty("ImplicitWait"));
		driver.manage().timeouts().implicitlyWait(implicitwait, TimeUnit.SECONDS);
	}
}
