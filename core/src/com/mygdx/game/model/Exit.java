package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.controller.Assets;

public class Exit extends Rectangle{

	Texture  imageExit = new Texture("door.png");
	
	
	public Exit (Texture imageExit, Assets assets) {
		this.imageExit = imageExit;
		this.height = imageExit.getHeight();
		this.width = imageExit.getWidth();
	}
	
	public void draw(SpriteBatch spriteBatch) {
		spriteBatch.draw(imageExit, 1920, 1080,imageExit.getWidth(), imageExit.getHeight());
	}

}
