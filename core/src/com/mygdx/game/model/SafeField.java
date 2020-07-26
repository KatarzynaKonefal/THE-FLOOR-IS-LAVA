package com.mygdx.game.model;
import com.badlogic.gdx.graphics.Texture;


import java.util.List;

public class SafeField extends GameObject {

	public static List<Texture> textures;
	public static double timeToDestroy;
	float timeDifference;
	public int fieldStage;


	public SafeField (Position position) {
		super(textures.get(0), position);
		timeDifference = 0;
		fieldStage = 0;
	}

	public boolean updateAvailability(float timeDifference, Points points) {
		boolean isGameContinue = true;

		this.timeDifference += timeDifference;
		if(this.timeDifference > timeToDestroy) {
			this.timeDifference -= timeToDestroy;
			++fieldStage;
			points.removePoint();

			updateTexture(textures.get(fieldStage));
			if(fieldStage == 4) {
				isGameContinue = false;
			}

		}


		return isGameContinue;
	}


}
