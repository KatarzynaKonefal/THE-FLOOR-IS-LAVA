package com.mygdx.game.view;

import com.badlogic.gdx.Input;
import com.mygdx.game.model.IModelManager;


public class PlayerNameInputListener implements Input.TextInputListener {

    public String playerName;
    IModelManager modelManager;

    public PlayerNameInputListener(IModelManager modelManager) {
        super();
        this.modelManager = modelManager;
    }

    @Override
    public void input (String text) {
        this.playerName = text;
        modelManager.getPoints().setPlayerName(this.playerName);
        modelManager.addNewScore();
    }

    @Override
    public void canceled () {
    }
}