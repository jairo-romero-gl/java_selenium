package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends Base {
	By userName = By.name("userName");
	By passlocator = By.name("password");
	By signInBtnLocator = By.name("submit");
	By homePageLocator = By.cssSelector("flooter['\r\n"
			+ "© 2005, Mercury Interactive (v. 011003-1.01-058)\r\n"
			+ "']");
	By errorMessage = By.xpath("//span[contains(text(), \"Enter\")]");
	
	public SignInPage(WebDriver driver) {
		super(driver);
	}
	
	public void typeEmail(String email) {
		type(email, userName);
	}
	
	public boolean emailInputPresent() {
		return isDisplayed(userName);
	}
	
	public void typePass(String pass) {
		type(pass, passlocator);
	}
	
	public boolean passInputPresent() {
		return isDisplayed(passlocator);
	}
	
	public void clickSubmit() {
		click(signInBtnLocator);
	}
	
	public String getErrorMessage() {
		return getText(errorMessage);
	}
}
