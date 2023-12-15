package com.example.servingwebcontent.model.games.flatWorld.comandHandler;

import com.example.servingwebcontent.model.games.abstraction.ChatMessage;
import com.example.servingwebcontent.model.games.flatWorld.FlatWorldGame;
import com.example.servingwebcontent.model.games.flatWorld.flatWorldService.CanPlayerDoAction;


public class TextCommandHandler {
    private FlatWorldGame flatWorldGame;
    /**
     * думаю, что класс определяющий может ли игрок ходить
     * стоит пока что вынести из самой игры в класс обработчик команд. В принципе думаю что это верно
     */
    private CanPlayerDoAction canPlayerDoAction;
    private CardCommandHandler CCH = new CardCommandHandler();
    private String sender;
    private String content;

    public TextCommandHandler(FlatWorldGame flatWorldGame) {
        this.flatWorldGame = flatWorldGame;
        this.canPlayerDoAction = flatWorldGame.getCanPlayerDoAction();
    }

    public void acceptCommand(ChatMessage chatMessage) {
        sender = chatMessage.getSender();
        content = chatMessage.getContent();
        if (canPlayerDoAction.itIsMyTurn(sender)) {

            switch (chatMessage.getType()) {
                case ENDTURN -> flatWorldGame.nextTurn(sender);
                case PLAYCARD -> flatWorldGame.playCard(sender, Integer.parseInt(content));
                case DISTRICKT -> flatWorldGame.getCardCommandHandler();

            }
        }
    }
}
