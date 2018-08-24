package mbi.model;

import java.util.Date;

public class Event {

    private Date eventDate;
    private String eventDateFormatted;
    private String eventName;

    public Date getEventDate() {
        return this.eventDate;
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
        this.eventDateFormatted = eventDateFormatted;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

}