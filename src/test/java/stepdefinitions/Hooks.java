package stepdefinitions;

import clients.ClickUpClient;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import helpers.TestCaseContext;

import static clients.ClickUpClient.deleteTrelloList;


public class Hooks {
    private static final ClickUpClient TRELLO_CLIENT = new ClickUpClient();

    @Before
    public void beforeAll() {
        TestCaseContext.init();
    } //šis tiks izpildīts pirms visiem soļioem. Palaižot testu, šī ir nākošā vieta aiz TestRunner, kura tiek izpildīta

    @After("@ChangedBoardName")
    public void afterBoardNameHasBeenChanged() {
        TRELLO_CLIENT.updateTrelloBoardName(
            TestCaseContext.get().getTrelloBoard().getId(),
            "This is default name for board");
    }

    @After("@CreatedNewList")
    public void afterWasCreatedNewList() {
        deleteTrelloList(TestCaseContext.get().getClickUpList().getId());
    }
}