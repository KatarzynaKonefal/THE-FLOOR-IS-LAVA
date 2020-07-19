package com.mygdx.game.model;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public class LavaPlayer extends GameObject {
	
	private Sound sound;
	public boolean canJump = true;
	
	public float jumpVelocity;

	public float verticalStartPosition;

	public boolean isAlive;

	private double rightSideCoefficient = 0.60;
	private double leftSideCoefficient = 0.30;
	
	public LavaPlayer(Texture imagePlayer, Sound jumpSound, Position startPosition) {
		super(imagePlayer, startPosition);
		sound = jumpSound;
		verticalStartPosition = startPosition.y;
		isAlive = true;
	}
	
	public void jump() {
		if(canJump && jumpVelocity >= -100 ) {
			jumpVelocity += 800;
			canJump = false;
			sound.play();
		}
	}

	@Override
	public boolean overlaps(Rectangle r) {
		return x + leftSideCoefficient * width < r.x + r.width && x + width - rightSideCoefficient * width > r.x && y < r.y + r.height/2 && y + height > r.y;
	}


}
