package tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAddressTest extends BeginningClass{
	
	@BeforeMethod
	public void beforeMethod() {
		driver.navigate().to("http://demo.yo-meals.com/");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		pageHome.dismissLocation();
		pageHome.clickOnLoginBtn();
		pageHome.logIn();
		pageHome.goToMyAccount();
		pageMyAccount.myAddressClick();
	}
	
	@Test
	public void addAddress() {
		pageMyAddres.addingNewAddres();
	}
	
	@AfterMethod
	public void afterMethod() {
		pageHome.logOut();
	}

}
