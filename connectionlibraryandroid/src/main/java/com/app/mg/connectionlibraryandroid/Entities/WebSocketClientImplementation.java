package com.app.mg.connectionlibraryandroid.Entities;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class WebSocketClientImplementation extends WebSocketClient {
    private final List<String> possibleServers;
    private String ipToFind;

    public WebSocketClientImplementation(URI serverUri,List<String> possibleServers,String ipToFind ) {
        super(serverUri);
        this.possibleServers = possibleServers;
        this.ipToFind = ipToFind;
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        possibleServers.add(ipToFind);
        synchronized(possibleServers) {
            possibleServers.notify();
        }
        this.close();
    }

    @Override
    public void onMessage(String message) {

    }

    @Override
    public void onClose(int code, String reason, boolean remote) {

    }

    @Override
    public void onError(Exception ex) {
        synchronized(possibleServers) {
            possibleServers.notify();
        }
    }
}
