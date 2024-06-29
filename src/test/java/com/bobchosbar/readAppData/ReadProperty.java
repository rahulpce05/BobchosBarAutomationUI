package com.bobchosbar.readAppData;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty {
	
	public String getPropertyFile() throws IOException {
		FileInputStream fis = new FileInputStream("src\\main\\resources\\config\\application.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String baseUrl = prop.getProperty("baseUrl");
		System.out.println(baseUrl);
		return baseUrl;
	}
}
