package day21;

import java.awt.Point;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ScreenShort {
	public static void main(String[] args) throws InterruptedException {
		WebDriver sadhika=new ChromeDriver();
		//ChromeDriver sadhika=new ChromeDriver();
		sadhika.manage().window().maximize();
		sadhika.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
sadhika.get("https://demo.nopcommerce.com/");
sadhika.manage().window().maximize();
//Fullpage screenshot
TakesScreenshot ts=(TakesScreenshot)sadhika;
//File sourcefile=ts.getScreenshotAs(OutputType.FILE);
//File targetfile=new File(System.getProperty("user.dir") +"\\Screenshotsfolder\\fullpage.png");
//sourcefile.renameTo(targetfile);//copy soure file into targrt file
//capture the screen shot from specific section
// WebElement  featuredProduct=sadhika.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
// File sourcefile=featuredProduct.getScreenshotAs(OutputType.FILE);
//File targetfile=new File(System.getProperty("user.dir") +"\\Screenshotsfolder\\featuredProducts.png");
//sourcefile.renameTo(targetfile);
//capture the screen shot of webelement
WebElement logo=sadhika.findElement(By.xpath(" //img[@alt='nopCommerce demo store']"));
File sourcefile=logo.getScreenshotAs(OutputType.FILE);
File targetfile=new File(System.getProperty("user.dir") +"\\Screenshotsfolder\\logo.png");
sourcefile.renameTo(targetfile);


		
		
	
}
}