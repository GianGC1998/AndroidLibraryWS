package com.app.mg.connectionlibraryandroid.Methods;

import android.content.Context;

import com.app.mg.connectionlibraryandroid.Entities.MessageBody;
import com.app.mg.connectionlibraryandroid.Entities.WebSocketClientImplementation;

import org.java_websocket.client.WebSocketClient;


public interface IMessageMethods<T> {
    MessageBody ConstructMessageBody(Context context, T body);

    void SendMessageBody(MessageBody messageBody,  WebSocketClient webSocketClient);

    void SendMessageBody(T body,  WebSocketClient webSocketClient,Context context);

    MessageBody<T> ReceiveMessageBody(String message);
}
