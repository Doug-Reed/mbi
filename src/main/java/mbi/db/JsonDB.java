package mbi.db;

import java.util.ArrayList;
import mbi.model.Player;
import mbi.model.*;

import mbi.dao.IMbiDao;
import java.io.FileWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;

public class JsonDB  {

    private JSONArray getFileByName (String fileName) {
         //JSON parser object to parse read file
         JSONParser jsonParser = new JSONParser();
        File file = null;
        try{
        file = new ClassPathResource(fileName + ".json").getFile();
        }
        catch(Exception e) {
            System.out.println("IO");
        }
         
        try (FileReader reader = new FileReader(file)){
            Object obj = jsonParser.parse(reader);
            //Read JSON file
            JSONArray thingList = (JSONArray) obj;
            return thingList;
        }catch(Exception e) {
            System.out.println("parsing");
        }

        return null;
    }

    public JSONArray getAllEvents(){
        JSONArray events = getFileByName("events");
        System.out.println(events);
        return events;
    }
    public JSONArray getAllResponses() {
        JSONArray responses = getFileByName("responses");
        System.out.println(responses);
        return responses;
    }

    public JSONArray getAllPlayers() {
        JSONArray players = getFileByName("players");
        System.out.println(players);
        return players;
  
    }

}