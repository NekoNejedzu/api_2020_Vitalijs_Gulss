package clients;

import javax.ws.rs.core.Response;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class ClickUpClient {
    private static final String API_KEY = "cdbcf943831002c7a7caddb4ffc47de8";
    private static final String API_TOKEN = "075110c36068fdc58035be84096c9d2e98da479e6ce39d499aaa5a3084dc0380";
    private static final String TRELLO_BASE_URL = "https://api.trello.com/1";
    private static final String TRELLO_BOARD_URL = "%s/boards/%s";


    public ValidatableResponse fetchTrelloBoard(String boardId) {
        ValidatableResponse boardResponse = given()
            .param("key", API_KEY)
            .param("token", API_TOKEN)
            .when()
            .get(String.format(TRELLO_BOARD_URL, TRELLO_BASE_URL, boardId))
            .then()
            .log().ifValidationFails()
            .statusCode(Response.Status.OK.getStatusCode());
        return boardResponse;
    }

    public void updateTrelloBoardName(String boardId, String newBoardName) {
        given()
            .param("key", API_KEY)
            .param("token", API_TOKEN)
            .param("name", newBoardName)
            .when()
            .put(String.format(TRELLO_BOARD_URL, TRELLO_BASE_URL, boardId))
            .then()
            .log()
            .ifValidationFails()
            .statusCode(Response.Status.OK.getStatusCode());
    }

    public ValidatableResponse addListToBoard(String boardId,
                                              String listName) {
        return given().
            queryParam("key", API_KEY).
            queryParam("token", API_TOKEN).
            queryParam("name", listName).
            queryParam("idBoard", boardId).
            contentType(ContentType.JSON).
            when().
            post("https://api.trello.com/1/lists").
            then().
            log().
            ifValidationFails().
            statusCode(Response.Status.OK.getStatusCode());
    }

    public ValidatableResponse fetchListsFromBoard(String boardId) {
        return given().
            param("key", API_KEY)
            .param("token", API_TOKEN)
            .when()
            .get(TRELLO_BASE_URL + "/boards/" + boardId + "/lists/")
            .then()
            .log()
            .ifValidationFails()
            .statusCode(Response.Status.OK.getStatusCode());
    }

    public static void deleteTrelloList(String listId) {
        given().
            param("key", API_KEY)
            .param("token", API_TOKEN)
            .param("value", "true")
            .when()
            .put(TRELLO_BASE_URL + "/list/" + listId + "/closed/")
            .then()
            .log()
            .ifValidationFails()
            .statusCode(Response.Status.OK.getStatusCode());
    }
}
