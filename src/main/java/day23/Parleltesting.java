package day23;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parleltesting {
	WebDriver sadhika;
	@BeforeClass
	@Parameters({"browser"})
	void testdata(String br) throws InterruptedException {
		switch(br.toLowerCase()) {
		case  "chrome" :sadhika =new ChromeDriver();break;
		case "edge"    :sadhika=new EdgeDriver();break;
		default : System.out.println("Invalid Browser");return;
		}
		
		sadhika.manage().timeouts().implicitlyWait(Duration.ofDays(10));
		sadhika.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		sadhika.manage().window().maximize();
		Thread.sleep(3000);
		
		
	}@Test(priority = 1)
	void testLogo() {
		boolean status=sadhika.findElement(By.xpath(" //img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(status, true);
	}@Test(priority = 2)
	void  testTitle() {
		Assert.assertEquals(sadhika.getTitle(), "OrangeHRM");//comparing actual title and expected title
	}@Test(priority = 3)
	void testURL() {
		Assert.assertEquals(sadhika.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	@AfterClass
	void teardown() {
		sadhika.close();
	}

}
