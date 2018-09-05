package mbi.db;

import io.jsondb.JsonDBTemplate;
import mbi.model.Event;
import mbi.model.*;

import java.util.List;

public class Database {
    private JsonDBTemplate jsonDBTemplate;

    public Database() {
        this.jsonDBTemplate = getJsonDBTemplate();
    }
    //  http://jsondb.io/

    //list players
    //list events
    //list responses

    //fetch future events
    //fetch response by player
    //archive responses
    
    public List<Response> allResponses() {
        JsonDBTemplate db = getJsonDBTemplate();
        List<Response> responses = db.find("/", Response.class);
        return responses;
    }
    public List<Event> allEvents(){
        JsonDBTemplate db = getJsonDBTemplate();
        List<Event> events = db.find("/", Event.class);
        System.out.println("In the event find Events size = " + events.size());
        return events;
    }
 
    public Event getEventByID(String id){
        List<Event> events = allEvents();
        for (Event e:events) {
            if(id.trim().equalsIgnoreCase(id.trim())){
                return e;
            }
        }
        return null;
    }
    public Player getPlayerByName(String name){
        JsonDBTemplate db = getJsonDBTemplate();
        List<Player> players = db.find("/", Player.class);
        for(Player p:players){
            if(p.getPlayerName().equalsIgnoreCase(name)){
                return p;
            }
        }
        return null;
    }


    public String upsertEvent(Event event) {
        JsonDBTemplate db = getJsonDBTemplate();
        try{
            db.createCollection(Event.class);
        } catch (Exception e) {
            System.out.println("Exists");
        }
        try {
            
            db.upsert(event);
        } catch (Exception e) {
            System.out.println("More FUBAR");
            System.out.println(e.getMessage());
            return "FUBAR";
        }
        System.out.println("winning");
        return "OK";
    }

    public String upsertPlayer(Player player) {
        JsonDBTemplate db = getJsonDBTemplate();
        
        try{
            db.createCollection(Player.class);
        } catch (Exception e) {
            System.out.println("Exists");
        }
       
        try {
            jsonDBTemplate.upsert(player);
        } catch (Exception e) {
            return "FUBAR";
        }

        return "OK";
    }

    public String upsertArchive(Archive archive) {
        try {
            jsonDBTemplate.upsert(archive);
        } catch (Exception e) {
            return "FUBAR";
        }

        return "OK";
    }

    public String insertResponse(Response response) {
        JsonDBTemplate db = getJsonDBTemplate();
        try{
            db.createCollection(Response.class);
        } catch (Exception e) {
            System.out.println("Exists");
        }
       
        db.insert(response);
        return "OK";
    }
    public String upsertResponse(Response response) {
         JsonDBTemplate db = getJsonDBTemplate();
         try{
            db.createCollection(Response.class);
        } catch (Exception e) {
            System.out.println("Exists");
        }
        try {
            if(response.getResponseID().equalsIgnoreCase("Not initialized")){
                return "Not initialized";
            }
            jsonDBTemplate.upsert(response);
        } catch (Exception e) {
            return "FUBAR";
        }

        return "OK";
    }

    public JsonDBTemplate getJsonDBTemplate() {
        //Actual location on disk for database files, process should have read-write permissions to this folder
        String dbFilesLocation = "./data";

        //Java package name where POJO's are present
        String baseScanPackage = "mbi.model";

        //Optionally a Cipher object if you need Encryption
        //ICipher cipher = new DefaultAESCBCCipher("1r8+24pibarAWgS85/Heeg==");

        JsonDBTemplate jsonDBTemplate = new JsonDBTemplate(dbFilesLocation, baseScanPackage, null);
        return jsonDBTemplate;
    }

    public void initializeDatabase() {
        JsonDBTemplate db = getJsonDBTemplate();

        try {
            db.createCollection(Event.class);
        } catch (Exception e) {

        }

        try {
            db.createCollection(Player.class);
        } catch (Exception e) {

        }

        try {
            db.createCollection(Response.class);
        } catch (Exception e) {

        }
        try {
            db.createCollection(Archive.class);
        } catch (Exception e) {

        }
    }

    public void makeTable() {
        // JsonDBTemplate db= getJsonDBTemplate();
        //  db.createCollection(Event.class);

        Event event = new Event();
        event.setEventName("test event 2");
        jsonDBTemplate.upsert(event);
    }
}