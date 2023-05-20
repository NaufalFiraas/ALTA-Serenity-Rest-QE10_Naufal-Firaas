Feature: Post Create User

  @Tugas
  Scenario: Post create user with valid name and valid job
    Given Request body for create user with name is morpheus and job is leader
    When Send POST request for create user
    Then API response for create user should be 201 Created status code
    And Validate create user with valid name and valid job response body JSON Schema
    And Response body name for create user should be "morpheus"
    And Response body job for create user should be "leader"
    And Response body id for create user cannot be empty

  @Tugas
  Scenario: Post create user with no name and valid job
    Given Request body for create user with job is leader
    When Send POST request for create user
    Then API response for create user should be 400 Bad Request status code

  @Tugas
  Scenario: Post create user with valid name and no job
    Given Request body for create user with name is morpheus
    When Send POST request for create user
    Then API response for create user should be 400 Bad Request status code

  @Tugas
  Scenario: Post create user with empty name and valid job
    Given Request body for create user with empty name and job is leader
    When Send POST request for create user
    Then API response for create user should be 400 Bad Request status code

  @Tugas
  Scenario: Post create user with valid name and empty job
    Given Request body for create user with name is morpheus and empty job
    When Send POST request for create user
    Then API response for create user should be 400 Bad Request status code

  @Tugas
  Scenario: Post create user with number data type of name and valid job
    Given Request body for create user with name is 123 and job is leader
    When Send POST request for create user
    Then API response for create user should be 400 Bad Request status code

  @Tugas
  Scenario: Post create user with valid name and number data type of job
    Given Request body for create user with name is morpheus and job is 123
    When Send POST request for create user
    Then API response for create user should be 400 Bad Request status code

  @Tugas
  Scenario: Post create user with empty request body
    Given Empty request body for create user
    When Send POST request for create user
    Then API response for create user should be 400 Bad Request status code