package Utilites;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import day21.BrokenLinks;
import day21.HandlingPaginationWebtable;
import day21.UploadImage;
import day21.workbook;
import day22.utiltycalculator;

public class ExtentReport  implements ITestListener{

	public ExtentSparkReporter sparkReporter;
			public ExtentReports extent;
			public ExtentTest test;
			  public static WebDriver driver; 
			
			public void onStart(ITestContext testContext) {

				sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/myReport.html");
				sparkReporter.config().setDocumentTitle("Kosmik Hospital Management System Automation Report");
				sparkReporter.config().setReportName("Kosmik Hospital Management System FunctionalTesting");
				sparkReporter.config().setTheme(Theme.DARK);
				
				extent=new ExtentReports();
				extent.attachReporter(sparkReporter);
				
				
				extent.setSystemInfo("Computer Name", "localhost");
				extent.setSystemInfo("Environment", "QA");
				extent.setSystemInfo("Tester Name", "sadhika");
				extent.setSystemInfo("os", "Windows10");
				extent.setSystemInfo("Browser name", "Chrome");
				
				  
					driver = utiltycalculator.driver;
				
				}

				 public void onTestSuccess(ITestResult result) {
					 test = extent.createTest(result.getName());
						
						test.log(Status.PASS,"Test Case Passed is : " +result.getName());
						 String screenshotPath = CaptureScreenshot(result.getName());
					        if (screenshotPath != null) {
					            test.addScreenCaptureFromPath(screenshotPath); // Attach to report
					        }
				 }
				 
				 private String CaptureScreenshot(String testName) {
					  if (driver == null) {
						  if (driver == null) {
					            System.out.println("Driver is null! Cannot take screenshot.");
					            return null;
					        }// Ensure driver is initialized
					  }

				        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
				        String screenshotPath = System.getProperty("user.dir") + "/screenShots/" + testName + "_" + timestamp + ".png";
				        File screenshotDir = new File(System.getProperty("user.dir") + "/screenShots/");
				        if (!screenshotDir.exists()) {
				            screenshotDir.mkdirs();
				        }
				        try {

				        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				        File destFile = new File(screenshotPath);

				       
				            FileUtils.copyFile(srcFile, destFile);
				            return screenshotPath;
				        } catch (IOException e) {
				            e.printStackTrace();
				        }
				        return null;
					// TODO Auto-generated method stub
				
				}

				public void onTestFailure(ITestResult result) {
					 test = extent.createTest(result.getName());
					 test.log(Status.FAIL,"Test Case Failed is : " +result.getName());
					 test.log(Status.FAIL,"Test Case Failed  Caused is : " +result.getThrowable());
						
				 }
				
				 
				 public void onTestSkipped(ITestResult result) {
					 test=extent.createTest(result.getName());
					 test.log(Status.SKIP, "Testcase Skipped is: " +result.getName());
					// test.log(Status.FAIL, "Testcase Skipped cause is: " +result.getThrowable());
				 }
				
				 public void onFinish(ITestContext testContext) {
						
						extent.flush();
				
			}
			}


