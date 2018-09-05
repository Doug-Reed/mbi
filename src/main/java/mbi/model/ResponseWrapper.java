package mbi.model;

import mbi.db.Database;
import mbi.model.EventWrapper;

import java.util.ArrayList;
import java.util.List;

public class ResponseWrapper{

    public List<Response> responsesByPlayer(Player p) {
        EventWrapper ew = new EventWrapper();
        List<Response> retVal = new ArrayList<Response>();
        List<Event> events = ew.futureEvents();
        for(Event e: events) {
            Response r = getResponse(p, e);
            if(r==null) {
               r = makeNewResponse(p, e);
            }

            retVal.add(r);
        }
        return retVal;
    }

    private Response makeNewResponse(Player p, Event e) {
         Database db = new Database();
         String responseID = makeID(p, e);
         Response response = new Response(responseID);
         response.setResponse("NONE");
         String result = db.insertResponse(response);
         System.out.println("insert " + responseID + " " + result);
         return response;
         
    }

    public Response getResponse(Player p, Event e) {
        Database db = new Database();
        List<Response> responses = db.allResponses();
        for(Response r: responses) {
              String parts[] = r.getResponseID().split("~");
              if(parts[0].equalsIgnoreCase(p.getPlayerName())
                && parts[1].equalsIgnoreCase(e.getEventId())) {
                    return r;
                }
        }
        return null;
    }

    private String makeID(Player p, Event e){
        return p.getPlayerName() + "~" + e.getEventId();
    
    }
    public void dummy(){
        
        Database db = new Database();

        List<Event> events = db.allEvents();
        Player me = db.getPlayerByName("Doug");

        Event e = events.get(0);
       String responseID =  me.getPlayerName() + "~" + e.getEventId();
        Response response = new Response(responseID);
        System.out.println("ID = " + response.getResponseID());
        response.setResponse("YES");
        response.setComment("Updated");
        System.out.println(response.getResponseID());
        String result = db.upsertResponse(response);
       System.out.println(result); 


    }
}