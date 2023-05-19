Feature: Login

@sanity
Scenario: Successful Login with Valid Credentials
    Given User Launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and password as "admin"
    And Click on login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on Logout link
    Then Page title should be "Your store. Login"
    And close browser
  
@regression
Scenario Outline: Login Data Driven
    Given User Launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "<email>" and password as "<password>"
    And Click on login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on Logout link
    Then Page title should be "Your store. Login"
    And close browser
    
    Examples:
        | email | password |
        | admin@yourstore.com | admin |
        | admin@yourstore1.com | admin |
        | admin@yourstore2.com | admin |