package com.OpenHRM.pageoject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class EmployeeInfo {

	WebDriver driver;
	public EmployeeInfo(WebDriver driver) {
	    this.driver = driver;  
	    PageFactory.initElements(driver, this);
	}
	@FindBy(className = "oxd-main-menu-item")
    public List<WebElement> userMenu;
	
    @FindBy(className= "oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input")
    public List<WebElement> btnRadio;
    
    @FindBy(className = "oxd-select-text-input")
    public List<WebElement> dropdown;
    
    @FindBy(className = "orangehrm-tabs-item")
    public List<WebElement> contactDetails;
    
    @FindBy(className = "oxd-input")
    public List<WebElement> txtInput;
    
    @FindBy(className = "oxd-select-text-input")
    public WebElement dropdownCountry;
    
    @FindBy(css = "[type=submit]")
    public List<WebElement> Submit;
    
   
    public void selectGender() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement radioButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input")));

        // Instantiate the Actions class
        Actions actions = new Actions(driver);
        
        // Perform click action on the radio button
        actions.moveToElement(radioButton).click().build().perform();

        // Assuming `btnRadio` and `Submit` are WebElements that you want to click
        WebElement radioOption = btnRadio.get(1);
        WebElement submitButton = Submit.get(0);

        // Use Actions to perform the click on `btnRadio` and `Submit` elements
        actions.moveToElement(radioOption).click().build().perform();
        
        // Sleep is generally discouraged, but if you still want it
        Thread.sleep(1500); 
        
        actions.moveToElement(submitButton).click().build().perform();
    }
    public void selectBloodType() throws InterruptedException {
        dropdown.get(2).click();
        dropdown.get(2).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        dropdown.get(2).sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        dropdown.get(2).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        Submit.get(1).click();
    }
    public void selectContact() throws InterruptedException {
        
        Submit.get(0).click();
    }
}