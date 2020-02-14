package helpers;


import domain.Board;
import domain.ClickUpList;

public class TestCaseContext {

    private static final ThreadLocal<TestCaseContext> THREAD_LOCAL = new ThreadLocal<>();

    private TestCaseContext() { //šī klase nepieciešama, lai tajā tiktu glabātas kopīgas lietas, ko dalīt starp soļiem
    }

    private Board trelloBoard;
    private ClickUpList clickUpList;


    public static TestCaseContext get() {
        return THREAD_LOCAL.get();
    }

    public static void init() {

        THREAD_LOCAL.set(new TestCaseContext());

    }

    public Board getTrelloBoard() {
        return trelloBoard;
    }

    public void setTrelloBoard(final Board trelloBoard) {
        this.trelloBoard = trelloBoard;
    }

    public ClickUpList getClickUpList() {
        return clickUpList;
    }

    public void setClickUpList(final ClickUpList clickUpList) {
        this.clickUpList = clickUpList;
    }
}