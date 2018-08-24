package mbi.dao;

import java.util.ArrayList;

import mbi.model.Event;
import mbi.model.Player;
import mbi.model.Response;

public interface IMbiDao {
    public ArrayList<Player> getAllPlayers();
    public ArrayList<Event> getAllEvents();
    public ArrayList<Response> getAllResponses();
}