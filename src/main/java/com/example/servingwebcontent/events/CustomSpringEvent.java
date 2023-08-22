package com.example.servingwebcontent.events;

import org.springframework.context.ApplicationEvent;

public class CustomSpringEvent extends ApplicationEvent {
    private int card;

    public CustomSpringEvent(Object source, int card) {
        super(source);
        this.card = card;
    }
    public int getMessage() {
        return card;
    }
}
