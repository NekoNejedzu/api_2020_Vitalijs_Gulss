package helpers;

import java.util.List;

import clients.ClickUpClient;
import domain.ClickUpList;

public class ListHelper {

    private static final ClickUpClient TRELLO_CLIENT = new ClickUpClient();

    public static ClickUpList createTrelloListInBoard(String boardId,
                                                      String listName) {
        return TRELLO_CLIENT.addListToBoard(boardId, listName).
            extract()
            .response()
            .body()
            .as(ClickUpList.class);
    }

    public static List<ClickUpList> getTrelloListsFromBoard(String boardId) { //nejaukt javas List objektu ar Trello
        // listi
        return TRELLO_CLIENT.fetchListsFromBoard(boardId).extract().body().jsonPath().getList("$.", ClickUpList.class);
    }


}
