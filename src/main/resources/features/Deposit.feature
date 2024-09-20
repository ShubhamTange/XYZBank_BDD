@priority2
Feature: Deposit Functionality
 
  Scenario Outline: Validating the deposit functionality with valid data
    Given User should be logged in the banking system
    And should be able to view features like deposit, withdraw, accounts
    When User selects the account <accountNum>
    Then user clicks on depositOption
   	Then validating amount to be deposited input text box should be displayed
   	Then enter the amount <amount> to be deposited into the account
    Then click on depositSubmit
    Then validate balance <amount> updated properly
    Then deposit successful message <message> should be displayed

    Examples: 
      | accountNum  | amount | message  |
      | 1005 |     4000 | Deposit Successful |
      |	1006 |		 6000 | Deposit Successful |

  Scenario Outline: Validating the deposit functionality with invalid data adding negative deposit money
    Given User should be logged in the banking system
    And should be able to view features like deposit, withdraw, accounts
    When User selects the account <accountNum>
    Then user clicks on depositOption
   	Then validating amount to be deposited input text box should be displayed
   	Then enter the amount <amount> to be deposited into the account
    Then click on negativeDepositSubmit
    
    Examples: 
      | accountNum  | amount | message  |
      | 1005 |     -763 |     |
     
  Scenario Outline: Validating the deposit functionality with invalid data adding zero deposit money
    Given User should be logged in the banking system
    And should be able to view features like deposit, withdraw, accounts
    When User selects the account <accountNum>
    Then user clicks on depositOption
   	Then validating amount to be deposited input text box should be displayed
   	Then enter the amount <amount> to be deposited into the account
    Then click on zeroDepositSubmit
    
    Examples: 
      | accountNum  | amount | message  |
      | 1005 |     0 |     |
  