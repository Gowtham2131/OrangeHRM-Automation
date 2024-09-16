package com.OpenHRM.Utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class Listeners implements ITestListener {
	
	ExtentTest test;
	ExtentReports extent = ExtentReport.config();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); // For parallel execution
	WebDriver driver;

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		System.out.println("Test Started: " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Successfully executed: " + result.getName());
		extentTest.get().pass("Test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
	    System.out.println("Test Failed: " + result.getName());
	    extentTest.get().fail(result.getThrowable()); // Log the failure reason

	    
	}



	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped: " + result.getName());
		extentTest.get().skip(result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

	
}
