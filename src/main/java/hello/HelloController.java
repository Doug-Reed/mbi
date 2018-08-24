package hello;

import org.springframework.web.bind.annotation.RestController;

import mbi.dao.JsonDao;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String index() {
        JsonDao jsonDao = new JsonDao();
        jsonDao.getAllPlayers();
        return "Greetings from Spring Boot!";
        
    }
    
}
