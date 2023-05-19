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

public class ReqresStepDef {
    @Steps
    ReqresAPI reqresAPI;

    //    GET LIST USERS
    @Given("Get list users with valid parameter page {int}")
    public void getListUsersWithValidParameterPage(int page, String path) {
        reqresAPI.getListUserValidParamPage(page);
    }

    @When("Send get lists users")
    public void sendGetListsUsers() {
        SerenityRest.when().get(Constants.GET_LIST_USER_URL);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body page should be {int}")
    public void responseBodyPageShouldBe(int page) {
        SerenityRest.and().body("page", equalTo(page)); // validasi key "page" di response nya (bukan keseluruhan response body) apa sama dengan yg kita tentukan
    }

    @And("Validate get list user JSON Schema")
    public void validateGetListUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "ListUserJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //    POST CREATE NEW USER
    @Given("Post create user with valid json")
    public void postCreateUserWithValidJson(String path) {
        File json = new File(Constants.REQ_BODY_DIR + "UserReqBody.json");
        reqresAPI.postCreateUser(json);
    }

    @When("Send post create user")
    public void sendPostCreateUser() {
        SerenityRest.when().post(Constants.POST_CREATE_USER_URL);
    }

    @Then("Status code should {int} Created")
    public void statusCodeShouldCreated(int created) {
        SerenityRest.then().statusCode(created);
    }

    @And("Response body name was {string} and job was {string}")
    public void responseBodyNameWasAndJobWas(String name, String job) {
        SerenityRest.and().body(ReqresResponses.NAME, equalTo(name)).body(ReqresResponses.JOB, equalTo(job));
    }

    @And("Validate post create user JSON Schema")
    public void validatePostCreateUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "PostCreateUserJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //    PUT UPDATE USER
    @Given("Put update user with valid json and id {int}")
    public void putUpdateUserWithValidJsonAndId(int id, String path) {
        File json = new File(Constants.REQ_BODY_DIR + "UserReqBody.json");
        reqresAPI.putUpdateUser(id, json);
    }

    @When("Send put update user")
    public void sendPutUpdateUser() {
        SerenityRest.when().put(Constants.PUT_UPDATE_USER_URL);
    }

    @And("Response body for put name was {string} and job was {string}")
    public void responseBodyForPutNameWasAndJobWas(String name, String job) {
        SerenityRest.and().body(ReqresResponses.NAME, equalTo(name)).body(ReqresResponses.JOB, equalTo(job));
    }

    @And("Validate put update user JSON Schema")
    public void validatePutUpdateUserJSONSchema() {
        File json = new File(Constants.JSON_SCHEMA_DIR + "PutUpdateUserJSONSchema.json");
        SerenityRest.and().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    //    DELETE USER
    @Given("Delete user with id {int}")
    public void deleteUserWithId(int id, String path) {
        reqresAPI.deleteUser(id);
    }

    @When("Send delete user")
    public void sendDeleteUser() {
        SerenityRest.when().delete(Constants.DELETE_USER_URL);
    }

    @Then("Status code should be {int} No Content")
    public void statusCodeShouldBeNoContent(int noContent) {
        SerenityRest.then().statusCode(noContent);
    }
}
