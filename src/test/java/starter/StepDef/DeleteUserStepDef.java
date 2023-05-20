package starter.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.Reqres.ReqresAPI;
import starter.Utils.Constants;

public class DeleteUserStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("{int} as a valid parameter id for delete user")
    public void asAValidIdForDeleteUser(int id) {
        reqresAPI.deleteUser(id);
    }

    @When("Send DELETE request for delete user")
    public void sendDELETERequestForDeleteUser() {
        SerenityRest.when().delete(Constants.DELETE_USER_URL);
    }

    @Then("API response for delete user should return {int} No Content status code")
    public void apiResponseForDeleteUserShouldReturnNoContentStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @Given("{int} as exceeded parameter id for delete user")
    public void asExceededParameterIdForDeleteUser(int id) {
        reqresAPI.deleteUser(id);
    }

    @Then("API response for delete user should return {int} Not Found status code")
    public void apiResponseForDeleteUserShouldReturnNotFoundStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @Given("{string} as invalid parameter id for delete user")
    public void asInvalidParameterIdForDeleteUser(String id) {
        reqresAPI.deleteUser(id);
    }

    @Then("API response for delete user should return {int} Bad Request status code")
    public void apiResponseForDeleteUserShouldReturnBadRequestStatusCode(int statusCode) {
        SerenityRest.then().statusCode(statusCode);
    }

    @Given("Empty parameter id for delete user")
    public void emptyParameterIdForDeleteUser() {
        reqresAPI.deleteUser("");
    }
}
