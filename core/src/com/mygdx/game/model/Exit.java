package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.model.Assets;

public class Exit extends GameObject {

	private Texture imageField;

	public Exit(Texture imageField, Position position) {
		super(imageField, position);
	}
}
