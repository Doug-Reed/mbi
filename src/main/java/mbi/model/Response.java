package mbi.model;
import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;
@Document(collection = "responses", schemaVersion= "1.0")
public class Response {
    @Id
    private String responseID;
    private Player player;
    private Event event;
    private String response;
    private String comment;

   public Response(Event event, Player player) {
       setPlayer(player);
       setEvent(event);
       this.responseID = player.getPlayerName() + "~" + event.getEventName();
   }
   public String getResponseID(){
      return this.responseID;
   }
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