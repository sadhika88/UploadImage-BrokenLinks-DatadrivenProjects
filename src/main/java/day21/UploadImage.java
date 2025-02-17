package day21;

import java.awt.Point;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Utilites.ExtentReport;

public class UploadImage {
	public static WebDriver driver;

	@Test
	public void UploadImage() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		//ChromeDriver sadhika=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
//		//single file upload
//		WebElement s=sadhika.findElement(By.xpath(" //input[@id='filesToUpload']"));
//		s.sendKeys("C:\\Users\\Dell\\OneDrive\\Desktop\\alone.jpeg");
//		if(sadhika.findElement(By.xpath("//ul[@id='fileList']//li")).getText().equals("alone.jpeg")) {
//			System.out.println("Successsfull");
//		}else {
//			System.out.println("not successfull");
//		}
//		//https://davidwalsh.name/demo/multiple-file-upload.php
		//validation 1-multiple files uploaded
		String file="C:\\Users\\Dell\\OneDrive\\Desktop\\HomePage.jpg";
		String file2="C:\\Users\\Dell\\OneDrive\\Desktop\\alone.jpeg";
		driver.findElement(By.xpath(" //input[@id='filesToUpload']")).sendKeys(file + "\n" +file2);
		int size=driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();
		if(size==2) {
			System.out.println("Files are uploaded");
		}
		else {
			System.out.println("Files are not uploaded");
		}
//Validation file names
		if(driver.findElement(By.xpath("//ul[@id='fileList']//li[1]")).getText().equals("HomePage.jpg")&&
		driver.findElement(By.xpath("//ul[@id='fileList']//li[2]")).getText().equals("alone.jpeg")) {
			System.out.println("Files names matching.......");
		}
		else {
			System.out.println("Files names are not matching.....");
		
		}
		ExtentReport.driver=driver;
		
		
	}
	}

