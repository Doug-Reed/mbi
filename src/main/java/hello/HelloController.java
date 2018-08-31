package hello;


import mbi.model.Event;
import mbi.session.Session;


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
    
    

    @GetMapping("/eventAdmin")
    public String eventForm(Model model) {
        model.addAttribute("event", new Event());
        return "event";
    }

    @PostMapping("/eventAdmin")
    public String eventSubmit(@ModelAttribute Event event) {
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
       return "index";
    }
/*
    private boolean isAdmin(){
        return session.isAdmin();
    }
    */
}
