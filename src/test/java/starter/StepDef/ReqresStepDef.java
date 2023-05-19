package starter.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Utils.Constants;

import java.io.File;

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
