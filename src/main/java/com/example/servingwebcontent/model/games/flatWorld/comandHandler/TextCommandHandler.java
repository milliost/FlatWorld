package com.example.servingwebcontent.model.games.flatWorld.comandHandler;

import com.example.servingwebcontent.model.games.flatWorld.ChatMessage;
import com.example.servingwebcontent.model.games.flatWorld.Game;
import com.example.servingwebcontent.model.games.flatWorld.flatWorldService.Turn;


public class TextCommandHandler {
    private Game game;
    private Turn turn;
    private String sender;
    private String content;
    /**
     * думаю, что класс определяющий может ли игрок ходить
     * стоит пока что вынести из самой игры в класс обработчик команд. В принципе думаю что это верно
     */
    public TextCommandHandler(Game game) {
        this.game = game;
        this.turn = game.getTurn();
    }

    public ChatMessage acceptCommand(ChatMessage chatMessage) {
        sender = chatMessage.getSender();
        content = chatMessage.getContent();
        if (turn.itIsMyTurn(sender)) {

            switch (chatMessage.getType()) {
                case ENDTURN -> game.nextTurn(sender);
                case PLAYCARD -> game.playCard(sender, Integer.parseInt(content));
                case DISTRICKT ->//по идее тут должен быть метод выясняющий куда улетает команда

            }
        }
    }
}
