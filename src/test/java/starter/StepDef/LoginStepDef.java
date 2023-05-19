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

public class LoginStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Request body with email is eve.holt@reqres.in and password is cityslicka")
    public void setRequestBodyWithEmailIsEveHoltReqresInAndPasswordIsCityslicka() {
        File json = new File(Constants.REQ_BODY_DIR + "login/ValidEmailAndPassword.json");
        reqresAPI.postLoginUser(json);
    }

    @When("Send POST login request")
    public void sendPOSTLoginRequest() {
        SerenityRest.when().post(Constants.POST_LOGIN_USER);
    }

    @Then("API response should return {int} OK status code")
    public void apiResponseShouldReturnOKStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @Given("Request body with empty email and password is cityslicka")
    public void setRequestBodyWithEmptyEmailAndPasswordIsCityslicka() {
        File json = new File(Constants.REQ_BODY_DIR + "login/EmptyEmailAndValidPassword.json.json");
        reqresAPI.postLoginUser(json);
    }

    @Then("API response should return {int} Bad Request status code")
    public void apiResponseShouldReturnBadRequestStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @Given("Request body with email is eve.holt@reqres.in and empty password")
    public void setRequestBodyWithEmailIsEveHoltReqresInAndEmptyPassword() {
        File json = new File(Constants.REQ_BODY_DIR + "login/ValidEmailAndEmptyPassword.json");
        reqresAPI.postLoginUser(json);
    }

    @Given("Request body with no email and password is cityslicka")
    public void setRequestBodyWithNoEmailAndPasswordIsCityslicka() {
        File json = new File(Constants.REQ_BODY_DIR + "login/NoEmailAndValidPassword.json");
        reqresAPI.postLoginUser(json);
    }

    @Given("Request body with email is eve.holt@reqres.in and no password")
    public void setRequestBodyWithEmailIsEveHoltReqresInAndNoPassword() {
        File json = new File(Constants.REQ_BODY_DIR + "login/ValidEmailAndNoPassword.json");
        reqresAPI.postLoginUser(json);
    }

    @Given("Request body with email is eve holt and password is cityslicka")
    public void setRequestBodyWithEmailIsEveHoltAndPasswordIsCityslicka() {
        File json = new File(Constants.REQ_BODY_DIR + "login/UnvalidEmailAndValidPassword.json");
        reqresAPI.postLoginUser(json);
    }

    @Given("Request body with email is 123 and password is cityslicka")
    public void setRequestBodyWithEmailIsAndPasswordIsCityslicka() {
        File json = new File(Constants.REQ_BODY_DIR + "login/NumberEmailAndValidPassword.json");
        reqresAPI.postLoginUser(json);
    }

    @Given("Request body with email is eve.holt@reqres.in and password is 123")
    public void setRequestBodyWithEmailIsEveHoltReqresInAndPasswordIs() {
        File json = new File(Constants.REQ_BODY_DIR + "login/ValidEmailAndNumberPassword.json");
        reqresAPI.postLoginUser(json);
    }

    @Given("Request body with email is naufal@gmail.com and password is cityslicka")
    public void setRequestBodyWithEmailIsNaufalGmailComAndPasswordIsCityslicka() {
        File json = new File(Constants.REQ_BODY_DIR + "login/UnregisteredUser.json");
        reqresAPI.postLoginUser(json);
    }

    @Then("API response should return {int} Not Found status code")
    public void apiResponseShouldReturnNotFoundStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Response body token cannot be empty")
    public void responseBodyTokenCannotBeEmpty() {
        SerenityRest.and().body(ReqresResponses.TOKEN, notNullValue());
    }

    @And("Validate login user with valid email and password response body JSON Schema")
    public void validateLoginUserWithValidEmailAndPasswordResponseBodyJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "login/ValidEmailAndPassword.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Response body error should be {string}")
    public void responseBodyErrorShouldBe(String message) {
        SerenityRest.and().body(ReqresResponses.ERROR, equalTo(message));
    }

    @And("Validate login user with valid email and no password response body JSON Schema")
    public void validateLoginUserWithValidEmailAndNoPasswordResponseBodyJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "login/ErrorSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Empty request body")
    public void emptyRequestBody() {
        File json = new File(Constants.REQ_BODY_DIR + "login/EmptyRequest.json");
        reqresAPI.postLoginUser(json);
    }
}
