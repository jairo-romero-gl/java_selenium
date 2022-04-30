package com.proyect.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class base {

	private WebDriver driver;
	
	public base(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public WebDriver edgeDriverConnection() {
    System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
    driver = new EdgeDriver();
    return driver;
    
	}
	
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
		
	}
   public List<WebElement> findElements(By locator){
	   return driver.findElements(locator);
	   
   }
	public String GetText(WebElement element) {
		return element.getText();
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	public void type (String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
		
	}
	
	public void click (By locator) {
		driver.findElement(locator).click();
	}
	
	public  Boolean isDisplayed(By locator) {
	 try {
		 return driver.findElement(locator).isDisplayed();
	 } catch (org.openqa.selenium.NoSuchElementException e) {
		 return false;
	 }
	}
	public void visit(String url) {
		driver.get(url);
	}
}
