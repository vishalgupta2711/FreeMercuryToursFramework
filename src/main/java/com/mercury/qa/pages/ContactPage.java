package com.mercury.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mercury.qa.base.TestBase;

public class ContactPage extends TestBase {
	
	//Page Factor - OR for Contact page
	@FindBy(xpath = "//img[@src = '/images/forms/home.gif']")
	WebElement backToHomeImg;
	
	@FindBy(xpath = "//div[@class = 'footer']")
	WebElement footerLabel;
	
	@FindBy(xpath = "//a[contains(text(),'mercurywelcome.php')]")
	WebElement backToHomeBtn;
	
	public ContactPage() {
		PageFactory.initElements(driver, this);
		
		// we can write the above one statement or initialize the below objects as in below statements
		/*PageFactory.initElements(driver,this.loginBtn);
		PageFactory.initElements(driver,this.mercuryLogo);*/
	}
	
	public boolean verifyBackToHomeImg() {
		return backToHomeImg.isDisplayed();
	}
	
	public boolean verifyFooterLabel() {
		return footerLabel.isDisplayed();
	}
		

	public LoginPage verifyClickOnbackToHomeBtn() {
		backToHomeImg.click();
		return new LoginPage();
	}
}
