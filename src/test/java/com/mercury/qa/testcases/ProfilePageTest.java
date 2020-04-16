package com.mercury.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mercury.qa.base.TestBase;
import com.mercury.qa.pages.HomePage;
import com.mercury.qa.pages.LoginPage;
import com.mercury.qa.pages.ProfilePage;
import com.mercury.qa.util.TestUtil;

public class ProfilePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;
	String sheetName = "Profile";
	public ProfilePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		homePage = new HomePage();
		loginPage = new LoginPage();
		profilePage = new ProfilePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		profilePage = homePage.clickOnProfileLink();
	}
	
		
	@DataProvider
	public Object[][] getMercuryTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 1 , dataProvider = "getMercuryTestData")
	public void validateCreateNewProfile(String ftName,String ltName,String phoneTBox,String emailTBox,
			String address1TBox,String address2TBox,String cityTBox,String stateTBox,
			String postalCodeTBox, String Country) {
		
		profilePage.createNewProfile(ftName, ltName, phoneTBox, emailTBox, address1TBox, address2TBox, cityTBox, stateTBox, postalCodeTBox, Country);
		/*profilePage.createNewProfile("v", "g", "123", "test@gmail.com",
				"add1", "add2", "city", 
				"state", "401203", "INDIA");
*/	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
