package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class Login extends TestBase {

	 WebDriverWait wait;
	 By customerLoginBtn = By.xpath("//button[text()=\"Customer Login\"]");
	 By userList = By.cssSelector("#userSelect");
	 String selectedUserFromList = "";
	 By loginBtn = By.xpath("//button[text()=\"Login\"]");
	 By userNameOnUI = By.xpath("//strong/span");
	 By welcomeText = By.xpath("//div[2]/div/div[1]/strong");
	 By accSelect = By.cssSelector("#accountSelect");
	 By accNum = By.xpath("//div[2]/strong[1]");
	 By balance = By.xpath("//div[2]/strong[2]");

	public  void clickOnCustomerLogin() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(customerLoginBtn));
		driver.findElement(customerLoginBtn).click();
	}

	public  boolean validateLoginURL() throws InterruptedException {
		
		Thread.sleep(2000);
		String expUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer";
		String actUrl = driver.getCurrentUrl();
		System.out.println("Expected LOGIN URL: "+ expUrl);
		System.out.println("Actual LOGIN URL: "+ actUrl);
		if (expUrl.equals(actUrl))
			return true;
		return false;
	}

	public  void selectName() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(userList));
		WebElement webElem = driver.findElement(userList);
		Select sel = new Select(webElem);

		sel.selectByIndex(2);
		Thread.sleep(2000);
		selectedUserFromList = sel.getFirstSelectedOption().getText();
	}

	public  void clickLoginBtn() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn));
		driver.findElement(loginBtn).click();
	}

	public  boolean validateLoginAccountNum() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(accSelect));
		WebElement webElem = driver.findElement(accSelect);
		Select sel = new Select(webElem);

		String selectedAcc = sel.getFirstSelectedOption().getText().trim();
		wait.until(ExpectedConditions.visibilityOfElementLocated(accNum));
		String accNumText = driver.findElement(accNum).getText().trim();

		System.out.println("selectedAccNumFromList: " + selectedAcc);
		System.out.println("accNumOnUI: " + accNumText);
		if (selectedAcc.equals(accNumText))
			return true;
		return false;
	}

	public  boolean validateLoginName() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(userNameOnUI));
		String accHolderNameOnUI = driver.findElement(welcomeText).getText();
		System.out.println("selectedUserFromList: " + selectedUserFromList);
		System.out.println("accHolderNameOnUI: " + accHolderNameOnUI);
		if (accHolderNameOnUI.contains(selectedUserFromList))
			return true;
		return false;
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		Login user = new Login();
		launchBrowser();
		navigateToURL();
		user.clickOnCustomerLogin();
		System.out.println("validateLoginURL: "+ user.validateLoginURL());
		user.selectName();
		user.clickLoginBtn();
		System.out.println("validateLoginAccountNum: "+user.validateLoginAccountNum());
		System.out.println("validateLoginName: "+ user.validateLoginName());
	}

}
