package day21;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDom {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver sadhika =new ChromeDriver();
		sadhika.get("https://books-pwakit.appspot.com/");
		sadhika.manage().window().maximize();
		//this element is inside single shadow dom
		//String cssselectorhost1="book-app[apptitle='BOOKS']";
		//Thread.sleep(1000);
		//handle shadow dom elements
		SearchContext shadow=sadhika.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
		Thread.sleep(1000);
		shadow.findElement(By.cssSelector("#input")).sendKeys("sadhika");

	}

}
