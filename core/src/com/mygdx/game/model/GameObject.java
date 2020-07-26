package com.mygdx.game.model;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class GameObject extends Rectangle {
    protected Texture texture;
    protected boolean musicIsOn;

    GameObject(Texture texture, Position startPosition) {
        this.texture = texture;
        this.x = startPosition.x;
        this.y = startPosition.y;
        this.height = texture.getHeight();
        this.width = texture.getWidth();
        musicIsOn = true;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, x, y);
    }

    public void updateTexture(Texture texture) {
        this.texture = texture;
    }

    public void updateMusic(boolean soundIsOn) {
        musicIsOn = soundIsOn;
    }
}
