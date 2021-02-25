package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import tests.ExcellReader;

public class ProfilePage {
	WebDriver driver;
	ExcellReader readFromExcell;
	JavascriptExecutor js;
	
	public ProfilePage(WebDriver driver, ExcellReader readFromExcell, JavascriptExecutor js) {
		this.driver = driver;
		this.readFromExcell = readFromExcell;
		this.js = js;
	}
	
	public boolean isAvatarInfoPresent() {
	    try {
	    	driver.findElement(By.className("avatar-info"));
	        return true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	        return false;
	    }
	}
}
