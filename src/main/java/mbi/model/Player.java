package mbi.model;

public class Player {
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