package mbi.session;

import mbi.db.Database;
import mbi.model.Player;

public class Session {
    private Player loggedInPlayer;
    private Database database;
    public boolean isAdmin(){
       return loggedInPlayer.isAdmin();
    } 

    public Database getDatabase(){
        System.out.println("getDatabase");
        return database;
    }
    public Session() {
        loggedInPlayer = new Player();
        loggedInPlayer.setAdmin(false);
        loggedInPlayer.setPlayerName("Doug Plebe");
        loggedInPlayer.setPlayerEmail("baronvonreed@gmail.com");
        //TODO: login mechanism
        database = new Database();
    }

    public Session(boolean test) {
        if (test) {
            loggedInPlayer = new Player();
            loggedInPlayer.setAdmin(true);
            loggedInPlayer.setPlayerName("Doug");
            loggedInPlayer.setPlayerEmail("doug@bstonline.org");
            database = new Database();
        }
    }
}