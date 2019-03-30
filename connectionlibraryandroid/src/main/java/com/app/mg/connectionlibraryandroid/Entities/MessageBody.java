package com.app.mg.connectionlibraryandroid.Entities;

public class MessageBody<T> {
    private String sender;
    private T body;

    public MessageBody() {
    }

    public MessageBody(String sender, T body) {
        this.sender = sender;
        this.body = body;
    }

    public String getSender() {
        return sender;
    }

    public MessageBody<T> setSender(String sender) {
        this.sender = sender;
        return this;
    }

    public T getBody() {
        return body;
    }

    public MessageBody<T> setBody(T body) {
        this.body = body;
        return this;
    }
}
