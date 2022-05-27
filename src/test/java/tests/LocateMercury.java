package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class LocateMercury {
	
	private WebDriver driver;
	
	By Registerlinklocator = By.linkText("REGISTER");
	By RegisterPageLocator = By.xpath("//img[@src='images/mast_register.gif']");
	
	By UserNameLocator = By.id("email");
	By PasswordLocator = By.name("password");
	By ConfirmPasswordLocator = By.cssSelector("input[name='confirmPassword'");
	
	By RegisterBtnLocater = By.name("submit");
	//SingIn
	By UserName = By.name("userName");
	By passlocator = By.name("password");
	By SignInBtnLocator = By.name("submit");
	
	By HomePageLocator = By.cssSelector("flooter['\r\n"
			+ "© 2005, Mercury Interactive (v. 011003-1.01-058)\r\n"
			+ "']");
	
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
	
	
	
	

	@SuppressWarnings("deprecation")
	@Test
	
	public void RegisterUser()  {
		driver.findElement(Registerlinklocator).click();
		
		if (driver.findElement(RegisterPageLocator).isDisplayed()) {
			driver.findElement(UserNameLocator).sendKeys("julian8admin");
			driver.findElement(PasswordLocator).sendKeys("pass1");
			driver.findElement(ConfirmPasswordLocator).sendKeys("pass1");
			
			driver.findElement(RegisterBtnLocater).click();
			
		}
		else {
		System.out.print("Register Pages waa not found");	
		}
		
		List<WebElement> fonts = driver.findElements(By.tagName("font"));
		
		assertEquals("Note: Your user name is julian8admin.",fonts.get(5).getText());
	}
	@SuppressWarnings("deprecation")
	@Test
	public void signIn()  {
		if(driver.findElement(UserName).isDisplayed()) {
			driver.findElement(UserName).sendKeys("julian8admin");
			driver.findElement(passlocator).sendKeys("pass1");
			driver.findElement(SignInBtnLocator).click();
		
			//assertFalse(driver.findElement(HomePageLocator).isDisplayed());
			
		}
		else {
			System.out.println("usermane textbox was not present");
		}
	}
	@After
	public void tearDown() throws Exception {
		driver.close();
	}
	
}
