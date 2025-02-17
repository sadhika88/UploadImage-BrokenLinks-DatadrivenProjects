package day12;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OrangeH {
	WebDriver sadhika;
  @Test(priority =1)
  public void openapp() {
	  sadhika=new ChromeDriver();
	  sadhika.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  sadhika.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  sadhika.manage().window().maximize();
	  
  } @Test(priority =2)
  
  void logoapp() throws InterruptedException {
	  Thread.sleep(3000);
	 boolean status= sadhika.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
	 System.out.println("logo displayed...." +status);
	  
  } @Test(priority =3)
  void login() {
	  sadhika.findElement(By.xpath(" //input[@placeholder='Username']")).sendKeys("Admin");
	  sadhika.findElement(By.xpath(" //input[@placeholder='Password']")).sendKeys("admin123");
	  sadhika.findElement(By.xpath(" //button[normalize-space()='Login']")).click();
		
	  
	  
  } @Test(priority =4)
  void closeapp() {
	  sadhika.quit();
  }
}
