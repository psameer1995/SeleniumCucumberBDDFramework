Feature: Customers

 Background: Below are the common steps for the each scenario 
	Given User Launch Chrome browser 
	When User opens URL "https://admin-demo.nopcommerce.com/login" 
	And User enters Email as "admin@yourstore.com" and password as "admin" 
	And Click on login 
	Then User can view Dashboard 

@regression
Scenario: Add a new Customer
    When User click on customers Menu
    And click on customers Menu Item
    And click on Add new button
    Then User can view Add new customer page.
    When User enter customer info
    And click on Save button
    Then User can view confirmation mesage "The new customer has been added successfully."
    And close browser
    
@sanity
Scenario: Search a Customer by EMailID
    When User click on customers Menu
    And click on customers Menu Item
    And Enter customer EMail
    When User click on search button
    Then User should found EMail in the Search table
    And close browser 
 
@regression 
Scenario: Search a Customer by Name
    When User click on customers Menu
    And click on customers Menu Item
    And Enter customer FirstName
    And Enter customer LastName
    When User click on search button
    Then User should found Name in the Search table
    And close browser     
    