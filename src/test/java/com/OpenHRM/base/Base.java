package com.OpenHRM.base;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.OpenHRM.Utility.Driver;
import com.OpenHRM.Utility.ReadConfig;
import com.OpenHRM.pageoject.EmployeeInfo;
import com.OpenHRM.pageoject.Login;
import com.OpenHRM.pageoject.PimPage;
import edu.umd.cs.piccolo.PInputManager;

@Listeners(com.OpenHRM.Utility.Listeners.class)
public class Base  {
    WebDriver driver;
    Login lp;
    PimPage pim ;
    EmployeeInfo employeeinfo;
    Driver dr = new Driver();
   
    @BeforeClass
    public void Before() throws IOException, InterruptedException {
        ReadConfig.ReadConfig();
        driver = dr.Browser();
        lp = new Login(driver);

        lp.geturl();
      //  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");        

       
    }

    @Test (priority = 0)
    public void VerifyPage() throws InterruptedException {
        String Title = driver.getTitle();
        String Actual = "OrangeHRM";
        assertEquals(Title, Actual);
    }

    @Test (priority = 1)
    public void LoginDetail() throws InterruptedException {
       Thread.sleep(5000);
        lp.getusername();
        lp.getpassword();
    }

    @Test(priority =2)
    public void AddEmploye() throws InterruptedException {
    	pim = new PimPage(driver);
   	Thread.sleep(5000);
   		 pim.clickPIMMenu();
        pim.FirstName();
        pim.LastName();
        pim.EmployeeNum();
        pim.CheckBox();
   }
    @Test(priority =3)
    public void CreateUser() throws Throwable {
    	
    	pim.username();
    	pim.password();
    	pim.Submit();
    	Thread.sleep(5000);
    }

    @AfterClass
    public void teardown() throws InterruptedException {
      
    	
    	Thread.sleep(9000);
    	lp.dologOut();
    	Thread.sleep(9000);
    	 driver.quit();
    }
}
