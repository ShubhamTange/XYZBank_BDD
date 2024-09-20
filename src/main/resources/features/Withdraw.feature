@priority3
Feature: Withdraw Functionality
 
  Scenario Outline: Validating the Withdraw functionality with valid data
  	Description: Withdraw money which is less than or equal to balance
    Given User should be logged in the banking system
    And should be able to view features like deposit, withdraw, accounts
    When User selects the account <accountNum>
    Then user clicks on withDrawOption
   	Then validating amount to be withdraw input text box should be displayed
   	Then enter the amount <amount> to be withraw from the account
    Then click on withdrawBtn
    Then validate balance <amount> updated properly after withdraw money
    Then withdraw successful message <message> should be displayed

    Examples: 
      | accountNum  | amount | message  |
      | 1005 |     2000 | Transaction Successful |
      |	1006 |		 1000 | Transaction Successful |

  Scenario Outline: Validating the withdraw functionality with invalid data withdraw negative money
    Description: Withdraw money which is less than 0
    Given User should be logged in the banking system
    And should be able to view features like deposit, withdraw, accounts
    When User selects the account <accountNum>
    Then user clicks on withDrawOption
   	Then validating amount to be withdraw input text box should be displayed
   	Then enter the amount <amount> to be withraw from the account
    Then click on negativeMoneywithdrawBtn
    
    Examples: 
      | accountNum  | amount | message  |
      | 1005 |     -763 |     |
     
  Scenario Outline: Validating the withdraw functionality with withdraw 0 amount
    Description: Withdraw money which is equal to 0
    Given User should be logged in the banking system
    And should be able to view features like deposit, withdraw, accounts
    When User selects the account <accountNum>
    Then user clicks on withDrawOption
   	Then validating amount to be withdraw input text box should be displayed
   	Then enter the amount <amount> to be withraw from the account
    Then click on zeroMoneywithdrawBtn
    
    Examples: 
      | accountNum  | amount | message  |
      | 1005 |     0 |     |
  
  Scenario Outline: Validating the withdraw functionality with invalid data with withdraw money more than balance
    Description: Withdraw money which is more than balance and validating the message
    Given User should be logged in the banking system
    And should be able to view features like deposit, withdraw, accounts
    When User selects the account <accountNum>
    Then user clicks on withDrawOption
   	Then validating amount to be withdraw input text box should be displayed
   	Then enter the amount <amount> to be withraw from the account
    Then click on moneyMoreThanBalanceTobeWithdrawn
    
    Examples: 
      | accountNum  | amount | message  |
      | 1005 |     10000 |     |
  