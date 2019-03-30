package com.app.mg.connectionlibraryandroid.Methods;

import android.content.Context;

import com.app.mg.connectionlibraryandroid.Entities.MessageBody;
import com.app.mg.connectionlibraryandroid.Entities.WebSocketClientImplementation;

import org.java_websocket.client.WebSocketClient;


public interface IMessageMethods<T,V extends WebSocketClient> {
    MessageBody ConstructMessageBody(String myIpAddress, T body);

    void SendMessageBody(MessageBody messageBody,  V webSocketClient);

    void SendMessageBody(T body,  V webSocketClient,String myIpAddress);

    MessageBody<T> ReceiveMessageBody(String message);
}
