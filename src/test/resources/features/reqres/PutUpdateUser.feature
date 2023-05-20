Feature: Put Update User

  @Tugas
  Scenario Outline: Put update user with valid name, valid job, and valid id
    Given Request body for update user with name is morpheus and job is zion resident and parameter id is <id>
    When Send PUT request for update user
    Then API response for update user should return 200 OK status code
    And Validate update user response body JSON Schema
    And Response body name for update user should be "morpheus"
    And Response body job for update user should be "zion resident"
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |

  @Tugas
  Scenario: Put update user with valid name, valid job, and exceeded valid id
    Given Request body for update user with name is morpheus, job is zion resident, and parameter id is 50
    When Send PUT request for update user
    Then API response for update user should return 404 Not Found status code

  @Tugas
  Scenario Outline: Put update user with valid name, valid job, and not valid id
    Given Request body for update user with name is morpheus, job is zion resident, and parameter id is "<id>"
    When Send PUT request for update user
    Then API response for update user should return 400 Bad Request status code
    Examples:
      | id |
      | @  |
      | >  |
      | +  |

  @Tugas
  Scenario: Put update user with valid name, valid job, and no id
    Given Request body for update user with name is morpheus, job is zion resident, and no parameter id
    When Send PUT request for update user
    Then API response for update user should return 400 Bad Request status code

  @Tugas
  Scenario: Put update user with no name, valid job, and valid id
    Given Request body for update user with job is zion resident and parameter id is 2
    When Send PUT request for update user
    Then API response for update user should return 400 Bad Request status code

  @Tugas
  Scenario: Put Update user with valid name, no job, and valid id
    Given Request body for update user with name is morpheus and parameter id is 2
    When Send PUT request for update user
    Then API response for update user should return 400 Bad Request status code

  @Tugas
  Scenario: Put update user with empty name, valid job, and valid id
    Given Request body for update user with empty name, job is zion resident, and parameter id is 2
    When Send PUT request for update user
    Then API response for update user should return 400 Bad Request status code

  @Tugas
  Scenario: Put update user with valid name, empty job, and valid id
    Given Request body for update user with name is morpheus, empty job, and parameter id is 2
    When Send PUT request for update user
    Then API response for update user should return 400 Bad Request status code

  @Tugas
  Scenario: Put update user with number data type of name, valid job, and valid id
    Given Request body for update user with name is 123, job is zion resident, and parameter id is 2
    When Send PUT request for update user
    Then API response for update user should return 400 Bad Request status code

  @Tugas
  Scenario: Put update user with valid name, number data type of job, and valid id
    Given Request body for update user with name is morpheus, job is 123, and parameter id is 2
    When Send PUT request for update user
    Then API response for update user should return 400 Bad Request status code

  @Tugas
  Scenario: Put update user with empty request body and valid id
    Given Empty request body for update user and parameter id is 2
    When Send PUT request for update user
    Then API response for update user should return 400 Bad Request status code