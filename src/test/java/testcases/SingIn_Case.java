package testcases;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.SingInPage;

public class SingIn_Case {
 private WebDriver driver;
  SingInPage singInPage;
  
	@Before
	public void setUp() throws Exception {
		singInPage = new SingInPage(driver);
		driver=singInPage.edgeDriverConnection();
		singInPage.visit("https://demo.guru99.com/test/newtours/index.php");
		
	}

	@After
	public void tearDown() throws Exception {
		//driver.close();
	}

	@Test
	public void test() throws InterruptedException {
		singInPage.singIn();
		Thread.sleep(2000);
		assertTrue(singInPage.isHomePageDisplayed());
	}

}
