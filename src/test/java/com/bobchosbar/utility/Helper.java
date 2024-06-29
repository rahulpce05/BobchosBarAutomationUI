package com.bobchosbar.utility;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;

public class Helper {

	public static void captureScreenshot(WebDriver driver) {
		File destFile = new File("./Screenshot/Order "+getCurrentDateTime()+".png");
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {

			FileUtils.copyFile(scrFile, destFile);
			System.out.println("Screenshot Captured");
		}catch(Exception e) {
			System.out.println("Unable to capture screenshot: " +e.getMessage());
		}
	}
	
	public static String getCurrentDateTime() {
		DateFormat customFormat = new SimpleDateFormat("HH_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}
}
