package day23;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import bsh.This;

public class LoginPage2 {
	WebDriver sadhika;

	//constructors
	public LoginPage2(WebDriver sadhika) {
		// TODO Auto-generated constructor stub
		this.sadhika=sadhika;
		PageFactory.initElements(sadhika, this);
	}
	//locators
@FindBy(how=How.XPATH,using ="//input[@placeholder='Password']") WebElement txt_username;
@FindBy(xpath = "//input[@placeholder='Password']") WebElement txt_password;
@FindBy(xpath = "//button[normalize-space()='Login']") WebElement btn_Login;

@FindBy(tagName="a")List<WebElement> links;//find group of webelements

//action methods
public void setUserName(String user) {
	txt_username.sendKeys(user);
}
public void setPassword(String password) {
	txt_password.sendKeys(password);
}public void setLogin( ) {
	btn_Login.click();
}

}

