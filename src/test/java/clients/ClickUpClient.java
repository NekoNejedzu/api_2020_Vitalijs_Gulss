package clients;

import javax.ws.rs.core.Response;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class ClickUpClient {

    private static final String API_TOKEN = "pk_4532472_8OV7H15DJ38UDQS7VT4P8MJI93F0WTJH";
    private static final String CLICKUP_BASE_URL = "https://api.clickup.com/api/v2";
    private static final String CLICKUP_FOLDER_URL = "%s/folder/%s";


    public static ValidatableResponse fetchClickUpFolder(String folder_id) {
        ValidatableResponse boardResponse = given()
            .param("token", API_TOKEN)
            .when()
            .get(String.format(CLICKUP_FOLDER_URL, CLICKUP_BASE_URL, folder_id))
            .then()
            .log().ifValidationFails()
            .statusCode(Response.Status.OK.getStatusCode());
        return boardResponse;
    }


    public ValidatableResponse fetchListsFolder(String folder_id) {
        return given()
            .param("token", API_TOKEN)
            .when()
            .get(CLICKUP_BASE_URL + "/boards/" + folder_id + "/lists/")
            .then()
            .log()
            .ifValidationFails()
            .statusCode(Response.Status.OK.getStatusCode());
    }
    public ValidatableResponse fetchSpacefromFolder(String folder_id) {
        return given()
                .param("token", API_TOKEN)
                .when()
                .get(CLICKUP_BASE_URL + "/boards/" + folder_id + "/lists/")
                .then()
                .log()
                .ifValidationFails()
                .statusCode(Response.Status.OK.getStatusCode());
    }

    public static void deleteClickUpFolder(String folder_id) {
        given()
            .param("token", API_TOKEN)
            .param("value", "true")
            .when()
            .put(CLICKUP_BASE_URL + "/folder/" + folder_id + "/closed/")
            .then()
            .log()
            .ifValidationFails()
            .statusCode(Response.Status.OK.getStatusCode());
    }
}
