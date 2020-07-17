package com.mygdx.game.model;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.controller.Assets;

public class LavaPlayer extends Rectangle{
	
	private Sound sound;
	Texture imagePlayer = new Texture("sensej.png");
	public boolean canJump = true;
	
	
	public float jumpVelocity;
	
	public LavaPlayer(Texture imagePlayer, Assets assets) {
		this.imagePlayer = imagePlayer;
		this.height = imagePlayer.getHeight();
		this.width = imagePlayer.getWidth();
		//sound = assets.manager.get("jump.wav", Sound.class);
		
	}
	
	public void draw(SpriteBatch spriteBatch) {
		spriteBatch.draw(imagePlayer, x, y, imagePlayer.getWidth(), imagePlayer.getHeight());
	}
	
	public void jump() {
		if(canJump && jumpVelocity >= -100 ) {
			jumpVelocity += 800;
			canJump = false;
			sound.play();
		}
	}

}
