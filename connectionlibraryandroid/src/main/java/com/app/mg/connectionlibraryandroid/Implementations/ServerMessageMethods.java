package com.app.mg.connectionlibraryandroid.Implementations;

import com.app.mg.connectionlibraryandroid.Entities.MessageBody;
import com.app.mg.connectionlibraryandroid.Methods.IServerMessageMethods;
import com.google.gson.Gson;

import org.java_websocket.WebSocket;

public class ServerMessageMethods<T,W extends WebSocket> implements IServerMessageMethods<T,W> {
    @Override
    public MessageBody ConstructMessageBody(String myIpAddress, T body) {
        ConnectMethods connectMethods = new ConnectMethods();
        return new MessageBody<T>()
                .setBody(body)
                .setSender(myIpAddress);
    }

    @Override
    public String ConstructMessageBodyJSON(String myIpAddress, T body) {
        Gson gson = new Gson();
        return gson.toJson(ConstructMessageBody(myIpAddress,body));
    }

    @Override
    public void SendMessageBody(MessageBody messageBody, W webSocket) {
        Gson gson = new Gson();
        webSocket.send(gson.toJson(messageBody));
    }

    @Override
    public void SendMessageBody(T body, W webSocketServer, String myIpAddress) {
        MessageBody<T> messageBody = ConstructMessageBody(myIpAddress,body);
        SendMessageBody(messageBody,webSocketServer);
    }

    @Override
    public MessageBody<T> ReceiveMessageBody(String message) {
        Gson gson = new Gson();
        return gson.fromJson(message,MessageBody.class);
    }
}
