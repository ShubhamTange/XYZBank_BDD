package stepdefinations;

import java.io.IOException;

import base.TestBase;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Deposit;
import pages.Login;

public class DepositTC extends TestBase{

	private static Deposit user;
	
	@Before
	public void init() throws IOException, InterruptedException {
		if(driver==null) {
			launchBrowser();
			navigateToURL();
			Login user = new Login();
			user.clickOnCustomerLogin();
			user.selectName();
			user.clickLoginBtn();
		}
		user = new Deposit();
	}
	
	@Given("User should be logged in the banking system")
	public void user_should_be_logged_in_the_banking_system() {
	    // Write code here that turns the phrase above into concrete actions
	   
		user.validateUserLoggedInIntoTheSystem();
	}

	@And("should be able to view features like deposit, withdraw, accounts")
	public void should_be_able_to_view_features_like_deposit_withdraw_accounts() {
	    // Write code here that turns the phrase above into concrete actions
	    user.validateHomeScreen();
	}

	@When("User selects the account {int}")
	public void user_selects_the_account(Integer int1) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    user.selectAcc(int1);
	}

	@Then("user clicks on depositOption")
	public void user_clicks_on_depositOption() {
	    // Write code here that turns the phrase above into concrete actions
	    user.clickOnDeposit();
	}

	@Then("validating amount to be deposited input text box should be displayed")
	public void validating_amount_to_be_deposited_input_text_box_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	   user.validateDepositInputTextBox();
	}

	@Then("enter the amount {int} to be deposited into the account")
	public void enter_the_amount_to_be_deposited_into_the_account(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    user.enterAmountToBeDeposited(int1);
	}

	@Then("click on depositSubmit")
	public void click_on_depositSubmit() {
	    // Write code here that turns the phrase above into concrete actions
	    user.clickOnDepositSubmit();
	}

	@Then("click on zeroDepositSubmit")
	public void click_on_zero_deposit_submit() {
	    // Write code here that turns the phrase above into concrete actions
		user.clickOnNegativeDepositSubmit();
	}
	
	@Then("click on negativeDepositSubmit")
	public void click_on_negative_deposit_submit() {
	    // Write code here that turns the phrase above into concrete actions
	    user.clickOnNegativeDepositSubmit();
	}
	
	@Then("validate balance {int} updated properly")
	public void validate_balance_updated_properly(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	
	@Then("deposit successful message Deposit Successful should be displayed")
	public void deposit_successful_message_deposit_successful_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    user.validateMessage("mesaage");
	    driver.navigate().refresh();
	}

}
