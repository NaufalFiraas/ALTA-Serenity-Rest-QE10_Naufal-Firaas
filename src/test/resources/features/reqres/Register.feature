Feature: POST Register User

  @Tugas
  Scenario: Register user with valid email and valid password
    Given Request body for register with email is eve.holt@reqres.in and password is pistol
    When Send POST register request
    Then API response for register should return 200 OK status code
    And Response body id and token cannot be empty
    And Validate register user with valid email and password response body JSON Schema

  @Tugas
  Scenario: Register with valid email and no password
    Given Request body for register with email is eve.holt@reqres.in
    When Send POST register request
    Then API response for register should return 400 Bad Request status code
    And Response body error for register should be "Missing password"
    And Validate register user with valid email and no password response body JSON Schema

  @Tugas
  Scenario: Register with no email and valid password
    Given Request body for register with password is pistol
    When Send POST register request
    Then API response for register should return 400 Bad Request status code

  @Tugas
  Scenario: Register with empty email and valid password
    Given Request body for register with email is empty and password is pistol
    When Send POST register request
    Then API response for register should return 400 Bad Request status code

  @Tugas
  Scenario: Register with valid email and empty password
    Given Request body for register with email is eve.holt@reqres.in and empty password
    When Send POST register request
    Then API response for register should return 400 Bad Request status code