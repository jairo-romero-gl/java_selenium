package com.proyect.pom;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class RegisterCase {
 private WebDriver driver;
 ResgisterPage registerPage;
 
	@Before
	public void setUp() throws Exception {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://demo.guru99.com/test/newtours/index.php");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		registerPage.registerUser();
		assertEquals("Note:Your user name is julian8admin.",registerPage.registerreMessage());
	}

}
