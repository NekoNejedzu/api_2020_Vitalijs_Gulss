package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true) //šī anotācija ir vajadzīga,
public class Board {
    @JsonProperty("id") //šī anotācija pasaka deserializācijas mehānismam, lai no iegūtā JSON (ko atsūta Trello), mācētu izgūt tieši ID vērtību un to ielikt parametrā, kas ir rindiņu zemāk, ar nosaukumu ID
    private String id; //šajā laukā tiks glabāta tā ^ vērtība, kas izgūta no atsūtā JSON faila
    //lai mēs zinātu, kas par tipu jālieto vērtībā, ir jāskatās gala servisa dokumentācija. Piemēram šajā gadījumā šis ir String tips, bet citos gadījumos tas var būt Integer, vai DataTime, vai arī cits JSONObject

    @JsonProperty("name")
    private String name;
//kad tik tālu ir, tad sakiet
//ieklikšņiniet brīvā vietā
    //ar diviem pirkstiem click, laia tvēros menu

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}