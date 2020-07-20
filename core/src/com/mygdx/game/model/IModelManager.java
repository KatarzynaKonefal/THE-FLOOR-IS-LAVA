package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;

import java.util.List;

public interface IModelManager {

    LavaPlayer getPlayer();

    List<SafeField> getSafeFields();

    Exit getExitField();

    Texture getBackground();

    Fire getFire();

    void init(Level level);

    Winner getWinner();


    Points getPoints();
}
