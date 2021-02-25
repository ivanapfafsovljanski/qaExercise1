package pages;

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
	
	
	public InitialPage(WebDriver driver, JavascriptExecutor js, ExcellReader readFromExcell) {
		this.driver = driver;
		this.js = js;
		this.readFromExcell = readFromExcell;
	}
	public void dismissLocation() {
		driver.findElement(By.className("close-btn-white")).click();
	}
	
	public void clickOnLoginBtn() {
		driver.findElement(By.className("filled")).click();
	}
	public void logIn() {
		driver.findElement(By.name("btn_submit")).click();
	}
	public void goToMyAccount() {
		driver.findElement(By.className("user-trigger-js")).click();
		driver.findElement(By.linkText("My Account")).click();
	}
	
}
