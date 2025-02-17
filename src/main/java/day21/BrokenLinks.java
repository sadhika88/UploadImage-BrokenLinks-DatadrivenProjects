package day21;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import Utilites.ExtentReport;
import io.opentelemetry.semconv.UrlAttributes;

public class BrokenLinks {
public static WebDriver driver;

@Test
	public void setup()  {
		// TODO Auto-generated method stub
ChromeOptions options=new ChromeOptions();
		WebDriver driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		int noofbrokenlinks=0;
		for(WebElement lk:links) {
			String hrefValue=lk.getAttribute("href");
			if(hrefValue==null ||  hrefValue.isEmpty()) {
				System.out.println(" hrefVlaue is null or is empty so Not Possible to check");
				continue;//if condition is not match statement contnue not break
			}
			//hit url to the server
			try {
			URL linkURL=new URL(hrefValue);//converted href value from string to URL format
			HttpURLConnection conn= (HttpURLConnection) linkURL.openConnection(); //opens the connection to the server
			conn.connect();//connect to sever and sent the request to the server
			if(conn.getResponseCode()>=400) {
				System.out.println(hrefValue + "=======>it is broken link");
				noofbrokenlinks++;
			}else {
				System.out.println(hrefValue + "========>not a broken link");
			}}catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		System.out.println("no of broken links : " +noofbrokenlinks);//42
		
		ExtentReport.driver=driver;
	}
}
