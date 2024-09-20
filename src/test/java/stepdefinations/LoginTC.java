package stepdefinations;

import java.io.IOException;

import org.testng.annotations.BeforeClass;

import base.TestBase;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Login;

public class LoginTC extends TestBase{
	private static Login user;
	
	@Before
	public void init() throws IOException {
		if(driver==null) {
			launchBrowser();
			
		}
		user = new Login();
		
	}

	@Given("user is on xyz bank url")
	public void user_is_on_xyz_bank_url() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		navigateToURL();
		
	}

	@When("user selects customer login")
	public void user_selects_customer_login() {
		// Write code here that turns the phrase above into concrete actions
		user.clickOnCustomerLogin();
	}

	@When("validate the url")
	public void validate_the_url() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		user.validateLoginURL();
	}

	@Then("user needs to select customer name from dropdown")
	public void user_needs_to_select_customer_name_from_dropdown() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		user.selectName();
	}

	@Then("user needs to click on login button'")
	public void user_needs_to_click_on_login_button() {
		// Write code here that turns the phrase above into concrete actions
		user.clickLoginBtn();
	}

	@And("after login validate welcome message, account number and balance")
	public void after_login_validate_welcome_message_account_number_and_balance() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		user.validateLoginAccountNum();
		user.validateLoginName();
	}

}
