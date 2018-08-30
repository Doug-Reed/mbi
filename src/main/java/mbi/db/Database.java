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

    public List<Event> allEvents(){
        List<Event> events = jsonDBTemplate.find("/*", Event.class);
        return events;
    }

    public String upsertEvent(Event event) {
        try {
            jsonDBTemplate.upsert(event);
        } catch (Exception e) {
            return "FUBAR";
        }

        return "OK";
    }

    public String upsertPlayer(Player player) {
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

    public String upsertResponse(Response response) {
        try {
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