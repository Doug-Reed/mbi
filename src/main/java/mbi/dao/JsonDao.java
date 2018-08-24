package mbi.dao;

import java.util.ArrayList;
import mbi.model.Player;
import mbi.model.*;

import mbi.dao.IMbiDao;

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



    public ArrayList<Event> getAllEvents(){
        return null;
    }
    public ArrayList<Response> getAllResponses() {
        return null;
    }

    public ArrayList<Player> getAllPlayers() {
        JSONArray players = getFileByName("players");
        System.out.println(players);
        return null;
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