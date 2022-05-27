package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFacebookPage extends base {
	
	public LoginFacebookPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By InputUserName = By.id("email");
	By InputPassword = By.id("pass");
	By SignInBtnLocator = By.id("loginbutton");
	
	public void singIn() {
		
			type("3122842752", InputUserName);
			type("julian8admin", InputPassword);
			click(SignInBtnLocator);
		}	
}