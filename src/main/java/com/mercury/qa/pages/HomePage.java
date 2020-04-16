package com.mercury.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mercury.qa.base.TestBase;

public class HomePage extends TestBase {
	
	
	//Page Factor - OR for login page
		@FindBy(xpath = "//img[@src ='/images/banner2.gif']")
		WebElement imageLabel;
		
		@FindBy(xpath = "//a[contains(text(),'ITINERARY')]")
		WebElement iteneraryLink;
		
		@FindBy(xpath = "//a[contains(text(),'PROFILE')]")
		WebElement profileLink;
		
		@FindBy(xpath = "//a[contains(text(),'CONTACT')]")
		WebElement contactLink;
		
		/*
		 * This is the generic method I have created which can be used many times in testCase classes
		 * this function will be used everytime when we have the same //a href text and only the name is
		 * changing if we have same attribute(//a) and if it is used 100 times in a page then we create
		 * this generic function and just pass the parameter name.In this case I will just write CONTACT
		 * Or PROFILE or ITENERARY in the receiving testng class. This function i have used in HomePageTest.java
		 * you can check it there it is commented. 
		 * public void selectXpathByText(String Name) {
			driver.findElement(By.xpath("//a[contains(text(),"+Name+")]")).click();
		}*/
		
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
		
		public boolean verifyCorrectImageLabel() {
			return imageLabel.isDisplayed();
		}
		
		public String verifyHomePageTitle() {
			return driver.getTitle();
		}
		
		public IteneraryPage clickOnIteneraryLink() {
			iteneraryLink.click();
			return new IteneraryPage();
		}
		
		public ProfilePage clickOnProfileLink() {
			profileLink.click();
			return new ProfilePage();
		}
		
		public ContactPage clickOnContactLink() {
			contactLink.click();
			return new ContactPage();
		}

}
