package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
	WebDriver driver;
	WebElement profileBtn;

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	public void profileBtnClick() {
		driver.findElement(By.xpath("//*[@id=\"fixed__panel\"]/ul/li[2]/a")).click();
	}
	
	
	
	

}
