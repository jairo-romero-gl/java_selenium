package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SingInPage extends base {            //this class extends from the base file
	By UserName = By.name("userName");
	By Passlocator = By.name("password");
	By SignInBtnLocator = By.name("submit");
	
	By HomePageLocator = By.cssSelector("flooter['\r\n"
			+ "© 2005, Mercury Interactive (v. 011003-1.01-058)\r\n"
			+ "']");
	


	public SingInPage(WebDriver driver) {
		super(driver);
		
	}

	public void singIn() {                         //type the characters
		if (isDisplayed(UserName)) {
			type("julian8admin", UserName);
			type("julian8admin", Passlocator);
			click(SignInBtnLocator);
		}else {
			System.out.println("username Textbox Was not present");
		}
	}
	
	public boolean isHomePageDisplayed() {
		return isDisplayed(HomePageLocator);
		
	}

	
}
