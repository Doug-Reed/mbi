package mbi.dao;

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

public class JsonDao implements IMbiDao {

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

    public void writeFile (JSONObject jsonObject, String fileName) {
        File file = null;
        try{
         file = new ClassPathResource(fileName + ".json").getFile();

        }catch (Exception e) {

        }

        try {
    FileWriter f2 = new FileWriter(file, true);
    f2.write(jsonObject.toJSONString());
    f2.close();
} catch (IOException e) {
    e.printStackTrace();
}           
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
    /*

        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        File file = null;
        try{
        file = new ClassPathResource("players.json").getFile();
        }
        catch(Exception e) {
            System.out.println("IO");
        }
         
        try (FileReader reader = new FileReader(file)){
            //Read JSON file
            Object obj = jsonParser.parse(reader);
 
            JSONArray playerList = (JSONArray) obj;
            System.out.println(playerList);
             
            //Iterate over employee array
    //       playerList.forEach( monk -> parsePlayer( (JSONArray) monk ) );
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
               */
    }

    private static void parsePlayer(JSONObject player)
    {
        String playerName = (String) player.get("playerName");   
        System.out.println(playerName);
         
        String playerEmail = (String) player.get("playerEmail"); 
        System.out.println(playerEmail);
    }



}