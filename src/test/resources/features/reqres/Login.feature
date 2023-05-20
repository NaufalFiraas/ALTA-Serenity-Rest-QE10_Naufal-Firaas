Feature: POST Login User

  @Tugas
  Scenario: Login user with valid email and password
    Given Request body with email is eve.holt@reqres.in and password is cityslicka
    When Send POST login request
    Then API response should return 200 OK status code
    And Response body token cannot be empty
    And Validate login user with valid email and password response body JSON Schema

  @Tugas
  Scenario: Login user with empty email and valid password
    Given Request body with empty email and password is cityslicka
    When Send POST login request
    Then API response should return 400 Bad Request status code

  @Tugas
  Scenario: Login user with valid email and empty password
    Given Request body with email is eve.holt@reqres.in and empty password
    When Send POST login request
    Then API response should return 400 Bad Request status code

  @Tugas
  Scenario: Login user with no email and valid password
    Given Request body with no email and password is cityslicka
    When Send POST login request
    Then API response should return 400 Bad Request status code

  @Tugas
  Scenario: Login user with valid email and no password
    Given Request body with email is eve.holt@reqres.in and no password
    When Send POST login request
    Then API response should return 400 Bad Request status code
    And Response body error should be "Missing password"
    And Validate login user with valid email and no password response body JSON Schema

  @Tugas
  Scenario: Login user with not valid email format and valid password
    Given Request body with email is eve holt and password is cityslicka
    When Send POST login request
    Then API response should return 400 Bad Request status code

  @Tugas
  Scenario: Login user with number data type of email and valid password
    Given Request body with email is 123 and password is cityslicka
    When Send POST login request
    Then API response should return 400 Bad Request status code

  @Tugas
  Scenario: Login user with valid email and number data type of password
    Given Request body with email is eve.holt@reqres.in and password is 123
    When Send POST login request
    Then API response should return 400 Bad Request status code

  @Tugas
  Scenario: Login with valid email and password for unregistered user
    Given Request body with email is naufal@gmail.com and password is cityslicka
    When Send POST login request
    Then API response should return 404 Not Found status code

  @Tugas
  Scenario: Login with empty request body
    Given Empty request body
    When Send POST login request
    Then API response should return 400 Bad Request status code