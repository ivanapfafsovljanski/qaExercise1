package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfileTest extends BeginningClass{
	//private String _psw;
	@BeforeMethod
	public void beforeMethod() {
		driver.navigate().to("http://demo.yo-meals.com/");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		
		pageHome.dismissLocation();
		pageHome.clickOnLoginBtn();
		pageHome.getPawValue();
		pageHome.logIn();
		pageHome.goToMyAccount();
		pageMyAccount.profileBtnClick();
	}
	@Test (priority = 1)
	public void changePersonalInfo() throws InterruptedException {
		pageProfile.changeFields();
		Thread.sleep(1000);
		Assert.assertEquals(pageProfile.phoneNuChanged(), String.valueOf(readFromExcell.numericValue("Profile", 6, 3)));
		//Assert.assertTrue(pageProfile.masageForSevedProfile());
	}
	@Test (priority = 10)
	public void changePassword() throws InterruptedException {
		pageProfile.changePassword();
		driver.findElement(By.name("current_password")).sendKeys(pageHome.passw);
		pageProfile.savePsw();
		Assert.assertTrue(pageProfile.messageForSavedPsw());
		Thread.sleep(2000);
		pageProfile.oldPsw();
		driver.findElement(By.name("new_password")).sendKeys(pageHome.passw);
		driver.findElement(By.name("conf_new_password")).sendKeys(pageHome.passw);
		pageProfile.savePsw();
	}
	@ Test (priority = 12)
	public void changePswNoConfirmation() throws InterruptedException {
		driver.findElement(By.name("current_password")).sendKeys(pageHome.passw);
		pageProfile.enterPswNoConfirmation();
		pageProfile.savePsw();
		Assert.assertEquals(pageProfile.confirmPswMsg(), readFromExcell.taxtualValue("Profile", 37, 4));
	}
	@Test 
	public void changePswDifCinfirmation() {
		driver.findElement(By.name("current_password")).sendKeys(pageHome.passw);
		pageProfile.enterDiferentConfPsw();
		pageProfile.savePsw();
		Assert.assertEquals(pageProfile.errorConfPswMsg(), readFromExcell.taxtualValue("Profile", 49, 4));
	}
	@Test
	public void noCurrentPsw() {
		pageProfile.changePassword();
		pageProfile.savePsw();
		Assert.assertEquals(pageProfile.errorCurrentPswMsg(), readFromExcell.taxtualValue("Profile", 62, 4));
	}
	@Test
	public void spaceOnBeginning() throws InterruptedException {
		pageProfile.spacePsw();
		driver.findElement(By.name("current_password")).sendKeys(pageHome.passw);
		pageProfile.savePsw();
		Assert.assertTrue(pageProfile.messageForSavedPsw());
		Thread.sleep(2000);
		pageProfile.oldPsw();
		driver.findElement(By.name("new_password")).sendKeys(pageHome.passw);
		driver.findElement(By.name("conf_new_password")).sendKeys(pageHome.passw);
		pageProfile.savePsw();
		}
	
	@AfterMethod
	public void afterMethod() {
		pageHome.logOut();
	}
	
}
