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


public class PostCreateUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Request body for create user with name is morpheus and job is leader")
    public void requestBodyForCreateUserWithNameIsMorpheusAndJobIsLeader() {
        File json = new File(Constants.REQ_BODY_DIR + "createUser/ValidNameAndJob.json");
        reqresAPI.postCreateUser(json);
    }

    @When("Send POST request for create user")
    public void sendPOSTRequestForCreateUser() {
        SerenityRest.when().post(Constants.POST_CREATE_USER_URL);
    }

    @Then("API response for create user should be {int} Created status code")
    public void apiResponseForCreateUserShouldBeCreatedStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @And("Validate create user with valid name and valid job response body JSON Schema")
    public void validateCreateUserWithValidNameAndValidJobResponseBodyJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "createUser/ValidNameAndJobSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Response body name for create user should be {string}")
    public void responseBodyNameForCreateUserShouldBe(String name) {
        SerenityRest.and().body(ReqresResponses.NAME, equalTo(name));
    }

    @And("Response body job for create user should be {string}")
    public void responseBodyJobForCreateUserShouldBe(String job) {
        SerenityRest.and().body(ReqresResponses.JOB, equalTo(job));
    }

    @And("Response body id for create user cannot be empty")
    public void responseBodyIdForCreateUserCannotBeEmpty() {
        SerenityRest.and().body(ReqresResponses.ID, notNullValue());
    }

    @Given("Request body for create user with job is leader")
    public void requestBodyForCreateUserWithJobIsLeader() {
        File json = new File(Constants.REQ_BODY_DIR + "createUser/NoNameAndValidJob.json");
        reqresAPI.postCreateUser(json);
    }

    @Then("API response for create user should be {int} Bad Request status code")
    public void apiResponseForCreateUserShouldBeBadRequestStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @Given("Request body for create user with name is morpheus")
    public void requestBodyForCreateUserWithNameIsMorpheus() {
        File json = new File(Constants.REQ_BODY_DIR + "createUser/ValidNameAndNoJob.json");
        reqresAPI.postCreateUser(json);
    }

    @Given("Request body for create user with empty name and job is leader")
    public void requestBodyForCreateUserWithEmptyEmailAndJobIsLeader() {
        File json = new File(Constants.REQ_BODY_DIR + "createUser/EmptyNameAndValidJob.json");
        reqresAPI.postCreateUser(json);
    }

    @Given("Request body for create user with name is morpheus and empty job")
    public void requestBodyForCreateUserWithEmailIsMorpheusAndEmptyJob() {
        File json = new File(Constants.REQ_BODY_DIR + "createUser/ValidNameAndEmptyJob.json");
        reqresAPI.postCreateUser(json);
    }

    @Given("Request body for create user with name is 123 and job is leader")
    public void requestBodyForCreateUserWithNameIsAndJobIsLeader() {
        File json = new File(Constants.REQ_BODY_DIR + "createUser/NumberNameAndValidJob.json");
        reqresAPI.postCreateUser(json);
    }

    @Given("Request body for create user with name is morpheus and job is 123")
    public void requestBodyForCreateUserWithNameIsMorpheusAndJobIs() {
        File json = new File(Constants.REQ_BODY_DIR + "createUser/ValidNameAndNumberJob.json");
        reqresAPI.postCreateUser(json);
    }

    @Given("Empty request body for create user")
    public void emptyRequestBodyForCreateUser() {
        File json = new File(Constants.REQ_BODY_DIR + "createUser/EmptyRequest.json");
        reqresAPI.postCreateUser(json);
    }
}
