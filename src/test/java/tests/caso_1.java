package tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class caso_1 {

	private WebDriver driver;
		
	@Before
	public void setUp() {
		
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
		searchBox.sendKeys("asserts de junit");
		searchBox.submit();
		String titulo_esperado="asserts de junit - Buscar con Google";
		String titulo_obtenido=driver.getTitle();
		System.out.println("titulo_obtenido   "+titulo_obtenido);
        
		driver.manage().timeouts().pageLoadTimeout(7, TimeUnit.SECONDS);
		assertEquals("al validar el titulo",titulo_esperado,titulo_obtenido);
	}
	
	
	@Test
	public void caso1_sabersi() {
		Boolean CampoVisible=true;
		assertTrue("ver si el campo es visible",CampoVisible);
		
	}
		
	
	
	@Test
	public void caso1_saberno() {
		Boolean CampoVisible=false;
		assertTrue("ver si el campo es visible",CampoVisible);
	}
	
	

	@After
	public void tearDown() {
		driver.close();
	}
}
