package com.org.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationUtilities {
	Properties globalProperty;
	FileInputStream File;
	
	public ConfigurationUtilities() throws IOException {
		globalProperty=new Properties();
		File= new FileInputStream("C:\\SeleniumFrame\\MyTraining\\src\\main\\resources\\GlobalConfigurations.properties");
		globalProperty.load(File);
	}
	
	public String getGlobalProperty(String PropertyKey) {
		return globalProperty.getProperty(PropertyKey);
	}
	
}
