
@tag
Feature: Error Validation
  I want to use this template for my feature file



  @tag2
  Scenario Outline: Title of your scenario outline
   Given I landed on Ecommerce Page
    And Logged in with username<username> and password<password>
    Then "Login Successfully" message is displayed

    Examples: 
      | username  								 	   | password 			 
      | rahulshetty@gmail.com				   |     IamKing@000 