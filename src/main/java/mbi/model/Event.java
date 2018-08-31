package mbi.model; 

import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;

@Document(collection = "events", schemaVersion= "1.0")
public class Event {

    @Id
    private String eventId;
    private String eventName;
    private String eventDate;
    private String eventComments;
    
   public String getEventComments(){
     return this.eventComments;
   }

   public void setEventComments(String comments) {
     this.eventComments = comments;
   }
    public String getEventDate() {
        return this.eventDate;
    }
    public String getEventId() {
        return this.eventDate + " " + this.eventName;
    }

    public void setEventId(String setter) {
      eventId = this.eventDate + " " + this.eventName;
    }
    public String getEventName() {
        return this.eventName;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

   

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

/*
  public static Comparator<Event> dateComparator = new Comparator<Event>() {         
    @Override         
    public int compare(Event jc1, Event jc2) {             
      return (jc2.getEventDate().before(jc1.getEventDate()) ) ? -1 :                     
              (jc2.getEventDate() == jc1.getEventDate() ? 0 : 1);           
    }     
  }; 
*/
}