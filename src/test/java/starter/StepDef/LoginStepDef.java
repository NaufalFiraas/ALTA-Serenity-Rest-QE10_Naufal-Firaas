package starter.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;

import java.io.File;

public class LoginStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("URL path is {string}")
    public void urlPathIs(String path) {
        reqresAPI.setUrlPath(path);
    }

    @When("Set request body with email is eve.holt@reqres.in and password is cityslicka")
    public void setRequestBodyWithEmailIsEveHoltReqresInAndPasswordIsCityslicka() {
        File json = new File(ReqresAPI.REQ_BODY_DIR + "login/ValidEmailAndPassword.json");
        reqresAPI.postLoginUser(json);
    }

    @And("Send POST login request")
    public void sendPOSTLoginRequest() {
        SerenityRest.when().post(reqresAPI.getCompleteUrl());
    }

    @Then("API response should return {int} OK status code")
    public void apiResponseShouldReturnOKStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @When("Set request body with empty email and password is cityslicka")
    public void setRequestBodyWithEmptyEmailAndPasswordIsCityslicka() {
        File json = new File(ReqresAPI.REQ_BODY_DIR + "login/EmptyEmailAndValidPassword.json");
        reqresAPI.postLoginUser(json);
    }

    @Then("API response should return {int} Bad Request status code")
    public void apiResponseShouldReturnBadRequestStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @When("Set request body with email is eve.holt@reqres.in and empty password")
    public void setRequestBodyWithEmailIsEveHoltReqresInAndEmptyPassword() {
        File json = new File(ReqresAPI.REQ_BODY_DIR + "login/ValidEmailAndEmptyPassword.json");
        reqresAPI.postLoginUser(json);
    }

    @When("Set request body with no email and password is cityslicka")
    public void setRequestBodyWithNoEmailAndPasswordIsCityslicka() {
        File json = new File(ReqresAPI.REQ_BODY_DIR + "login/NoEmailAndValidPassword.json");
        reqresAPI.postLoginUser(json);
    }

    @When("Set request body with email is eve.holt@reqres.in and no password")
    public void setRequestBodyWithEmailIsEveHoltReqresInAndNoPassword() {
        File json = new File(ReqresAPI.REQ_BODY_DIR + "login/ValidEmailAndNoPassword.json");
        reqresAPI.postLoginUser(json);
    }

    @When("Set request body with email is eve holt and password is cityslicka")
    public void setRequestBodyWithEmailIsEveHoltAndPasswordIsCityslicka() {
        File json = new File(ReqresAPI.REQ_BODY_DIR + "login/UnvalidEmailAndValidPassword.json");
        reqresAPI.postLoginUser(json);
    }

    @When("Set request body with email is 123 and password is cityslicka")
    public void setRequestBodyWithEmailIsAndPasswordIsCityslicka() {
        File json = new File(ReqresAPI.REQ_BODY_DIR + "login/NumberEmailAndValidPassword.json");
        reqresAPI.postLoginUser(json);
    }

    @When("Set request body with email is eve.holt@reqres.in and password is 123")
    public void setRequestBodyWithEmailIsEveHoltReqresInAndPasswordIs() {
        File json = new File(ReqresAPI.REQ_BODY_DIR + "login/ValidEmailAndNumberPassword.json");
        reqresAPI.postLoginUser(json);
    }

    @When("Set request body with email is naufal@gmail.com and password is cityslicka")
    public void setRequestBodyWithEmailIsNaufalGmailComAndPasswordIsCityslicka() {
        File json = new File(ReqresAPI.REQ_BODY_DIR + "login/UnregisteredUser.json");
        reqresAPI.postLoginUser(json);
    }

    @Then("API response should return {int} Not Found status code")
    public void apiResponseShouldReturnNotFoundStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }
}
