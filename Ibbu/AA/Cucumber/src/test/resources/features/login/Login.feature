Feature: Contact center login

  @ibbu
  Scenario Outline: Verify login with valid data
    Given User is on Home Page
    Then Login to Contact center application Using "<dataScenarios>"
    And Verify Login
    
    

    Examples: 
      | dataScenarios |
      | PossitiveData |
