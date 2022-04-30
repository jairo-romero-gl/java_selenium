package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import library.base;

public class ResgisterPage extends base {

	By Registerlinklocator = By.linkText("REGISTER");
	By RegisterPageLocator = By.xpath("//img[@src='images/mast_register.gif']");
	
	By UserNameLocator = By.id("email");
	By PasswordLocator = By.name("password");
	By ConfirmPasswordLocator = By.cssSelector("input[name='confirmPassword'");
	
	By RegisterBtnLocater = By.name("submit");
	
	By RegisteredMessage = By.tagName("font");
	
	public ResgisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void registerUser() throws InterruptedException  {
		click(Registerlinklocator);
		Thread.sleep(200);
		if(isDisplayed(RegisterPageLocator)) {
			type("julian8admin", UserNameLocator);
			type("pass1", PasswordLocator);
			type("pass1", ConfirmPasswordLocator);
		   
			click(RegisterBtnLocater);
		}else {
			System.out.println("Register Pages Was Not Found");
		}
	}
	
	public String registerreMessage () {
		List<WebElement> fonts = findElements(RegisteredMessage);
		return getText((By) fonts.get(5));
	}
}
