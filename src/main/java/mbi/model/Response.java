package mbi.model;
import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;
@Document(collection = "responses", schemaVersion= "1.0")
public class Response {
    
    @Id
    private String responseID;

    private String response;
    private String comment;

   public void setID(Event e, Player p){
        this.responseID = p.getPlayerName() + "~" + e.getEventId();
   }
 
   public void setResponseID(String responseID) {
       this.responseID = responseID;
   }

 
  public Response(String responseID) {
      setResponseID(responseID);
  }
   public Response(){
   }
   public Response(Event event, Player player) {

       this.responseID = player.getPlayerName() + "~" + event.getEventId();
       System.out.println("ResponseId = " + responseID);
   }
   public String getResponseID(){
       System.out.println(this.toString() + " getting " + responseID);
      return responseID;
   }

    public String getResponse() {
        return this.response;
    }

    public String getComment() {
        return this.comment;
    }

    public void setResponse(String response) {
        this.response = response;
    } 

    public void setComment(String comment) {
        this.comment = comment;
    } 
    @Override
    public String toString(){
        return this.responseID + " " + this.response + " " + this.comment;
    }
}