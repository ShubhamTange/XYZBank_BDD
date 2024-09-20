package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class Withdraw extends TestBase{
	
	By withdrawlOptBtn = By.xpath("//button[contains(text(), \"Withdrawl\")]");
	By amountTextBox = By.xpath("//input[@placeholder=\"amount\"]");
	By WithdrawSbmtBtn  = By.xpath("//button[contains(text(),'Withdraw') and @type='submit']");
	By accountsTobewithdrawText = By.xpath("//label[contains(text(),\"Amount to be Withdrawn\")]");
	By errMsgForInsufficientBalance = By.xpath("//span[@class=\"error ng-binding\" and contains(text(),\"Transaction Failed. You can not withdraw amount more than the balance.\")]");
	By successMsg = By.xpath("//span[@class=\"error ng-binding\" and contains(text(),\"Transaction successful\")]");
	By balance = By.xpath("//div[2]/strong[2]");
	static int beforeWithdrawBalance;
	
	public boolean userClicksOnWithdrawOption() {
	    // Write code here that turns the phrase above into concrete actions
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(withdrawlOptBtn)).click(); 
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(WithdrawSbmtBtn)).isDisplayed();
	}

	
	public boolean validating_amount_to_be_withdraw_input_text_box_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(amountTextBox)).isDisplayed();
	}

	
	public void enter_the_amount_to_be_withraw_from_the_account(Integer amount) {
	    // Write code here that turns the phrase above into concrete actions
		String amountTobeWithrawn = Integer.toString(amount);
		driver.findElement(amountTextBox).sendKeys(amountTobeWithrawn);
	}

	
	public boolean click_on_withdraw_btn() {
	    // Write code here that turns the phrase above into concrete actions
		beforeWithdrawBalance = Integer.parseInt(driver.findElement(balance).getText());
		driver.findElement(WithdrawSbmtBtn).click();
	    return driver.findElement(successMsg).isDisplayed();
	}

	
	public boolean withdraw_successful_message_Transaction_successful_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		return driver.findElement(successMsg).isDisplayed();
	}


	public boolean validate_balance_updated_properly_after_withdraw_money(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		int expectedWithdrawBalance = beforeWithdrawBalance-int1;
		int actAfterWithdrawBalance = Integer.parseInt(driver.findElement(balance).getText()); 
		return expectedWithdrawBalance==actAfterWithdrawBalance;
	}
	
	public boolean click_on_negative_moneywithdraw_btn() {
	    // Write code here that turns the phrase above into concrete actions
		beforeWithdrawBalance = Integer.parseInt(driver.findElement(balance).getText());
		driver.findElement(WithdrawSbmtBtn).click();
		int actAfterWithdrawBalance = Integer.parseInt(driver.findElement(balance).getText());
		boolean isOk = actAfterWithdrawBalance==beforeWithdrawBalance;
		
		driver.navigate().refresh();
		return isOk;
	}

	
	public boolean click_on_zero_moneywithdraw_btn() {
	    // Write code here that turns the phrase above into concrete actions
		beforeWithdrawBalance = Integer.parseInt(driver.findElement(balance).getText());
		driver.findElement(WithdrawSbmtBtn).click();
		int actAfterWithdrawBalance = Integer.parseInt(driver.findElement(balance).getText());
		boolean isOk = actAfterWithdrawBalance==beforeWithdrawBalance;
		driver.navigate().refresh();
		return isOk;
	
	}

	
	public boolean click_on_money_more_than_balance_tobe_withdrawn() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(WithdrawSbmtBtn).click();
		return driver.findElement(errMsgForInsufficientBalance).isDisplayed();
	}
}
