package stepdefinitions;

import clients.ClickUpClient;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import helpers.TestCaseContext;

import static clients.ClickUpClient.deleteClickUpFolder;


public class Hooks {
    private static final ClickUpClient CLICK_UP_CLIENT = new ClickUpClient();

    @Before
    public void beforeAll() {
        TestCaseContext.init();
    }
    @After("@CreatedNewList")
    public void afterWasCreatedNewList() {
        deleteClickUpFolder(TestCaseContext.get().getClickUpFolder().getId());
    }
}