package domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true) //šī anotācija ir vajadzīga, lai nebūtu jādefinā visas atgriestās vērtības
public class ClickUpList {
    @JsonProperty("id") //šī anotācija pasaka deserializācijas mehānismam, lai no iegūtā JSON (ko atsūta Trello), mācētu izgūt tieši ID vērtību un to ielikt parametrā, kas ir rindiņu zemāk, ar nosaukumu ID
    private String id;

    @JsonProperty("name")
    private String name;

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