package mbi.service;

import java.util.ArrayList;

import mbi.model.Event;
import mbi.model.Response;

public interface IMbiService {

    public void saveEvent(Event event);
    public ArrayList<Response> responsesByPlayer(String playerName);

    public ArrayList<Response> responsesByEvent(String eventName);

    
}