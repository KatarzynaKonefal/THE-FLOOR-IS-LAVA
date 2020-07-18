package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

import java.util.List;

public interface IModelManger {

    LavaPlayer getPlayer();
    List<SafeField> getSafeFields();

    Exit getExitField();

    Texture getBackground();

    Fire getFire();

}
