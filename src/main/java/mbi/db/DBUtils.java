package mbi.db;
import java.io.File;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import mbi.model.*;
public class DBUtils {
    
    public static File getFile(ObjectTypes objectType) {
        String fileName = objectType.getFilename();
        try{
            File file = new ClassPathResource(fileName + "json").getFile();
            return file;
        } catch (Exception e){
            
        }

        return null;
    }

    public ArrayList convertJson(JSONArray jsonArray) {
        ObjectMapper om = new ObjectMapper();
      //  JsonNode node = (JSONArray) jsonArray;
      return null;
    }

  
}