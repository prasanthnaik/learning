package com.org.project.Actions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.org.framework.ConfigurationUtilities;
import com.org.framework.WebDriverFactory;

public class UserActions extends WebDriverFactory{
	
	ConfigurationUtilities globalProperties;
	
	public UserActions() throws IOException {
		globalProperties=new ConfigurationUtilities();
		
	}
	
	public void launchApplication() {
		String URL=globalProperties.getGlobalProperty("URL");
		driver.get(URL);
	}
	public void enterText(By Locater,String Data) {
		driver.findElement(Locater).isDisplayed();
		driver.findElement(Locater).isEnabled();
		driver.findElement(Locater).sendKeys(Data);
	}
	public void clickElement(By Locater) {
		driver.findElement(Locater).isDisplayed();
		driver.findElement(Locater).isEnabled();
		driver.findElement(Locater).click();
	}

}
