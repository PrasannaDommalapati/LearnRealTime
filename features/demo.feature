@runAll
Feature: Login to gmail
  
  //Acceptance Criteria: Told by the product owner

  @sanity @regression
  Scenario Outline: Enter valid username and password and click on Login button
    Given The user is in Gmail page
    When the user enters valid "<username>" and valid "<password>" and clicks on logon button
    Then Homepage should be displayed

    Examples: 
      | username       | password       |
      | linda.anderson | linda.anderson |

  @smoke
  Scenario Outline: Enter invalid username and password and click on Login button
    Given The user is in Gmail page
    When the user enters invalid "<username>" and invalid "<password>" and clicks on logon button
    Then Error message should be displayed

    Examples: 
      | username       | password |
      | linda.anderson | demo123  |

  Scenario Outline: Verify login with valid username and empty password
    Given The user is in Gmail page
    When the user enters valid "<username>" and empty "<password>" and clicks on logon button
    Then Error message should be displayed

    Examples: 
      | username       | password |
      | linda.anderson |          |

  Scenario Outline: Verify login with empty username and empty password
    Given The user is in Gmail page
    When the user enters empty "<username>" and empty "<password>" and clicks on logon button
    Then Error message should be displayed

    Examples: 
      | username | password |
      |          |          |

  Scenario Outline: Verify login with empty username and valid password
    Given The user is in Gmail page
    When the user enters empty "<username>" and valid "<password>" and clicks on logon button
    Then Error message should be displayed

    Examples: 
      | username | password |
      |          | demo123  |

  Scenario Outline: Enter invalid username and password and click on Login button
    Given The user is in Gmail page
    When the user enters invalid "<username>" and valid "<password>" and clicks on logon button
    Then Error message should be displayed

    Examples: 
      | username          | password |
      | linda.andersjjjon | demo123  |

  Scenario Outline: Enter invalid username and password and click on Login button
    Given The user is in Gmail page
    When the user enters valid "<username>" and invalid "<password>" and clicks on logon button
    Then Error message should be displayed

    Examples: 
      | username       | password    |
      | linda.anderson | demossss123 |
