package com.OpenHRM.pageoject;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.OpenHRM.Utility.ReadConfig;
public class PimPage extends ReadConfig {
	

	
	    WebDriver driver;
	    
	    public PimPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    @FindBy(className = "oxd-main-menu-item--name")
	    public List<WebElement> menus;
	    
	    @FindBy(tagName="h6")
	    WebElement pimverify;
	    
	    @FindBy(xpath="//a[.='Add Employee']")
	   public WebElement addEmployee;
	    
	    @FindBy(name="firstName")
	    public WebElement firstname;
	    
	    @FindBy(name="lastName")
	    public WebElement lastname;
	    
	    @FindBy(xpath="//label[text()='Employee Id']/following::input[@class='oxd-input oxd-input--active']")
	    public WebElement employeeid;
	    
	    @FindBy(xpath="//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")
	    public WebElement Checkbox;
	    
	    @FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[3]")
	    public WebElement username;
	    
	    @FindBy(xpath="(//input[@type='password'])[1]")
	    public WebElement password;
	    
	    @FindBy(xpath="(//input[@type='password'])[2]")
	    public WebElement cpassword;
	    
	    @FindBy(xpath="//button[@type='submit']")
	    public WebElement submit;

	    public void clickPIMMenu() throws InterruptedException {
	        menus.get(1).click();
	        Thread.sleep(5000);
	        addEmployee.click();
	    }

	    public void verifyPIMPage() {
	        String verify = pimverify.getText();
	        Assert.assertEquals(verify, "Expected Text", "PIM page not verified");
	    }

	    public void FirstName() {
	        
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(firstname));
	        firstname.sendKeys("Gowtham");
	    }

	    public void LastName() {
 	        lastname.sendKeys("PV");
	    }

	    public void EmployeeNum() {
	        employeeid.sendKeys("2222");
	    }

	    public void CheckBox() {
	        if (!Checkbox.isSelected()) {
	            Checkbox.click();
	        }
	    }

	    public void username() {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	wait.until(ExpectedConditions.visibilityOf(username));
	    	username.sendKeys(ReadConfig.proper.getProperty("SecoundUsername"));

	    }

	    public void password() throws InterruptedException {
	        password.sendKeys(ReadConfig.proper.getProperty("SecoundPassword"));
	        Thread.sleep(5000);
	        cpassword.sendKeys(ReadConfig.proper.getProperty("SecoundPassword"));
	    }


	    public void Submit() {
	        submit.click();
	    }
	}


