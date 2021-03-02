package tests;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.InitialPage;
import pages.MyAccountPage;
import pages.ProfilePage;

public class BeginningClass {
	WebDriver driver;
	ExcellReader readFromExcell;
	JavascriptExecutor js;
	InitialPage pageHome;
	MyAccountPage pageMyAccount;
	ProfilePage pageProfile;
	
	
	
@BeforeClass
public void beforeClass() throws IOException {
	
	System.setProperty("webdriver.chrome.driver",
				"driver-lib\\chromedriver.exe");
	this.driver = new ChromeDriver();
	this.readFromExcell = new ExcellReader("data\\TestCase.xlsx");
	this.js = (JavascriptExecutor) driver;
	this.pageHome = new InitialPage(driver, js, readFromExcell);
	this.pageMyAccount = new MyAccountPage(driver);
	this.pageProfile = new ProfilePage(driver, readFromExcell, js);
	
	driver.manage().window().maximize();
	
}
//@AfterClass
public void afterClass() {
	driver.close();
}
}
