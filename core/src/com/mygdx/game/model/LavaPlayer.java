package com.mygdx.game.model;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class LavaPlayer extends GameObject {
	
	private Sound sound;
	public boolean canJump = true;
	
	public float jumpVelocity;

	public float verticalStartPosition;

	int caneWidth = 200;
	int robeWith = 100;
	
	public LavaPlayer(Texture imagePlayer, Sound jumpSound, Position startPosition) {
		super(imagePlayer, startPosition);
		sound = jumpSound;
		verticalStartPosition = startPosition.y;
	}
	
	public void jump() {
		if(canJump && jumpVelocity >= -100 ) {
			jumpVelocity += 800;
			canJump = false;
//			sound.play();
		}
	}

	@Override
	public boolean overlaps(Rectangle r) {
		return x + robeWith < r.x + r.width && x + width - caneWidth > r.x && y < r.y + r.height/2 && y + height > r.y;
	}


}
