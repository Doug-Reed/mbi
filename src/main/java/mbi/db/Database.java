package mbi.db;

import io.jsondb.JsonDBTemplate;
import mbi.model.Event;

public class Database {
    private JsonDBTemplate jsonDBTemplate;

    public Database(){
        this.jsonDBTemplate = getJsonDBTemplate();
    }
    //  http://jsondb.io/

    public String addEvent(Event event){
        try{
           jsonDBTemplate.insert(event);
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



    public void makeTable() {
        JsonDBTemplate db= getJsonDBTemplate();
        db.createCollection(Event.class);

        Event event = new Event();
        event.setEventName("test event");
        db.insert(event);
    }
}