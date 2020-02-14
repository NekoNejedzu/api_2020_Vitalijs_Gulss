package helpers;

import clients.ClickUpClient;
import domain.Folder;

public class BoardHelper {

    private static final ClickUpClient CLICK_UP_CLIENT = new ClickUpClient();

    public static Folder getClickUpFolder(String folder_id) {
        return ClickUpClient.fetchClickUpFolder(folder_id)
            .extract()
            .response()
            .as(Folder.class);
    }


}
