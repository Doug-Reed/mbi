package mbi.model;

import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import io.jsondb.annotation.Document;
import io.jsondb.annotation.Id;

@Document(collection = "events", schemaVersion= "1.0")
public class Event {

    
    
    private Date eventDate;
    private String eventDateFormatted;
    @Id
    private String eventName;

    public Date getEventDate() {
        return this.eventDate;
    }

    private void parseDate(String dateString) {

        DateFormat format = new SimpleDateFormat("yyyy mm dd kk:mm", Locale.ENGLISH);
        try {
            Date date = format.parse(dateString);
            setEventDate(date);
        } catch (Exception e) {

        }
        System.out.println(dateString);
    }

    public String getEventDateFormatted() {
        return this.eventDateFormatted;
    }

    public String getEventName() {
        return this.eventName;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public void setEventDateFormatted(String eventDateFormatted) {
        parseDate(eventDateFormatted);
        this.eventDateFormatted = eventDateFormatted;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

}