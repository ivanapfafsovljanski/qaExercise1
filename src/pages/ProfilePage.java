package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import tests.ExcellReader;

public class ProfilePage {
	WebDriver driver;
	ExcellReader readFromExcell;
	JavascriptExecutor js;
	//InitialPage pageHome ;
	WebElement lastNameField;
	WebElement userAddressField;
	WebElement phoneNo;
	WebElement avatarPhone;
	WebElement zipField;
	List<WebElement> saveBtns;
	Select countriDronDownList;
	WebElement currentPsw;
	WebElement newPsw;
	WebElement confirmPsw;
	WebElement mandatoryConfPswMsg;
	
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
	public void saveBtnsList() {
		saveBtns = driver.findElements(By.name("btn_submit"));
	}
	public void changeCountry() {
		countriDronDownList = new Select(driver.findElement(By.id("user_country_id")));
		countriDronDownList.selectByIndex(3);
	}
	public void changeFields() throws InterruptedException {
		lastNameField = driver.findElement(By.name("user_last_name"));
		lastNameField.clear();
		lastNameField.sendKeys(readFromExcell.taxtualValue("Profile", 2, 3));
		Thread.sleep(1000);
		userAddressField = driver.findElement(By.name("user_address"));
		userAddressField.clear();
		userAddressField.sendKeys(readFromExcell.taxtualValue("Profile", 4, 3));
		phoneNo = driver.findElement(By.name("user_phone"));
		phoneNo.clear();
		phoneNo.sendKeys(String.valueOf(readFromExcell.numericValue("Profile", 6, 3)));
		zipField = driver.findElement(By.name("user_zip"));
		zipField.clear();
		zipField.sendKeys(String.valueOf(readFromExcell.numericValue("Profile", 8, 3)));
		changeCountry();
		saveBtnsList();
		js.executeScript("arguments[0].click();", saveBtns.get(0));
	}
	public boolean masageForSevedProfile() {
		try {
			driver.findElement(By.className("alert--success"));
	        return true;
	    } catch (org.openqa.selenium.NoSuchElementException e) {
	        return false;
	    }
	}
	
	public String phoneNuChanged() {
		avatarPhone = driver.findElement(By.className("phone"));
		return avatarPhone.getText();
	}
	
	public void changePassword() {
		js.executeScript("window.scrollBy(0,200)");
		newPsw = driver.findElement(By.name("new_password"));
		newPsw.sendKeys(readFromExcell.taxtualValue("Profile", 22, 3));
		confirmPsw = driver.findElement(By.name("conf_new_password"));
		confirmPsw.sendKeys(readFromExcell.taxtualValue("Profile", 24, 3));	
	}
public void oldPsw() {
	currentPsw = driver.findElement(By.name("current_password"));
	currentPsw.clear();
	currentPsw.sendKeys(readFromExcell.taxtualValue("Profile", 22, 3));	
	newPsw.clear();
	confirmPsw.clear();
	}
	public void savePsw() {
		saveBtnsList();
		js.executeScript("arguments[0].click()", saveBtns.get(1));
		
	}
	public boolean messageForSavedPsw() {
		try {
			driver.findElement(By.className("content"));
			return true;
		}
		catch (org.openqa.selenium.NoSuchElementException e){
				return false;
			}
		}
	public void enterPswNoConfirmation()  {
		js.executeScript("window.scrollBy(0,150)");		
		newPsw = driver.findElement(By.name("new_password"));
		newPsw.sendKeys(readFromExcell.taxtualValue("Profile", 32, 3));	
	}
	public void enterDiferentConfPsw() {
		js.executeScript("window.scrollBy(0,150)");	
		newPsw = driver.findElement(By.name("new_password"));
		newPsw.sendKeys(readFromExcell.taxtualValue("Profile", 44, 3));
		confirmPsw = driver.findElement(By.name("conf_new_password"));
		confirmPsw.sendKeys(readFromExcell.taxtualValue("Profile", 46, 3));
	}
	/*public void noCurrentPsw() {
		js.executeScript("window.scrollBy(0,150)");	
		newPsw = driver.findElement(By.name("new_password"));
		newPsw.sendKeys(readFromExcell.taxtualValue("Profile", 44, 3));
		confirmPsw = driver.findElement(By.name("conf_new_password"));
		confirmPsw.sendKeys(readFromExcell.taxtualValue("Profile", 46, 3));
	}*/
	public String confirmPswMsg() {
		mandatoryConfPswMsg = driver.findElement(By.xpath("//*[@id=\"frm_fat_id_changePwdFrm\"]/div/div[3]/fieldset/ul/li[1]/a"));
		return mandatoryConfPswMsg.getText();
	}
	public String errorConfPswMsg() {
		return driver.findElement(By.className("erlist_conf_new_password")).getText();	
	}
	public String errorCurrentPswMsg() {
		return driver.findElement(By.className("erlist_current_password")).getText();	
	}
	
		
	}
	
	

