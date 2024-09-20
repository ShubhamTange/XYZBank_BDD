@priority2
Feature: Transaction Functionality
 
  Scenario Outline: Validating the transaction functionality
    Given User should be logged in the banking system
    And should be able to view features like deposit, withdraw, accounts
    When User selects the account <accountNum>
    Then user clicks on transactionsOption
   	Then validate the transaction page and validate the url
   	Then validate the table details #needs to add map to validate the details

    Examples: 
      | accountNum | 
      | 1005 |    
      |	1006 |
