package stepdefinitions;

import java.util.List;

import clients.ClickUpClient;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import domain.Folder;
import domain.ClickUpList;
import helpers.TestCaseContext;

import static helpers.BoardHelper.getClickUpFolder;
import static helpers.ListHelper.getListFromFolder;
import static org.assertj.core.api.Assertions.assertThat;

public class ClickUpSteps {

    private static final ClickUpClient CLICK_UP_CLIENT = new ClickUpClient();



    @Given("User has Trello board with id {string}")
    public void userHasFolderWithID(String folder_idfromfile) {

            Folder fetchedTrelloFolder = getClickUpFolder(folder_idfromfile);

            TestCaseContext.get().setclickUpFolder(fetchedTrelloFolder);

            assertThat(fetchedTrelloFolder.getId()).isEqualTo(folder_idfromfile);
        }


    @When("I verify ID and name")
    public void iVerifyIDAndName() {

    }

    @Then("Delete created folder")
    public void deleteCreatedFolder() {
    }
}
