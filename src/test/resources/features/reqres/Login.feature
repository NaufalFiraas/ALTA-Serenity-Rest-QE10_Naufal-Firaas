Feature: POST Login User

  @Tugas
  Scenario: Login user with valid email and password
    Given URL path is "/api/login"
    When Set request body with email is eve.holt@reqres.in and password is cityslicka
    And Send POST login request
    Then API response should return 200 OK status code
#    And API response should return body contains token

  @Tugas
  Scenario: Login user with empty email and valid password
    Given URL path is "/api/login"
    When Set request body with empty email and password is cityslicka
    And Send POST login request
    Then API response should return 400 Bad Request status code
#    And API response should return body contains message related to missing email

  @Tugas
  Scenario: Login user with valid email and empty password
    Given URL path is "/api/login"
    When Set request body with email is eve.holt@reqres.in and empty password
    And Send POST login request
    Then API response should return 400 Bad Request status code
#    And API response should return body contains message reelated to missing password

  @Tugas
  Scenario: Login user with no email and valid password
    Given URL path is "/api/login"
    When Set request body with no email and password is cityslicka
    And Send POST login request
    Then API response should return 400 Bad Request status code
#    And API response should return body contains message related to missing email

  @Tugas
  Scenario: Login user with valid email and no password
    Given URL path is "/api/login"
    When Set request body with email is eve.holt@reqres.in and no password
    And Send POST login request
    Then API response should return 400 Bad Request status code
#    And API response should return body contains message related to missing password

  @Tugas
  Scenario: Login user with not valid email format and valid password
    Given URL path is "/api/login"
    When Set request body with email is eve holt and password is cityslicka
    And Send POST login request
    Then API response should return 400 Bad Request status code
#    And API response should return body contains message related to not valid email

  @Tugas
  Scenario: Login user with number data type of email and valid password
    Given URL path is "/api/login"
    When Set request body with email is 123 and password is cityslicka
    And Send POST login request
    Then API response should return 400 Bad Request status code
#    And API response should return body contains message related to not valid email

  @Tugas
  Scenario: Login user with valid email and number data type of password
    Given URL path is "/api/login"
    When Set request body with email is eve.holt@reqres.in and password is 123
    And Send POST login request
    Then API response should return 400 Bad Request status code
#    And API response should return body contains message related to wrong data type of password

  @Tugas
  Scenario: Login with valid email and password for unregistered user
    Given URL path is "/api/login"
    When Set request body with email is naufal@gmail.com and password is cityslicka
    And Send POST login request
    Then API response should return 404 Not Found status code
#    And API response should return body contains message related to user not found
