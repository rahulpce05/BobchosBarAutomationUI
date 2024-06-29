package com.bobchosbar.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	Properties prop;
	
	public ConfigDataProvider() {
		try {
			File file = new File("./src/test/resources/config/application.properties");
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
			
		}catch(Exception e) {
			System.out.println("Unable to read config fie: " +e.getMessage());
		}
	}
	
	public String getBrowserName() {
		return prop.getProperty("browser");
	}
	
	public String getTestUrl() {
		return prop.getProperty("baseUrl");
	}
	

}
