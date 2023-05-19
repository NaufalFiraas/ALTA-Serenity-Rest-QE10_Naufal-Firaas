package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Reqres.ReqresResponses;
import starter.Utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class RegisterStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Request body for register with email is eve.holt@reqres.in and password is pistol")
    public void requestBodyWithEmailIsEveHoltReqresInAndPasswordIsPistol() {
        File json = new File(Constants.REQ_BODY_DIR + "register/ValidEmailAndPassword.json");
        reqresAPI.postRegisterUser(json);
    }

    @When("Send POST register request")
    public void sendPOSTRegisterRequest() {
        SerenityRest.when().post(Constants.POST_REGISTER_USER);
    }

    @And("Response body id and token cannot be empty")
    public void responseBodyIdAndTokenCannotBeEmpty() {
        SerenityRest.and().body(ReqresResponses.ID, notNullValue()).body(ReqresResponses.TOKEN, notNullValue());
    }

    @And("Validate register user with valid email and password response body JSON Schema")
    public void validateRegisterUserWithValidEmailAndPasswordResponseBodyJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "register/ValidEmailAndPassword.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Request body for register with email is eve.holt@reqres.in")
    public void requestBodyWithEmailIsEveHoltReqresIn() {
        File json = new File(Constants.REQ_BODY_DIR + "register/ValidEmailAndNoPassword.json");
        reqresAPI.postRegisterUser(json);
    }

    @And("Validate register user with valid email and no password response body JSON Schema")
    public void validateRegisterUserWithValidEmailAndNoPasswordResponseBodyJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "register/ValidEmailAndNoPassword.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Request body for register with password is pistol")
    public void requestBodyWithPasswordIsPistol() {
        File json = new File(Constants.REQ_BODY_DIR + "register/NoEmailAndValidPassword.json");
        reqresAPI.postRegisterUser(json);
    }

    @Given("Request body for register with email is empty and password is pistol")
    public void requestBodyWithEmailIsEmptyAndPasswordIsPistol() {
        File json = new File(Constants.REQ_BODY_DIR + "register/EmptyEmailAndValidPassword.json");
        reqresAPI.postRegisterUser(json);
    }

    @Then("API response for register should return {int} OK status code")
    public void apiResponseForRegisterShouldReturnOKStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @Then("API response for register should return {int} Bad Request status code")
    public void apiResponseForRegisterShouldReturnBadRequestStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Response body error for register should be {string}")
    public void responseBodyErrorForRegisterShouldBe(String message) {
        SerenityRest.and().body(ReqresResponses.ERROR, equalTo(message));
    }

    @Given("Request body for register with email is eve.holt@reqres.in and empty password")
    public void requestBodyForRegisterWithEmailIsEveHoltReqresInAndEmptyPassword() {
        File json = new File(Constants.REQ_BODY_DIR + "register/ValidEmailAndEmptyPassword.json");
        reqresAPI.postRegisterUser(json);
    }
}
