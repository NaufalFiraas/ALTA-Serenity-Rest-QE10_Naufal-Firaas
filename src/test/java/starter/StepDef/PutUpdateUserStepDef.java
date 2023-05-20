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

public class PutUpdateUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Request body for update user with name is morpheus and job is zion resident and parameter id is {int}")
    public void requestBodyForUpdateUserWithNameIsMorpheusAndJobIsZionResidentAndParameterIdIs(int id) {
        File json = new File(Constants.REQ_BODY_DIR + "updateUser/ValidNameAndJob.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @When("Send PUT request for update user")
    public void sendPUTRequestForUpdateUser() {
        SerenityRest.when().put(Constants.PUT_UPDATE_USER_URL);
    }

    @Then("API response for update user should return {int} OK status code")
    public void apiResponseForUpdateUserShouldReturnOKStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate update user response body JSON Schema")
    public void validateUpdateUserResponseBodyJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "updateUser/ValidNameAndJobSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Response body name for update user should be {string}")
    public void responseBodyNameForUpdateUserShouldBe(String name) {
        SerenityRest.and().body(ReqresResponses.NAME, equalTo(name));
    }

    @And("Response body job for update user should be {string}")
    public void responseBodyJobForUpdateUserShouldBe(String job) {
        SerenityRest.and().body(ReqresResponses.JOB, equalTo(job));
    }

    @Given("Request body for update user with name is morpheus, job is zion resident, and parameter id is {int}")
    public void requestBodyForUpdateUserWithNameIsMorpheusJobIsZionResidentAndParameterIdIs(int id) {
        File json = new File(Constants.REQ_BODY_DIR + "updateUser/ValidNameAndJob.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @Then("API response for update user should return {int} Not Found status code")
    public void apiResponseForUpdateUserShouldReturnNotFoundStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @Given("Request body for update user with name is morpheus, job is zion resident, and parameter id is {string}")
    public void requestBodyForUpdateUserWithNameIsMorpheusJobIsZionResidentAndParameterIdIs(String id) {
        File json = new File(Constants.REQ_BODY_DIR + "updateUser/ValidNameAndJob.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @Then("API response for update user should return {int} Bad Request status code")
    public void apiResponseForUpdateUserShouldReturnBadRequestStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @Given("Request body for update user with name is morpheus, job is zion resident, and no parameter id")
    public void requestBodyForUpdateUserWithNameIsMorpheusJobIsZionResidentAndNoParameterId() {
        File json = new File(Constants.REQ_BODY_DIR + "updateUser/ValidNameAndJob.json");
        reqresAPI.putUpdateUser("", json);
    }

    @Given("Request body for update user with job is zion resident and parameter id is {int}")
    public void requestBodyForUpdateUserWithJobIsZionResidentAndParameterIdIs(int id) {
        File json = new File(Constants.REQ_BODY_DIR + "updateUser/NoNameAndValidJob.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @Given("Request body for update user with name is morpheus and parameter id is {int}")
    public void requestBodyForUpdateUserWithNameIsMorpheusAndParameterIdIs(int id) {
        File json = new File(Constants.REQ_BODY_DIR + "updateUser/ValidNameAndNoJob.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @Given("Request body for update user with empty name, job is zion resident, and parameter id is {int}")
    public void requestBodyForUpdateUserWithEmptyNameJobIsZionResidentAndParameterIdIs(int id) {
        File json = new File(Constants.REQ_BODY_DIR + "updateUser/EmptyNameAndValidJob.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @Given("Request body for update user with name is morpheus, empty job, and parameter id is {int}")
    public void requestBodyForUpdateUserWithNameIsMorpheusEmptyJobAndParameterIdIs(int id) {
        File json = new File(Constants.REQ_BODY_DIR + "updateUser/ValidNameAndEmptyJob.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @Given("Request body for update user with name is 123, job is zion resident, and parameter id is {int}")
    public void requestBodyForUpdateUserWithNameIsJobIsZionResidentAndParameterIdIs(int id) {
        File json = new File(Constants.REQ_BODY_DIR + "updateUser/NumberNameAndValidJob.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @Given("Request body for update user with name is morpheus, job is 123, and parameter id is {int}")
    public void requestBodyForUpdateUserWithNameIsMorpheusJobIsAndParameterIdIs(int id) {
        File json = new File(Constants.REQ_BODY_DIR + "updateUser/ValidNameAndNumberJob.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @Given("Empty request body for update user and parameter id is {int}")
    public void emptyRequestBodyForUpdateUserAndParameterIdIs(int id) {
        File json = new File(Constants.REQ_BODY_DIR + "updateUser/EmptyRequest.json");
        reqresAPI.putUpdateUser(id, json);
    }
}
