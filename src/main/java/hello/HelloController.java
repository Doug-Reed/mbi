package hello;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import mbi.model.Event;
import java.io.File;
import mbi.dao.JsonDao;
import mbi.db.DBUtils;
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

    @RequestMapping("/TestWrite")
    public String testWrite(){
        Event event = new Event();
        event.setEventDateFormatted("2018-12-31 11:59");
        event.setEventName("A great event");

        Event event2 = new Event();
        event2.setEventName("Overwrite");
        event2.setEventDateFormatted("2019-01-01 12:01");
        ArrayList<Event> events = new ArrayList<Event>();
        events.add(event);
        events.add(event2);
        ObjectMapper objectMapper = new ObjectMapper();
       try{
        File file = DBUtils.getFile(ObjectTypes.EVENT);
        objectMapper.writeValue(file,events);
       }catch(Exception e){
           System.out.println("uff");
       }

       return "win";
}


    @RequestMapping("/")
    public String index() {
        JsonDao jsonDao = new JsonDao();
       JSONArray ja= jsonDao.getAllPlayers();
       jsonDao.getAllEvents();
      jsonDao.getAllResponses();

       return ja.toString();
    }
    
}
