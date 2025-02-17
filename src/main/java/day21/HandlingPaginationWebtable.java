package day21;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Utilites.ExtentReport;

public class HandlingPaginationWebtable {

	public static WebDriver driver;
@Test
public void setup() throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
		driver.manage().window().maximize();
		driver.get("https://www.ecomdeveloper.com/demo/admin/index.php");
	WebElement username=driver.findElement(By.id("input-username"));
	username.sendKeys("demoadmin");
	WebElement password =driver.findElement(By.id("input-password"));
	password.sendKeys("demopass");
	driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
	driver.findElement(By.xpath("//a[normalize-space()='Customers']")).click();
	driver.findElement(By.xpath("//ul[@id='collapse9']//a[contains(text(),'Customers')]")).click();
	//Showing 1 to 20 of 899 (45 Pages)
	String text=driver.findElement(By.xpath("//div[contains(text(),'Pages')]")).getText();
	int totalpages=Integer.parseInt(text.substring(text.indexOf("(")+1, text.indexOf("Pages")-1));//convert string to int
	//repeating pages
	for(int i=0;i<=5;i++) {
		if(i>1) {
			WebElement activepage=driver.findElement(By.xpath("//ul[@class='pagination']//*[text()="+i+"]"));
			activepage.click();
			Thread.sleep(3000);
		}
		//reading the data particular page
		int noofrows=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
		for(int p=1;p<=noofrows;p++) {
			String CustomerName=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+p+"]//td[2]")).getText();
			String Email=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+p+"]//td[3]")).getText();
			String status=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+p+"]//td[5]")).getText();
			System.out.println(CustomerName + "\t" +Email+ "\t" +status);
			
			ExtentReport.driver=driver;
		}
		
	}
	
		
		
		}


		}


	


