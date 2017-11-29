package com.example.ashutosh.EventBus;

/**
 * Created by ashutosh on 18/2/16.
 */
public class HelloWorldEvent {
    private final String message;

    public HelloWorldEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}