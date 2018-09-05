package hello;


import mbi.model.Event;
import mbi.model.EventWrapper;
import mbi.model.Player;
import mbi.session.Session;
import mbi.model.ResponseWrapper;

import java.util.List;


import mbi.db.Database;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    private Session session;
    
    @RequestMapping("/eventList")
    public String listEvents(Model model){
        EventWrapper ew = new EventWrapper();
        String events[] = ew.futureEventsReference();
        model.addAttribute("events", events);
        return "eventList";
    }

    @GetMapping("/addEvent")
    public String eventForm(Model model) {
        Event newEvent = new Event();
        model.addAttribute("event", newEvent);
        EventWrapper ew = new EventWrapper();
        String comingEvents[] = ew.futureEventsReference();
        model.addAttribute("comingEvents", comingEvents);
        return "event";
    }

@RequestMapping("/getPlayer")
    public String dummy() {
       Database db = session.getDatabase();
       Player p = db.getPlayerByName("Doug");
       System.out.println(p.getPlayerEmail());
       return "dummy";
    }

    @PostMapping("/addEvent")
    public String eventSubmit(@ModelAttribute Event event) {
        System.out.println("Does event exist?");
        System.out.println(event.toString());
        System.out.println(event.getEventId());
        session.getDatabase().upsertEvent(event);
        return "result";
    }

    @RequestMapping("/TestEvent")
    public String testDB(){
        Database db = new Database();
        db.makeTable();
        return "win";
    }
    @RequestMapping("/allEvents")
    public String allEvents(Model model){
         Database db = new Database();
        List<Event> events = db.allEvents();
        model.addAttribute(events);
        return "eventList";
        
    }
   
    @RequestMapping("/dangerLink")
    public String makeDatabase(){
        Database db = new Database();
        db.initializeDatabase();
        return "dangerLink";
    }



    @RequestMapping("/")
    public String index() {
       session = new Session(true);
       ResponseWrapper rw = new ResponseWrapper();
       rw.dummy();
       return "index";
    }
/*
    private boolean isAdmin(){
        return session.isAdmin();
    }
    */
}
