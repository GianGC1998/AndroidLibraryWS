package com.app.mg.connectionlibraryandroid.Methods;

import com.app.mg.connectionlibraryandroid.Entities.MessageBody;

import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;

public interface IServerMessageMethods<T,W extends WebSocket> {
    MessageBody ConstructMessageBody(String myIpAddress, T body);

    String ConstructMessageBodyJSON(String myIpAddress, T body);

    void SendMessageBody(MessageBody messageBody,  W webSocket);

    void SendMessageBody(T body,  W webSocketServer,String myIpAddress);

    MessageBody<T> ReceiveMessageBody(String message);
}
