package com.app.mg.connectionlibraryandroid.Methods;

import com.app.mg.connectionlibraryandroid.Entities.MessageBody;
import org.java_websocket.client.WebSocketClient;

public interface IClientMessageMethods<T,V extends WebSocketClient> {
    MessageBody ConstructMessageBody(String myIpAddress, T body);

    String ConstructMessageBodyJSON(String myIpAddress, T body);

    void SendMessageBody(MessageBody messageBody,  V webSocketClient);

    void SendMessageBody(T body,  V webSocketClient,String myIpAddress);

    MessageBody<T> ReceiveMessageBody(String message);
}


