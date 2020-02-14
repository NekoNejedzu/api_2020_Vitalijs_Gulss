package helpers;

import clients.ClickUpClient;
import domain.Board;

public class BoardHelper {

    private static final ClickUpClient TRELLO_CLIENT = new ClickUpClient(); //šajā brīdī no TrelloClient klases tiek
    // izveidots objekts. Mēs šo objektu inicializējām kā klases lauku tādēļ, lai ērti piekļūtu šim objektam nop
    // visām šīs klases metodēm. lai nebūtu katrā metodē no jauan jāraksta new TrelloObject()

    public static Board getTrelloBoard(String boardId) {
        return TRELLO_CLIENT.fetchTrelloBoard(boardId)
            .extract()
            .response()
            .as(Board.class); //šeit notiek Deserializācija no JSON uz Board objektu. izmantojot validatableResponse
        // iebūvētās metode, extract(), response(), as()
    }


}
