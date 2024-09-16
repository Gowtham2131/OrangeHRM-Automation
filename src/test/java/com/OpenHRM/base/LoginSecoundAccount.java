package com.OpenHRM.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.OpenHRM.Utility.Driver;
import com.OpenHRM.Utility.ReadConfig;
import com.OpenHRM.pageoject.Login;
import com.OpenHRM.pageoject.PimPage;

@Listeners(com.OpenHRM.Utility.Listeners.class)
public class LoginSecoundAccount {
	 WebDriver driver;
	    Login lp;
	    PimPage pim ;
	    Driver dr = new Driver();
	    
	    @BeforeClass
	    public void Before() throws IOException, InterruptedException {
	        ReadConfig.ReadConfig();
	        driver = dr.Browser();
	        lp = new Login(driver);
	        pim = new PimPage(driver);
	        lp.geturl();
	    }
    
	    @Test
	    public void Login() throws Throwable {
	    	Thread.sleep(5000);
	    	lp.secoundUser();
	    	lp.secoundPassword();
	    	
	    }
	   
}
