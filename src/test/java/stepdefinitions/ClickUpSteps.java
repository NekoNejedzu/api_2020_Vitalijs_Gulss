package stepdefinitions;

import java.util.List;

import clients.ClickUpClient;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import domain.Board;
import domain.ClickUpList;
import helpers.TestCaseContext;

import static helpers.BoardHelper.getTrelloBoard;
import static helpers.ListHelper.createTrelloListInBoard;
import static helpers.ListHelper.getTrelloListsFromBoard;
import static org.assertj.core.api.Assertions.assertThat;

public class ClickUpSteps {

    private static final ClickUpClient TRELLO_CLIENT = new ClickUpClient();

    @Given("Some dummy step")
    public void somedummyStep() {
        System.out.println("It works!");
    }

    @Given("User has Trello board with id {string}")
    public void userHasTrelloBoardWithId(String boardIdFromFeatureFile) {
        Board fetchedTrelloBoard = getTrelloBoard(boardIdFromFeatureFile);

        TestCaseContext.get().setTrelloBoard(fetchedTrelloBoard);

        assertThat(fetchedTrelloBoard.getId()).isEqualTo(boardIdFromFeatureFile);
    }

    @When("user changes Trello board name to {string}")
    public void userChangesTrelloBoardName(String boardNamePassedFromFeaturesFile) {
        final String boardId = TestCaseContext.get().getTrelloBoard().getId();

        TRELLO_CLIENT.updateTrelloBoardName(boardId, boardNamePassedFromFeaturesFile);
    }

    @Then("Trello board name has been changed to {string}")
    public void trelloBoardNameHasBeenChanged(String expectedBoardNamePassedFromFeaturesFile) {
        final String boardId = TestCaseContext.get().getTrelloBoard().getId();

        Board fetchedTrelloBoard = getTrelloBoard(boardId);
        assertThat(fetchedTrelloBoard.getId()).isEqualTo(boardId).as("validates board ID");
        assertThat(fetchedTrelloBoard.getName()).isEqualTo(expectedBoardNamePassedFromFeaturesFile);
    }

    @When("Add a new list to board with name {string}")
    public void addANewListToBoardWithName(String listName) {
        ClickUpList clickUpListInBoard = createTrelloListInBoard(
            TestCaseContext.get().getTrelloBoard().getId(),
            listName);

        TestCaseContext.get().setClickUpList(clickUpListInBoard);

    }

    @Then("in board can be found newly created list")
    public void inBoardCanBeFoundNewlyCreatedList() throws Exception{
        String boardId = TestCaseContext.get().getTrelloBoard().getId();
        String trelloListId = TestCaseContext.get().getClickUpList().getId();
        String trelloListName = TestCaseContext.get().getClickUpList().getName();

        List<ClickUpList> fetchedClickUpListFromBoard = getTrelloListsFromBoard(boardId);


        fetchedClickUpListFromBoard.stream()
            .filter(tl -> tl.getId().equals(trelloListId) && tl.getName().equals(trelloListName))
            .findFirst()
            .orElseThrow(() -> new Exception("Didn't find needed Trello List"));

    }
}
