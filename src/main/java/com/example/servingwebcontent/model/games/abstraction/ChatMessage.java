package com.example.servingwebcontent.model.games.abstraction;

import com.example.servingwebcontent.model.games.Instruction;
import com.example.servingwebcontent.model.games.flatWorld.cards.ActionEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {
    private MessageType type;
    private String content;
    private String sender;
    private Instruction instruction;
    public ChatMessage(){

    }
    public enum MessageType {
        CHAT,
        JOIN,
        SIT,
        START,
        LEAVE,
        INSTRUCTION
    }

}
