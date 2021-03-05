package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import tests.ExcellReader;

public class MyAddressPage {
	
	WebDriver driver;
	ExcellReader readFromExcell;
	JavascriptExecutor js;
	
	List<WebElement> btns;
	
	public MyAddressPage(WebDriver driver, ExcellReader readFromExcell, JavascriptExecutor js) {
		this.driver = driver;
		this.readFromExcell = readFromExcell;
	}
	public void listOfBtns() {
		btns = driver.findElements(By.className("txt"));
	}
	public void addingNewAddres() {
		listOfBtns();
		btns.get(0).click();
		
	}
	
	
	

}
