package tests;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;




public class Casov {

	private WebDriver driver;
	By videoLinkLocator =By.cssSelector("a[href=\"https://www.youtube.com/watch?v=R_hh3jAqn8M\"]");	
	
	@Before
	public void setUp() throws Exception {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.com/");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	
	
	@Test
	public void caso1_verificar() {
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("quality-stream introducción a la automatización de pruebas de software");
		searchBox.submit();
		/*
		String titulo_esperado="asserts de junit - Buscar con Google";
		String titulo_obtenido=driver.getTitle();
		System.out.println("titulo_obtenido   "+titulo_obtenido);
        
		//Implicit wait
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//Explicit wait
		
		 WebDriverWait Ewait = new WebDriverWait(driver,10);
		Ewait.until(ExpectedConditions.titleContains(titulo_esperado));
		
		
		assertEquals("al validar el titulo",titulo_esperado,titulo_obtenido);
	*/
	
		
		//FluentWait
		
		
		Wait<WebDriver> fwait =  new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))				
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class); 
		
		
		
		WebElement video = fwait.until(new Function<WebDriver,WebElement>(){
			public WebElement apply(WebDriver driver) {
				return driver.findElement(videoLinkLocator);
			}
		}
		);
		
		assertTrue(driver.findElement(videoLinkLocator).isDisplayed());
	} 
	
	
	
	@After
	public void tearDown() {
		driver.close();
	}
}
