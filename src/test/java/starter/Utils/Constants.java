package starter.Utils;

public class Constants {
    public static final String BASE_URL = "https://reqres.in";
    private static final String DIR = System.getProperty("user.dir");
    public static final String REQ_BODY_DIR = DIR + "/src/test/resources/JSON/ReqBody/";
    public static final String JSON_SCHEMA_DIR = DIR + "/src/test/resources/JSON/JSONSchema/";

    public static final String GET_LIST_USER_URL = BASE_URL + "/api/users?page={page}";
    public static final String POST_CREATE_USER_URL = BASE_URL + "/api/users";
    public static final String PUT_UPDATE_USER_URL = BASE_URL + "/api/users/{id}";
    public static final String DELETE_USER_URL = BASE_URL + "/api/users/{id}";
    public static final String POST_LOGIN_USER = BASE_URL + "/api/login";
    public static final String POST_REGISTER_USER = BASE_URL + "/api/register";
}
