package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import tests.ExcellReader;

public class InitialPage {
	WebDriver driver;
	JavascriptExecutor js;
	ExcellReader readFromExcell;
	WebElement logInBtn;
	WebElement userBtn;
	
	WebElement pswValue;
	public String passw;
	
	public InitialPage(WebDriver driver, JavascriptExecutor js, ExcellReader readFromExcell) {
		this.driver = driver;
		this.js = js;
		this.readFromExcell = readFromExcell;
	}
	public void dismissLocation() {
		boolean isDisplayed;
		try {
			driver.findElement(By.className("close-btn-white"));
			
	        isDisplayed = true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	    	isDisplayed = false;
	    }
		
		if(isDisplayed) {
			driver.findElement(By.className("close-btn-white")).click();	
		}	
	}
	
	public void clickOnLoginBtn() {
		driver.findElement(By.className("filled")).click();
	}
	public String getPawValue() {
		pswValue = driver.findElement(By.name("password"));
		passw = pswValue.getAttribute("value");
		return passw;
	}
	public void logIn() {
		driver.findElement(By.name("btn_submit")).click();
	}
	public void goToMyAccount() {
		userBtn = driver.findElement(By.className("user-trigger-js"));
		userBtn.click();
		driver.findElement(By.linkText("My Account")).click();
	}
	public void logOut() {
		userBtn = driver.findElement(By.className("user-trigger-js"));
		userBtn.click();
		driver.findElement(By.linkText("Logout")).click();
	}
	
}
