package day23;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
	WebDriver sadhika;
	@BeforeClass
	void setup() {
		sadhika=new ChromeDriver();
		sadhika.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
		sadhika.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		sadhika.manage().window().maximize();
		
		
	}@Test
	void testLogin() {
		LoginPage2 lp=new LoginPage2(sadhika);
		lp.setUserName("Admin");
		lp.setPassword("admin123");
		lp.setLogin( );
		Assert.assertEquals(sadhika.getTitle(), "OrangeHRM");
	}
@AfterClass
void teardown() {
	sadhika.close();
}


}
