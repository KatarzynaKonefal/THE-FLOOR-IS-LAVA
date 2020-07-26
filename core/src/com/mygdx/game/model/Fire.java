package com.mygdx.game.model;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;

public class Fire extends GameObject {

	private Music music;
	private boolean musicPlay = true;

	public Fire (Texture texture, Position position, Music musicFire) {
		super(texture, position);
		music = musicFire;
		if (musicPlay = true) {
			musicFire.play();
		}
	}

	public void turnOffMusic() {
		musicPlay = false;
//		if(musicPlay = false){
//		music.pause();
//	}

	}



}
