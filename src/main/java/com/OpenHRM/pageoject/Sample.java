package com.OpenHRM.pageoject;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String UserName="gowtham12042";
		String Password ="Gowtham2929";
		System.setProperty("webdriver.edge.driver", "C:\\Users\\Msi\\Downloads\\edgedriver_win64 (2)\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		List<WebElement> link = driver.findElements(By.className("oxd-main-menu-item--name"));
		link.get(1).click();
		Thread.sleep(5000); 
		driver.findElement(By.partialLinkText("Employee List")).click();
		//driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys("");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Add Employee']")).click();
		Thread.sleep(10000);
		driver.findElement(By.name("firstName")).sendKeys("Atrun");
		driver.findElement(By.name("lastName")).sendKeys("A");
		driver.findElement(By.xpath("//label[text()='Employee Id']/following::input[@class='oxd-input oxd-input--active']")).sendKeys("1234");
		driver.findElement(By.xpath("//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")).click();
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]")).sendKeys(UserName);
		driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys(Password);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys(Password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		
	//	Webelement 
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//driver.navigate().refresh();
		 WebDriverWait wait = new WebDriverWait(driver,  Duration.ofSeconds(20));  // 20 seconds timeout
	        wait.until((ExpectedCondition<Boolean>) wd ->
	            ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
	        driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
	        Thread.sleep(4000);
	        driver.findElement(By.xpath("//a[text()='Employee List']")).click();
	        Thread.sleep(5000);
	    //    driver.findElement(By.xpath("//div[@class='card-center']/following::button[@type='button']")).click();
	        driver.findElement(By.xpath("(//input[@placeholder='Type for hints...'])[1]")).sendKeys("Atrun  A");
	        driver.findElement(By.xpath("//button[@type='submit']")).click();
	        Thread.sleep(8000);
	        
	        List<WebElement> cards = driver.findElements(By.xpath("//div[@class='oxd-table-card']"));
	        if (cards.size() >=1) {
	            cards.get(0).click();
	        } else {
	            System.out.println("Not enough cards found.");
	        }

	        Thread.sleep(10000);
	        driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[4]")).sendKeys("1234787377719");
		WebElement genderRadio = driver.findElement(By.xpath("(//div[@class='oxd-radio-wrapper'])[1]")); // Assumin1g value '2' is for female
		System.out.println(genderRadio.getText());
		genderRadio.click();
		
//		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait1.until(ExpectedConditions.elementToBeClickable(genderRadio));
//		if(genderRadio.size()>=1) {
//			genderRadio.get(0).click();
//        } else {
//            System.out.println("Not  found.");
//        }
//		}
		//genderRadio.get(0).click();

		// OR (if loading indicator is an issue)

		// Use JavaScriptExecutor for direct click
		JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("arguments[0].click();", genderRadio);

		// OR (try offset click)

		Actions actions = new Actions(driver);
		//actions.moveToElement(genderRadio).click().perform();
		// Get the dimensions of the browser window
//       
//		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='First Name']")));
////		JavascriptExecutor js = (JavascriptExecutor) driver;
////		js.executeScript("window.scrollBy(0,500)", "");
		
		
		
		
		
		
		
		
		//		WebElement Logout =driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']"));
//		Logout.click();
//		 WebElement logoutButton = driver.findElement(By.xpath("//a[text()='Logout']"));
//	     logoutButton.click();
		
	}}

