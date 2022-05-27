package testcases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.SignInPage;

public class MercuryTest {
	private WebDriver driver; 
	SignInPage signInPage;
	
	@Before
	public void setUp() {
		signInPage = new SignInPage(driver);
		driver = signInPage.edgeDriverConnection();
		signInPage.visit("https://demo.guru99.com/test/newtours/index.php");
	}
	
	@Test
	public void errorLoginTest() {
		assertTrue("Email input is not present", signInPage.emailInputPresent());
		signInPage.typeEmail("hola@232.com");
		assertTrue("Password input is not present", signInPage.passInputPresent());
		signInPage.typePass("1234");
		signInPage.clickSubmit();
		
		assertEquals("Error message is not equals", 
				"Enter your userName and password correct"
				+ "", signInPage.getErrorMessage());
	}
	
	@After
	public void closeBrowsesr() {
		signInPage.close();
	}
}
