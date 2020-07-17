package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.game.controller.Assets;

public class SafeField extends Rectangle{
	
	
	Texture  imageField= new Texture("table.png");
	
	
	public SafeField (Texture imageField, Assets assets) {
	this.imageField = imageField;
		this.height = imageField.getHeight();
		this.width = imageField.getWidth();
	}
	
	public void draw(SpriteBatch spriteBatch) {
		spriteBatch.draw(imageField, x, y, imageField.getWidth(), imageField.getHeight());
	}

}
