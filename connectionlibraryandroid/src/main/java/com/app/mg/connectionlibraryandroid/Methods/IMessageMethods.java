package com.app.mg.connectionlibraryandroid.Methods;

import android.content.Context;

import com.app.mg.connectionlibraryandroid.Entities.MessageBody;
import com.app.mg.connectionlibraryandroid.Entities.WebSocketClientImplementation;

import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;


public interface IMessageMethods<T,V extends WebSocketClient,W extends WebSocket> {
    MessageBody ConstructMessageBody(String myIpAddress, T body);

    String ConstructMessageBodyJSON(String myIpAddress, T body);

    void SendMessageBody(MessageBody messageBody,  V webSocketClient);

    void SendMessageBody(MessageBody messageBody,  W webSocket);

    void SendMessageBody(T body,  V webSocketClient,String myIpAddress);

    void SendMessageBody(T body,  W webSocketServer,String myIpAddress);

    MessageBody<T> ReceiveMessageBody(String message);
}
