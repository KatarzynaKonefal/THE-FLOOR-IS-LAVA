package com.mygdx.game.model;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;

public class Fire extends GameObject {

	public Fire (Texture texture, Position position, Music musicFire) {
		super(texture, position);
		musicFire.play();
	}

	public Fire (Texture texture, Position position) {
		super(texture, position);
	}
}
