package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.List;

public class SafeField extends GameObject {

	public static List<Texture> textures;
	float timeDifference;
	int fieldStage;
	
	public SafeField (List<Texture> textures, Position position) {
		super(textures.get(0), position);
		this.textures = textures;
		timeDifference = 0;
		fieldStage = 0;
	}

	public boolean updateAvailability(float timeDifference) {
		boolean isGameContinue = true;

		this.timeDifference += timeDifference;
		if(this.timeDifference > 0.5) {
			this.timeDifference -= 0.5;
			++fieldStage;
			if(fieldStage < 5) {
				updateTexture(textures.get(fieldStage));
			} else {
				isGameContinue = false;
			}
		}
		return isGameContinue;
	}
}
