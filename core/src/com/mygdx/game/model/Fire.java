package com.mygdx.game.model;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;

public class Fire extends GameObject {

	private Music music;

	public Fire (Texture texture, Position position, Music musicFire) {
		super(texture, position);
		music = musicFire;
		musicFire.play();
	}



}
