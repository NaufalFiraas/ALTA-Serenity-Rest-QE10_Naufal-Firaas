package starter.Reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ReqresAPI {
    private String path;
    private static final String DIR = System.getProperty("user.dir");
    public static final String REQ_BODY_DIR = DIR + "/src/test/resources/JSON/ReqBody/";
    public static final String JSON_SCHEMA_DIR = DIR + "/src/test/resources/JSON/JSONSchema/";

    @Step("Set URL path")
    public void setUrlPath(String path) {
        this.path = path;
    }

    @Step("Get complete URL")
    public String getCompleteUrl() {
        return "https://reqres.in" + this.path;
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
