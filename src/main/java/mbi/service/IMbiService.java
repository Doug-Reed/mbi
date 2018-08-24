package mbi.service;

import java.util.ArrayList;

import mbi.model.Response;

public interface IMbiService {
    public ArrayList<Response> responsesByPlayer(String playerName);

    public ArrayList<Response> responsesByEvent(String eventName);


}