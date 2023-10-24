Feature: User is able to Successfully add Product in Your CART 
        
        
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
      | <Product Name>|
      Then User Reset App State

       
      Examples:
    | username                 | password     | Product Name            |
    | standard_user            | secret_sauce | Sauce Labs Backpack     | 
    | standard_user            | secret_sauce | Sauce Labs Bolt T-Shirt |
    | problem_user             | secret_sauce | Sauce Labs Bike Light   |
    
    
    
    @yourCart @positive @addremove        
Scenario Outline: Add and Remove Products from Your Cart 
      Given User enters "<username>" and "<password>"
      When User adds "<Product Name>" to cart  
      And  User adds "Sauce Labs Bolt T-Shirt" to cart 
      When User navigated to Your Cart page
      Then User lands on Your Cart Page
      And User Verify Products are visible on Your Cart Page
      | Products |
      | <Product Name>|
      | Sauce Labs Bolt T-Shirt |
      Then User Removes Products "<Product Name>"
      And User Verify that Product is removed "<Product Name>"
      And User Verify that Product is removed "Sauce Labs Bolt T-Shirt"
      Then User Reset App State

       
      Examples:
    | username                 | password     | Product Name            |
    | standard_user            | secret_sauce | Sauce Labs Backpack     | 
    | problem_user             | secret_sauce | Sauce Labs Bike Light   |
    
    
    
    
    
    
    