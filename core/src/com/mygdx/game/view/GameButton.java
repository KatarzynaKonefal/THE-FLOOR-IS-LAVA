package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class GameButton {
    private ImageButton imageButton;

    public GameButton(String pathToButtonImage, float x, float y, int width, int height) {
        Texture buttonTexture = new Texture(Gdx.files.internal(pathToButtonImage));
        TextureRegion buttonTextureRegion = new TextureRegion(buttonTexture);
        TextureRegionDrawable buttonTexRegionDrawable = new TextureRegionDrawable(buttonTextureRegion);
        imageButton = new ImageButton(buttonTexRegionDrawable);
        imageButton.setX(x);
        imageButton.setY(y);
        imageButton.setWidth(width);
        imageButton.setHeight(height);
//        imageButton.setDebug(true);
    }

    public void addListener(EventListener listener) {
        imageButton.addListener(listener);
    }

    public Actor getButton() {
        return imageButton;
    }
}
