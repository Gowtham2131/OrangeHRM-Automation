package com.OpenHRM.Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class captureScreenshot {
	
	public String captureScreenshot(String methodName, WebDriver driver) throws IOException {
		
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destPath = System.getProperty("user.dir") + "/screenshots/" + methodName + ".png";
		FileUtils.copyFile(srcFile, new File(destPath));
		return destPath;
	}
}
