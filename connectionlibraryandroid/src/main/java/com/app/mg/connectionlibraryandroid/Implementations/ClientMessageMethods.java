package com.app.mg.connectionlibraryandroid.Implementations;

import com.app.mg.connectionlibraryandroid.Entities.MessageBody;
import com.app.mg.connectionlibraryandroid.Methods.IClientMessageMethods;
import com.google.gson.Gson;

import org.java_websocket.client.WebSocketClient;

public class ClientMessageMethods<T,V extends WebSocketClient> implements IClientMessageMethods<T,V> {
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
    public void SendMessageBody(MessageBody messageBody, V webSocketClient) {
        Gson gson = new Gson();
        webSocketClient.send(gson.toJson(messageBody));
    }

    @Override
    public void SendMessageBody(T body, V webSocketClient,String myIpAddress) {
        MessageBody<T> messageBody = ConstructMessageBody(myIpAddress,body);
        SendMessageBody(messageBody,webSocketClient);
    }

    @Override
    public MessageBody<T> ReceiveMessageBody(String message) {
        Gson gson = new Gson();
        return gson.fromJson(message,MessageBody.class);
    }
}
