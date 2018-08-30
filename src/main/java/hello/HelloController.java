package hello;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import mbi.model.Event;
import java.io.File;
import java.util.List;
import mbi.db.Database;
import mbi.db.ObjectTypes;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

import org.json.simple.JSONArray;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    
    @RequestMapping("/{playerName")
    public String responseByName(){
        return null;
    }

    @GetMapping("/eventAdmin")
    public String eventForm(Model model) {
        model.addAttribute("event", new Event());
        return "event";
    }

    @PostMapping("/eventAdmin")
    public String eventSubmit(@ModelAttribute Event event) {
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
       
       return "index";
    }
    
}
