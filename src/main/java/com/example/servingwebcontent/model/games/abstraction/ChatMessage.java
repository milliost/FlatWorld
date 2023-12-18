package com.example.servingwebcontent.model.games.abstraction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ChatMessage {
    private MessageType type;
    private String content;
    private String sender;
    public ChatMessage(){

    }
    public enum MessageType {
        CHAT,
        JOIN,
        SIT,
        START,
        LEAVE,
        HISTORY,
        ENDTURN,
        PLAYCARD,
        DISTRICKT
    }

}
