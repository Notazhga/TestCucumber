Feature: Login

  Scenario: Can log in with valid data
    When go to base url
    And login with username nkamarskaya and password o3CDWFAN
    Then assert Logged in
    And logout