package testcases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.SignInPage;

public class SingIn_Case {
 private WebDriver driver;
  SignInPage signInPage;
  
	@Before
	public void setUp() throws Exception {
		signInPage = new SignInPage(driver);
		driver = signInPage.edgeDriverConnection();
		signInPage.visit("https://demo.guru99.com/test/newtours/index.php");
		
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
	}

	@Test
	public void test() throws InterruptedException {
		// signInPage.singIn();
		Thread.sleep(2000);
		// assertTrue(signInPage.isHomePageDisplayed());
	}
}
