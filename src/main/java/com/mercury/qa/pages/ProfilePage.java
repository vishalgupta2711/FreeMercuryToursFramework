package com.mercury.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mercury.qa.base.TestBase;

public class ProfilePage extends TestBase{
	
	//Page Factor - OR for login page
	@FindBy(xpath ="//input[@name = 'firstName']")
	WebElement firstNameTextBox;
	
	@FindBy(xpath ="//input[@name = 'lastName']")
	WebElement lastNameTextBox;
	
	@FindBy(xpath ="//input[@name = 'phone']")
	WebElement phoneTextBox;
	
	@FindBy(xpath ="//input[@name = 'email']")
	WebElement emailTextBox;
	
	@FindBy(xpath ="//input[@name = 'address1']")
	WebElement address1TextBox;
	
	@FindBy(xpath ="//input[@name = 'address2']")
	WebElement address2TextBox;
	
	@FindBy(xpath ="//input[@name = 'city']")
	WebElement cityTextBox;
	
	@FindBy(xpath ="//input[@name = 'state']")
	WebElement stateTextBox;
	
	@FindBy(xpath ="//input[@name = 'postalCode']")
	WebElement postalCodeTextBox;
	
	@FindBy(xpath = "//img[@src = 'images/profile_submit.gif']")
	WebElement submitBtn;
	
	
	public ProfilePage() {
		PageFactory.initElements(driver, this);
	}	
	
	public void createNewProfile(String ftName,String ltName,String phoneTBox,String emailTBox,
			String address1TBox,String address2TBox,String cityTBox,String stateTBox,
			String postalCodeTBox, String Country ) {
		firstNameTextBox.sendKeys(ftName);
		lastNameTextBox.sendKeys(ltName);
		phoneTextBox.sendKeys(phoneTBox);
		emailTextBox.sendKeys(emailTBox);
		address1TextBox.sendKeys(address1TBox);
		address2TextBox.sendKeys(address2TBox);
		cityTextBox.sendKeys(cityTBox);
		stateTextBox.sendKeys(stateTBox);
		postalCodeTextBox.sendKeys(postalCodeTBox);
		
		Select select = new Select(driver.findElement(By.name("country")));
		select.selectByVisibleText(Country);
		
		submitBtn.click();
		
	}
}
