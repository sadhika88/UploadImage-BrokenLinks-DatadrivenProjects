package day23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {
	WebDriver sadhika;

	//constructors
	public LoginPage(WebDriver sadhika) {
		// TODO Auto-generated constructor stub
		this.sadhika=sadhika;
		PageFactory.initElements(sadhika, this);
	}
/*	//Locators
By  txt_username_loc=By.xpath("//input[@placeholder='Username']");
By  txt_password_loc=By.xpath("//input[@placeholder='Password']");
By  btn_login_loc=By.xpath("//button[normalize-space()='Login']");
/*

@F

/*public void setUserName(String user) {
	sadhika.findElement(txt_username_loc).sendKeys(user);
}
public void setPassword(String password) {
	sadhika.findElement(txt_password_loc).sendKeys(password);
}public void setLogin( ) {
	sadhika.findElement(btn_login_loc).click();
}*/

}

