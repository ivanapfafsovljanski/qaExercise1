package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountTest extends BeginningClass{

	@BeforeMethod
	public void beforeMethod() {
		driver.navigate().to("http://demo.yo-meals.com/");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		pageHome.dismissLocation();
		pageHome.clickOnLoginBtn();
		pageHome.logIn();
	}
	
	@Test
	public void goToProfilePage() {
		pageHome.goToMyAccount();
		pageMyAccount.profileBtnClick();
		Assert.assertTrue(pageProfile.isAvatarInfoPresent());
	}
}
