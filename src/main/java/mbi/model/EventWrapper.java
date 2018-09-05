package mbi.model;

import java.util.List;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

import mbi.model.*;
import mbi.db.*;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.time.LocalDate;
import java.text.Collator;
import java.text.RuleBasedCollator;

import java.time.format.DateTimeFormatter;

public class EventWrapper {
    private List<Event> allEvents;
    private Event newEvent;
    private String[] enteredEvents;
    private List<Event> futureEvents;

    public EventWrapper(){
        System.out.println(futureEventsReference());
    }

    public String compareString() {
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
        String formattedString = yesterday.format(formatter);
        return formattedString;
    }

    public Event getNewEvent() {
        newEvent = new Event();
        return newEvent;
    }

    public String[] futureEventsReference(){
        String[] retVal = {""};
        List<Event> theFuture = futureEvents();
        System.out.println(theFuture.size());
        for(Event e: theFuture){
            System.out.println("in loop " + e.getEventId());
           String ref = e.getEventId();
           if(!StringUtils.isBlank(e.getEventComments())){
               ref = ref + " " + e.getEventComments().trim();
           }

           retVal = add(retVal,ref);
        }
        Arrays.sort( retVal);
        enteredEvents = retVal;
        return retVal;
    }

   private String[] add(String[] arr, String... elements){
        String[] tempArr = new String[arr.length+elements.length];
        System.arraycopy(arr, 0, tempArr, 0, arr.length);
        
        for(int i=0; i < elements.length; i++)
            tempArr[arr.length+i] = elements[i];
        return tempArr;
        
    }

    public List<Event> futureEvents() {
        Database db = new Database();
        allEvents = db.allEvents();
        List<Event> futures = new ArrayList<Event>();
       try{
        Collator collator = new RuleBasedCollator("< a < b < c");
        String yesterday = compareString();
        for (Event event : allEvents) {
            System.out.println("Compare " + event.getEventDate() + " with " + yesterday);
            if (collator.compare(event.getEventDate(), yesterday) > 0) {
                System.out.println("Added");
                futures.add(event);
            }

        }
       }catch (Exception e) {
           System.out.println(e.getMessage());
       }

       this.futureEvents = futures;
       return futures;
    }

}
