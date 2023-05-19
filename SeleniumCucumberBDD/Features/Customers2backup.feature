Feature: Customers


Scenario: Add a new Customer
    Given User Launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and password as "admin"
    And Click on login
    Then User can view Dashboard
    When User click on customers Menu
    And click on customers Menu Item
    And click on Add new button
    Then User can view Add new customer page.
    When User enter customer info
    And click on Save button
    Then User can view confirmation mesage "The new customer has been added successfully."
    And close browser
    


Scenario: Search a Customer by EMailID
    Given User Launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and password as "admin"
    And Click on login
    Then User can view Dashboard
    When User click on customers Menu
    And click on customers Menu Item
    And Enter customer EMail
    When User click on search button
    Then User should found EMail in the Search table
    And close browser   