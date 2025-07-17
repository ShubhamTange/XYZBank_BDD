package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class Deposit extends TestBase {

	By wlcmMsg = By.xpath("//div[2]/div/div[1]/strong");
	By logoutBtn = By.xpath("//button[text()=\"Logout\"]");
	By accSelect = By.cssSelector("#accountSelect");
	By transactionBtn = By.xpath("//button[contains(text(), \"Transactions\")]");
	By depositBtn = By.xpath("//button[contains(text(), \"Deposit\")]");
	By withdrawlBtn = By.xpath("//button[contains(text(), \"Withdrawl\")]");
	By depositSubmitBtn = By.xpath("//button[text()=\"Deposit\"]");
	By amountTextBox = By.xpath("//input[@placeholder=\"amount\"]");
	By depositMsg = By.xpath("//div[2]/div/div[4]/div/span");
	By balance = By.xpath("//div[2]/strong[2]");
	static int balanceBeforeDeposit;
	static int balanceAfterDeposit;
	
	private Login user;
	static Map<String, List<Transaction>> depositHistory = new HashMap<String, List<Transaction>>();
	
	class Transaction{
		String date;
		String amount;
		String transactionType;
		
		public Transaction(String date, String amount, String transactionType) {
			super();
			this.date = date;
			this.amount = amount;
			this.transactionType = transactionType;
		}

		@Override
		public String toString() {
			return "Transaction [date=" + date + ", amount=" + amount + ", transactionType=" + transactionType + "]";
		}
		
	}
	
	public Deposit() {
		user = new Login();
	}

	public boolean validateUserLoggedInIntoTheSystem() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(wlcmMsg));
		String wlcm = driver.findElement(wlcmMsg).getText();
		System.out.println("wlcm msg : " + wlcm);
		System.out.println("User name: " + user.selectedUserFromList);
		System.out.println("Logout displayed: " + driver.findElement(logoutBtn).isDisplayed());
		WebElement logoutElem = driver.findElement(logoutBtn);

		if (wlcm.contains(user.selectedUserFromList) && logoutElem.isDisplayed())
			return true;
		return false;

	}

	public boolean validateHomeScreen() {
		boolean isAllOptionDisplayed = false;
		WebElement transactionOpt = driver.findElement(transactionBtn);
		WebElement depositOpt = driver.findElement(depositBtn);
		WebElement withdrawlOpt = driver.findElement(withdrawlBtn);
		System.out.println(
				"transactionOpt.isDisplayed(): " + transactionOpt.isDisplayed() + "\ndepositOpt.isDisplayed(): "
						+ depositOpt.isDisplayed() + "\nwithdrawlOpt.isDisplayed(): " + withdrawlOpt.isDisplayed());
		if ((transactionOpt.isDisplayed() && depositOpt.isDisplayed()) && withdrawlOpt.isDisplayed())
			isAllOptionDisplayed = true;
		else
			isAllOptionDisplayed = false;

		System.out.println("isAllOptionDisplayed: " + isAllOptionDisplayed);
		return isAllOptionDisplayed;

	}

	public boolean selectAcc(int accNum) throws InterruptedException {
		String accNumText = Integer.toString(accNum);
		WebElement webelem = driver.findElement(accSelect);
		Select accSel = new Select(webelem);
		accSel.selectByVisibleText(accNumText);
		Thread.sleep(2000);
		String selectedAcc = accSel.getFirstSelectedOption().getText();
		System.out.println("selectedAcc: " + selectedAcc);
		if (accSel.getFirstSelectedOption().getText().equals(accNumText))
			return true;
		return false;
	}

	public boolean clickOnDeposit() {

		driver.findElement(depositBtn).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(depositSubmitBtn)).isDisplayed();
	}

	public boolean validateDepositInputTextBox() {
		return driver.findElement(amountTextBox).isDisplayed();
	}

	public void enterAmountToBeDeposited(int amount) {
		String amountInText = Integer.toString(amount);
		driver.findElement(amountTextBox).sendKeys(amountInText);

		String enteredAmount = driver.findElement(amountTextBox).getText();
		System.out.println("enteredAmount: " + enteredAmount);
//		if(enteredAmount.equals(amountInText))
//			return true;
//		return false;

	}

	public boolean clickOnDepositSubmit() {
		balanceBeforeDeposit = Integer.parseInt(driver.findElement(balance).getText());
		System.out.println("balanceBeforeDeposit : " + balanceBeforeDeposit);
		driver.findElement(depositSubmitBtn).click();
		System.out.println();
		balanceAfterDeposit = Integer.parseInt(driver.findElement(balance).getText());
		System.out.println("balanceAfterDeposit : " + balanceAfterDeposit);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(depositMsg)).getText();
		System.out.println(successMsg);
		
		return driver.findElement(depositMsg).isDisplayed();

	}

	public boolean validateBalanceAfterDeposit(int amount) {
		
		boolean isOk = false;
//		switch(amount) {
//		case amount>=1:
//			if(balanceAfterDeposit-balanceBeforeDeposit==amount) {
//				System.out.println("Amount added properly");
//				return true;
//			}else {
//				System.out.println("Not Added propely");
//			}
//			break;
//		case 
//			
//		}
		if(balanceAfterDeposit-balanceBeforeDeposit==amount) {
			System.out.println("Amount added properly");
			return true;
		}
		return false;
	}

	public boolean clickOnNegativeDepositSubmit() {
		// Write code here that turns the phrase above into concrete actions
		String balanceBeforeDeposit = driver.findElement(balance).getText();
		driver.findElement(depositSubmitBtn).click();
		String balanceAfterDeposit = driver.findElement(balance).getText();
		System.out.println();
		driver.navigate().refresh();

		return balanceBeforeDeposit.equals(balanceAfterDeposit);
	}

	public boolean clickOnZeroDepositSubmit() {
		// Write code here that turns the phrase above into concrete actions
		String balanceBeforeDeposit = driver.findElement(balance).getText();
		driver.findElement(depositSubmitBtn).click();
		String balanceAfterDeposit = driver.findElement(balance).getText();
		System.out.println();
		driver.navigate().refresh();

		return balanceBeforeDeposit.equals(balanceAfterDeposit);
	}

	public void validateMessage(String message) {
		System.out.println("yet to create method...");
	}
	
	public void addInfoToTransaction(String accNum, String amount, String date, String transactionType) {
		List<Transaction> depositTransaction = new ArrayList<Transaction>();
		accNum ="2002";
		date = "05/6/2024";
		amount = "5618";
		transactionType = "Deposit";
		Transaction tr  = new Transaction(date, amount, transactionType);
		depositHistory.put(accNum, depositTransaction);
		
		Transactions.arrayDeposit.add(depositTransaction);
		ArrayList<Object> myList =  Transactions.arrayDeposit;
		System.out.println(myList);
	}
	
	public static void main(String[] args) throws InterruptedException, IOException {

		Deposit user = new Deposit();
//		launchBrowser();
//		navigateToURL();
////		Login.clickOnCustomerLogin();
////		System.out.println("validateLoginURL: "+ Login.validateLoginURL());
////		Login.selectName();
////		Login.clickLoginBtn();
////		System.out.println("validateLoginAccountNum: "+Login.validateLoginAccountNum());
////		System.out.println("validateLoginName: "+ Login.validateLoginName());
//		System.out.println("validateUserLoggedInIntoTheSystem(): " + user.validateUserLoggedInIntoTheSystem());
//		System.out.println("validateHomeScreen: " + user.validateHomeScreen());
//		System.out.println("selectAcc: " + user.selectAcc(1005));
//		System.out.println("clickOnDeposit: " + user.clickOnDeposit());
//		System.out.println("validateDepositInputTextBox: " + user.validateDepositInputTextBox());
//		user.enterAmountToBeDeposited(25000);
//		System.out.println("clickOnDepositSubmit: " + user.clickOnDepositSubmit());
		
		user.addInfoToTransaction("2002", "5618", "05/6/2024", "Deposit");

	}
}