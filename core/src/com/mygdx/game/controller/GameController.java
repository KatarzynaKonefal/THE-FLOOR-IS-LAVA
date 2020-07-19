package com.mygdx.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.mygdx.game.LavaGame;
import com.mygdx.game.model.*;

public class GameController implements IGameController {

	LavaGame lavaGame;
	IModelManger modelManger;

	private float gravity = -20;

	int deadPosition;

	public GameController(LavaGame lavaGame,
						  IModelManger modelManger) {

		this.lavaGame = lavaGame;
		this.modelManger = modelManger;
		deadPosition = -5*lavaGame.height/12;
	}

	@Override
	public void update() {
		if(modelManger.getPlayer().isAlive) {
			handleInput();

			float timeDifference = Gdx.graphics.getDeltaTime();

			modelManger.getPlayer().y += modelManger.getPlayer().jumpVelocity * timeDifference;

			if (modelManger.getPlayer().y <= deadPosition) {
				lavaGame.changeViewToLooser();
				modelManger.getPlayer().isAlive = false;
			} else {
				modelManger.getPlayer().jumpVelocity += gravity;
			}

			for (SafeField field : modelManger.getSafeFields()) {
				if (isPlayerOnSafeField(field)) {
					boolean isGameContinue = field.updateAvailability(timeDifference);
					if(isGameContinue) {
						modelManger.getPlayer().canJump = true;
						modelManger.getPlayer().jumpVelocity = 0;
						modelManger.getPlayer().y = field.y + field.height/2;
					} else {
						lavaGame.changeViewToLooser();
						modelManger.getPlayer().isAlive = false;
					}
				}
			}

			if (isPlayerOnExit(modelManger.getExitField())) {
				lavaGame.changeViewToWinnerView();
				modelManger.getPlayer().isAlive = false;
			}
		}
	}

	private boolean isPlayerOnSafeField(SafeField s) {
		return modelManger.getPlayer().jumpVelocity <= 0 && modelManger.getPlayer().overlaps(s) && !(modelManger.getPlayer().y <= s.y);

	}

	private boolean isPlayerOnExit(Exit exit) {
		return modelManger.getPlayer().overlaps(exit);

	}
	
	private void handleInput() {

		if (Gdx.input.isKeyPressed(Keys.A)) {
			modelManger.getPlayer().x -= 500 * Gdx.graphics.getDeltaTime();

		}

		if (Gdx.input.isKeyPressed(Keys.D)) {
			modelManger.getPlayer().x += 500 * Gdx.graphics.getDeltaTime();

		}
		if (Gdx.input.isKeyPressed(Keys.W)) {
			modelManger.getPlayer().jump();

		}
		if (Gdx.input.isKeyPressed(Keys.Z)) {
			lavaGame.camera.zoom += 0.02f;

		}

		if (Gdx.input.isKeyPressed(Keys.X)) {
			lavaGame.camera.zoom -= 0.02f;

		}
	}

}

//		android
//		if(Gdx.input.justTouched()) {
//			player.jump();
//		}
//		camera.rotate(0.20f);

