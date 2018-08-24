package mbi.model;

public class Response {
    
    private Player player;
    private Event event;
    private String response;
    private String comment;

    public Player getPlayer() {
        return this.player;
    }

    public Event getEvent() {
        return this.event;
    }

    public String getResponse() {
        return this.response;
    }

    public String getComment() {
        return this.comment;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    public void setEvent(Event event) {
        this.event = event;
    }

    public void setResponse(String response) {
        this.response = response;
    } 

    public void setComment(String comment) {
        this.comment = comment;
    } 

}