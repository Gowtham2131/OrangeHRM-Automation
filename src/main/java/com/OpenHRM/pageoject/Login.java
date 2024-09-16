package com.OpenHRM.pageoject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.OpenHRM.Utility.ReadConfig;

public class Login extends ReadConfig {

	WebDriver driver;
	public Login(WebDriver driver) {
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name ="username")
	WebElement Username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath ="//button[@type='submit']")
	WebElement submit;
	
	@FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    public WebElement logOutLink;
	
	@FindBy(xpath ="//a[text()='Logout']")
	 WebElement logoutButton;
	
	public void geturl() {
		driver.get(ReadConfig.proper.getProperty("URL"));
	}
	
	public void getusername() {
		Username.sendKeys(ReadConfig.proper.getProperty("UserName"));
	}
	
	public void getpassword() throws InterruptedException {
		password.sendKeys(ReadConfig.proper.getProperty("Password"));
		Thread.sleep(3000);
		submit.click();
	}
	public void secoundUser() {
		Username.sendKeys(ReadConfig.proper.getProperty("SecoundUsername"));
	}
	
	public void secoundPassword() {
		password.sendKeys(ReadConfig.proper.getProperty("SecoundPassword"));
	
		submit.click();
	}
	
	
	public void dologOut () {
		logOutLink.click();
		logoutButton.click();
	}
	
	 