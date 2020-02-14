package helpers;


import domain.Folder;
import domain.ClickUpList;

public class TestCaseContext {

    private static final ThreadLocal<TestCaseContext> THREAD_LOCAL = new ThreadLocal<>();

    private TestCaseContext() { //šī klase nepieciešama, lai tajā tiktu glabātas kopīgas lietas, ko dalīt starp soļiem
    }

    private Folder ClickUpFolder;
    private ClickUpList clickUpList;


    public static TestCaseContext get() {
        return THREAD_LOCAL.get();
    }

    public static void init() {

        THREAD_LOCAL.set(new TestCaseContext());

    }

    public Folder getClickUpFolder() {
        return ClickUpFolder;
    }

    public void setclickUpFolder(final Folder ClickUpFolder) {
        this.ClickUpFolder = ClickUpFolder;
    }

    public ClickUpList getClickUpList() {
        return clickUpList;
    }

    public void setClickUpList(final ClickUpList clickUpList) {
        this.clickUpList = clickUpList;
    }
}