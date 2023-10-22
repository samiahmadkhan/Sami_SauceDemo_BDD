Feature: Test that User is able to Successfully add products and See them to Your Cart,
       and Checkout/Continue
        
        
Background: 
    Given User is on login page
    
 @yourCart @positive @addremove       
Scenario Outline: Add Products to Your Cart and verify they are visible 
      Given User enters "<username>" and "<password>"
      When User adds "<Product Name>" to cart  
      And User navigated to Your Cart page
      Then User lands on Your Cart Page
      And User Verify Products are visible on Your Cart Page
      | Products |
      | Sauce Labs Backpack     |
      Then User Reset App State

       
      Examples:
    | username                 | password     | Product Name            | 
    | standard_user            | secret_sauce | Sauce Labs Backpack     | 
    | standard_user            | secret_sauce | Sauce Labs Bolt T-Shirt |
    | problem_user             | secret_sauce | Sauce Labs Bike Light   |