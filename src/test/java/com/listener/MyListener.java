package com.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class MyListener implements ITestListener{

	ExtentReports extent;
	ExtentTest test;
	
  @Override
  public void onStart(ITestContext context) {
	  ExtentSparkReporter html = new ExtentSparkReporter("MyReporter.html");
	  extent = new ExtentReports();
	  extent.attachReporter(html);
  }
  
  @Override
  public void onTestStart(ITestResult result) {
	  test = extent.createTest(result.getName()+ " was created...");
  }

  @Override
  public void onTestSuccess(ITestResult result) {
	  test.pass(result.getName()+ " PASSED!");
  }
  
  @Override
  public void onTestFailure(ITestResult result) {
	  test.fail(result.getName()+ " FAILED!");
  }

  @Override
  public void onTestSkipped(ITestResult result) {
	  test.skip(result.getName()+ " SKIPPED!");
  }
  
  @Override
  public void onFinish(ITestContext context) {
	  extent.flush();
  }
}
