package com.app.mg.connectionlibraryandroid.Implementations;

import android.content.Context;

import com.app.mg.connectionlibraryandroid.Entities.MessageBody;
import com.google.gson.Gson;
import com.app.mg.connectionlibraryandroid.Methods.IMessageMethods;

import org.java_websocket.client.WebSocketClient;

public class MessageMethods<T> implements IMessageMethods<T> {
    @Override
    public MessageBody ConstructMessageBody(String myIpAddress, T body) {
        ConnectMethods connectMethods = new ConnectMethods();
        return new MessageBody<T>()
                .setBody(body)
                .setSender(myIpAddress);
    }

    @Override
    public void SendMessageBody(MessageBody messageBody, WebSocketClient webSocketClient) {
        Gson gson = new Gson();
        webSocketClient.send(gson.toJson(messageBody));
    }

    @Override
    public void SendMessageBody(T body, WebSocketClient webSocketClient,String myIpAddress) {
        MessageBody<T> messageBody = ConstructMessageBody(myIpAddress,body);
        SendMessageBody(messageBody,webSocketClient);
    }

    @Override
    public MessageBody<T> ReceiveMessageBody(String message) {
        Gson gson = new Gson();
        return gson.fromJson(message,MessageBody.class);
    }
}
