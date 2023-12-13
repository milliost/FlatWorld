package com.example.servingwebcontent.model.games.flatWorld;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {
    private MessageType type;
    private String content;
    private String sender;
    public enum MessageType {
        CHAT,
        JOIN,
        SIT,
        LEAVE,
        HISTORY,
        ENDTURN,
        PLAYCARD,
        DISTRICKT
    }

}
