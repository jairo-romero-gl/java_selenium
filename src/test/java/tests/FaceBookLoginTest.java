package tests;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.Test;

public class FaceBookLoginTest {
    private  WebDriver driver;
    
    
    @Before
    public void openFBPage(){  
    	DesiredCapabilities caps = new DesiredCapabilities();
    	System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://es-la.facebook.com/login/device-based/regular/login/?login_attempt=1&lwv=100");
		
    }
    
    @SuppressWarnings("deprecation")
	@Test
    public void loginToFB(){
       WebElement inputUserName =driver.findElement(By.id("email")); 
       WebElement inputPassword =driver.findElement(By.id("pass")); 
       WebElement buttonSumit =driver.findElement(By.id("loginbutton"));
       inputUserName.sendKeys("julian@gmail.com");
       inputPassword.sendKeys("12345678");
       buttonSumit.submit();
       
       driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
       
       WebElement message =driver.findElement(By.className("_9ay7"));
       
       System.out.println(message.getText());
    }

    
}

   

