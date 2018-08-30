package mbi.model;
import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;
@Document(collection = "players", schemaVersion= "1.0")
public class Player {
    @Id
    private String playerName;
    private String playerEmail;

    public String getPlayerName() {
        return this.playerName;
    }

    public String getPlayerEmail() {
        return this.playerEmail;
    }

    public void setPlayerName(String name) {
        this.playerName = name;
    }

    public void setPlayerEmail(String email) {
        this.playerEmail = email;
    }
}