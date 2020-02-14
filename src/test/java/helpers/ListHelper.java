package helpers;

import java.util.List;

import clients.ClickUpClient;
import domain.ClickUpList;

public class ListHelper {

    private static final ClickUpClient CLICK_UP_CLIENT = new ClickUpClient();


    public static List<ClickUpList> getListFromFolder(String folder_id) {

        return CLICK_UP_CLIENT.fetchListsFolder(folder_id).extract().body().jsonPath().getList("$.", ClickUpList.class);
    }


}
