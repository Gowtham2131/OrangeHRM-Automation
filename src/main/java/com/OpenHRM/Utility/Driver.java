package com.OpenHRM.Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.OpenHRM.pageoject.Login;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	WebDriver driver ;
	
	public WebDriver Browser() throws InterruptedException {
		
		if(ReadConfig.proper.getProperty("Browser").equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
			driver.manage().window().maximize();
		}else if(ReadConfig.proper.getProperty("Browser").equalsIgnoreCase("Edge")) {
			
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Msi\\Downloads\\edgedriver_win64 (3)\\msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			Thread.sleep(5000);
		}
		return driver;
		
	}
	
}
