package mbi.dao;

import org.json.simple.JSONArray;

public interface IMbiDao {
    public JSONArray getAllPlayers();
    JSONArray getAllEvents();
    public JSONArray getAllResponses();
}