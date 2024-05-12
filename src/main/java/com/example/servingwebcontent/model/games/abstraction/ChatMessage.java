package com.example.servingwebcontent.model.games.abstraction;

import com.example.servingwebcontent.model.games.Instruction;
import com.example.servingwebcontent.model.games.flatWorld.cards.ActionEnum;
import com.example.servingwebcontent.model.games.flatWorld.player.FlatWorldPlayer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessage {
    private MessageType type;
    private String content;
    private String sender;
    private String actionEnum;
    private String instructionPlayer;
    private int parameter;


    public ChatMessage(MessageType type, String content, String sender) {
        this.type = type;
        this.content = content;
        this.sender = sender;
    }


    public enum MessageType {
        CHAT,
        JOIN,
        SIT,
        START,
        LEAVE,
        INSTRUCTION,
        HISTORY
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
            "type=" + type +
            ", content='" + content + '\'' +
            ", sender='" + sender + '\'' +
            ", actionEnum='" + actionEnum + '\'' +
            ", parameter=" + parameter +
            ", InstructionPlayer='" + instructionPlayer + '\'' +
            '}';
    }
}
