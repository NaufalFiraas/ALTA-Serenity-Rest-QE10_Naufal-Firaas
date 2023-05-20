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


public class GetListUsersStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("{int} as valid parameter page for get list users")
    public void asValidParameterPageForGetListUsers(int page) {
        reqresAPI.getListUser(page);
    }

    @When("Send GET request for get list users")
    public void sendGETRequestForGetListUsers() {
        SerenityRest.when().get(Constants.GET_LIST_USER_URL);
    }

    @Then("API response for get list users should return {int} OK status code")
    public void apiResponseForGetListUsersShouldReturnOKStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Response body page for get list users should be {int}")
    public void responseBodyPageForGetListUsersShouldBe(int page) {
        SerenityRest.and().body(ReqresResponses.PAGE, equalTo(page));
    }

    @And("Response body data for get list users should contains {int} users")
    public void responseBodyDataForGetListUsersShouldContainsUsers(int userCount) {
        SerenityRest.and().body(ReqresResponses.DATA + ".size()", equalTo(6));
    }

    @And("Validate get list users with valid page parameter response body JSON Schema")
    public void validateGetListUsersWithValidPageParameterResponseBodyJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "getListUsers/ValidPageParameterResponseBody.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("{int} as a valid exceeded parameter page for get list users")
    public void asAValidExceededParameterPageForGetListUsers(int page) {
        reqresAPI.getListUser(page);
    }

    @Then("API response for get list users should return {int} Not Found status code")
    public void apiResponseForGetListUsersShouldReturnNotFoundStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @Given("{string} as invalid parameter page for get list users")
    public void asInvalidParameterPageForGetListUsers(String page) {
        reqresAPI.getListUser(page);
    }

    @Then("API response for get list users should return {int} Bad Request status code")
    public void apiResponseForGetListUsersShouldReturnBadRequestStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @Given("Empty parameter page for get list users")
    public void emptyParameterPageForGetListUsers() {
        reqresAPI.getListUser("");
    }
}
