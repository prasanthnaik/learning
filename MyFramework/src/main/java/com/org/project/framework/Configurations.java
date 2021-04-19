package com.org.project.framework;

import java.io.FileInputStream;

public class Configurations extends FrameworkParameters{

	public Configurations() {
		try {
			globalConfigFile = new FileInputStream("C:\\SeleniumFrame\\MyFramework\\src\\main\\resources\\GlobalConfiguration.properties");
			property.load(globalConfigFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String getGlobalProperty(String Key) {
		return property.getProperty(Key);		 
	}
}
