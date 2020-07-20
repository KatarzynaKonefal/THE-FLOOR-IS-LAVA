package com.mygdx.game.model;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.LavaGame;

import java.util.List;

public class SafeField extends GameObject {

	public static List<Texture> textures;
	public static double timeToDestroy;
	float timeDifference;
	int fieldStage;
	LavaGame lavaGame;
	
	public SafeField (Position position) {
		super(textures.get(0), position);
		timeDifference = 0;
		fieldStage = 0;
	}

	public boolean updateAvailability(float timeDifference) {
		boolean isGameContinue = true;

		this.timeDifference += timeDifference;
		if(this.timeDifference > timeToDestroy) {
			this.timeDifference -= timeToDestroy;
			++fieldStage;

			updateTexture(textures.get(fieldStage));
			if(fieldStage == 4) {
				isGameContinue = false;
			}

		}
		return isGameContinue;
	}


}
