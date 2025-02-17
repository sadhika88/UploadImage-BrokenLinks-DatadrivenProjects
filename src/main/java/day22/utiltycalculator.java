package day22;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;

public class utiltycalculator {



	public static WebDriver driver;

	public static void main(String[] args)throws IOException, InterruptedException {
		

		// TODO Auto-generated method stub
		
		
		// Run in headless mode
		WebDriver driver = new ChromeDriver();
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		String filepath=System.getProperty("user.dir")+"\\foldedata\\DataDriven.xlsx";//reutrns current project location
		int rows=sadhikaUtils.getRowCount(filepath, "Sheet1");
		for(int i=1;i<=rows;i++) {
			//read data from excel
			
			String price=sadhikaUtils.getcellData(filepath,"Sheet1",i,0);
			String rateofinterest=sadhikaUtils.getcellData(filepath,"Sheet1",i,1);
			String period=sadhikaUtils.getcellData(filepath,"Sheet1",i,2);
			String peiod2=sadhikaUtils.getcellData(filepath,"Sheet1",i,3);
			String freq=sadhikaUtils.getcellData(filepath,"Sheet1",i,4);
			String expvalue=sadhikaUtils.getcellData(filepath,"Sheet1",i,5);


			//pass above data into application
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(price);
			driver.findElement(By.xpath(" //input[@id='interest']")).sendKeys(rateofinterest);
			driver.findElement(By.xpath(" //input[@id='tenure']")).sendKeys(period);
			Select prddrp=new Select(driver.findElement(By.xpath(" //select[@id='tenurePeriod']")));
			prddrp.selectByVisibleText(peiod2);
			Select frqdrp=new Select(driver.findElement(By.xpath(" //select[@id='frequency']")));
			frqdrp.selectByVisibleText(freq);
			WebElement cl=driver.findElement(By.xpath("//div[@class='cal_div']//a[1]"));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", cl);//clicked on calculate

			//validation
			String act_mvalue=driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			if(Double.parseDouble(expvalue)==Double.parseDouble(act_mvalue)) {
				System.out.println("Testcase passed");
				sadhikaUtils.setCellData(filepath,"Sheet1", i,7,"passed");
				sadhikaUtils.GreenColor(filepath, "Sheet1", i, 7);
			}
			else {
				System.out.println("Testcase failed");
				sadhikaUtils.setCellData(filepath,"Sheet1", i,7,"failed");
				sadhikaUtils.RedColor(filepath, "Sheet1", i, 7);
			}
			Thread.sleep(3000);
			WebElement c2=driver.findElement(By.xpath("//img[@class='PL5']"));//clicked on clearbutton
			JavascriptExecutor js1 = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", c2);
		}
		Thread.sleep(3000);
	//	driver.close();
driver.quit();
//System.exit(0);



	}
}








