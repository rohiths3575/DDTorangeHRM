Feature: registration page

  Scenario: registration
    Given user should be in Registration page
  
    When user clicks on gender 
    And user enters first name "Rohith"
    And user enters last name "S"
    And user enters email id "rohiths59@gmail.com"
    And user enters passward "Rohith#78"
    And user enters confirm passward "Rohith#78"
    And user clicks on login button 
    Then user gets message of the page
    And page message should be "Your registration completed"     