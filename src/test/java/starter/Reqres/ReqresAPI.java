package starter.Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.Utils.Constants;

import java.io.File;

public class ReqresAPI {
    private String path;

    @Step("Set URL path")
    public void setUrlPath(String path) {
        this.path = path;
    }

    @Step("Get complete URL")
    public String getCompleteUrl() {
        return Constants.BASE_URL + this.path;
    }

    @Step("Get list users")
    public void getListUserValidParamPage(Object page) {
        SerenityRest.given().pathParam("page", page);
    }

    @Step("Post create new user")
    public void postCreateUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Put update user")
    public void putUpdateUser(Object id, File json) {
        SerenityRest.given().pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete user")
    public void deleteUser(Object id) {
        SerenityRest.given().pathParam("id", id);
    }

    @Step("Post login user")
    public void postLoginUser(File json) {
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
}
