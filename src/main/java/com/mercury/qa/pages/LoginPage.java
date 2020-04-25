package com.mercury.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mercury.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	
		//Page Factory - OR for login page
	@FindBy(name = "userName")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@name = 'login']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a(contains(@linkText,'REGISTER'))")
	WebElement registerBtn;
	
	@FindBy(xpath = "//img[@alt = 'Mercury Tours']")
	public WebElement mercuryLogo;
	
	@FindBy(xpath = "//a[contains(text(),'SIGN-ON')]")
	public WebElement signOnBtn;
	
	//Initializing the page objects through constructor of this class
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
		// we can write the above one statement or initialize the below objects as in below statements
		/*PageFactory.initElements(driver,this.loginBtn);
		PageFactory.initElements(driver,this.mercuryLogo);*/
	}
	
	//Actions.
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateMercuryLogo() {
		return mercuryLogo.isDisplayed();
	}
	
	/*public void clickOnSignOnPage() {
		signOnBtn.click();
	}*/
	
	public HomePage login(String un, String pwd) {
		signOnBtn.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();// This is same as HomePage homePage = new HomePage() which we have used in LoginPageTest.java class
	}
}
