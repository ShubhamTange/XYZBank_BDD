package stepdefinations;

import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Then;
import pages.Withdraw;

public class WithdrawTC {
	
	Withdraw user = new Withdraw();
	@Then("user clicks on withDrawOption")
	public void user_clicks_on_with_draw_option() {
	    // Write code here that turns the phrase above into concrete actions
	    assertTrue(user.userClicksOnWithdrawOption());
	}

	@Then("validating amount to be withdraw input text box should be displayed")
	public void validating_amount_to_be_withdraw_input_text_box_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(user.validating_amount_to_be_withdraw_input_text_box_should_be_displayed());
	}

	@Then("enter the amount {int} to be withraw from the account")
	public void enter_the_amount_to_be_withraw_from_the_account(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		user.enter_the_amount_to_be_withraw_from_the_account(int1);
	}

	@Then("click on withdrawBtn")
	public void click_on_withdraw_btn() {
	    // Write code here that turns the phrase above into concrete actions
	    assertTrue(user.click_on_withdraw_btn());
	}

	@Then("validate balance {int} updated properly after withdraw money")
	public void validate_balance_updated_properly_after_withdraw_money(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    assertTrue(user.validate_balance_updated_properly_after_withdraw_money(int1));
	}

	@Then("withdraw successful message Transaction Successful should be displayed")
	public void withdraw_successful_message_Transaction_successful_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    assertTrue(user.withdraw_successful_message_Transaction_successful_should_be_displayed());
	}

	@Then("click on negativeMoneywithdrawBtn")
	public void click_on_negative_moneywithdraw_btn() {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(user.click_on_negative_moneywithdraw_btn());
	}

	@Then("click on zeroMoneywithdrawBtn")
	public void click_on_zero_moneywithdraw_btn() {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(user.click_on_zero_moneywithdraw_btn());
	}

	@Then("click on moneyMoreThanBalanceTobeWithdrawn")
	public void click_on_money_more_than_balance_tobe_withdrawn() {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(user.click_on_money_more_than_balance_tobe_withdrawn());
	}
}
