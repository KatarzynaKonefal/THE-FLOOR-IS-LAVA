package com.mygdx.game.controller;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.mygdx.game.LavaGame;
import com.mygdx.game.model.*;
import com.mygdx.game.view.GameplayView;

public class GameController implements IGameController {

	LavaGame lavaGame;
	IModelManager modelManager;


	private float gravity = -20;

	int deadPosition;

	public GameController(LavaGame lavaGame,
						  IModelManager modelManager) {

		this.lavaGame = lavaGame;
		this.modelManager = modelManager;
		deadPosition = -5 * lavaGame.height / 12;
	}

	@Override
	public void update() {
		pauseGame();

		if (modelManager.getPlayer().isAlive) {
			handleInput();

			float timeDifference = Gdx.graphics.getDeltaTime();

			modelManager.getPlayer().y += modelManager.getPlayer().jumpVelocity * timeDifference;

			if (modelManager.getPlayer().y <= deadPosition) {
				lavaGame.changeViewToLooser();
				modelManager.getPlayer().isAlive = false;
				lavaGame.changeCameraViewToUser();
			} else {
				modelManager.getPlayer().jumpVelocity += gravity;
			}

			for (SafeField field : modelManager.getSafeFields()) {
				if (isPlayerOnSafeField(field)) {
					boolean isGameContinue = field.updateAvailability(timeDifference);
					if (isGameContinue) {
						modelManager.getPlayer().canJump = true;
						modelManager.getPlayer().jumpVelocity = 0;
						modelManager.getPlayer().y = field.y + field.height / 2;

					} else {
						lavaGame.changeViewToLooser();
						modelManager.getPlayer().isAlive = false;
						lavaGame.changeCameraViewToUser();
					}
				}
			}

			if (isPlayerOnExit(modelManager.getExitField())) {
				lavaGame.changeViewToWinnerView();
				modelManager.getPlayer().isAlive = false;
				lavaGame.changeCameraViewToUser();
				//modelManager.addBonusExit();
			}
		}
		//modelManager.getPoints();
	}

	private boolean isPlayerOnSafeField(SafeField s) {
		return modelManager.getPlayer().jumpVelocity <= 0 && modelManager.getPlayer().overlaps(s) && !(modelManager.getPlayer().y <= s.y);
	}

	private boolean isPlayerOnExit(Exit exit) {
		return modelManager.getPlayer().overlaps(exit);

	}

	private void handleInput() {

		if (Gdx.input.isKeyPressed(Keys.A)) {
			modelManager.getPlayer().x -= 500 * Gdx.graphics.getDeltaTime();

		}

		if (Gdx.input.isKeyPressed(Keys.D)) {
			modelManager.getPlayer().x += 500 * Gdx.graphics.getDeltaTime();

		}
		if (Gdx.input.isKeyPressed(Keys.W)) {
			modelManager.getPlayer().jump();

		}
		lavaGame.cameraRepositionIsEnable = true;


		if (Gdx.input.isKeyPressed(Keys.Z)) {
			lavaGame.camera.position.set(lavaGame.width,
					lavaGame.height, 0);
			lavaGame.camera.zoom = 3;
			lavaGame.cameraRepositionIsEnable = false;
		}



	}

	public void pauseGame(){
		if (Gdx.input.isKeyJustPressed(Keys.P) && modelManager.getPlayer().isAlive) {
			modelManager.getPlayer().isAlive = false;

		} else if (Gdx.input.isKeyPressed(Keys.O) && !modelManager.getPlayer().isAlive) {
			modelManager.getPlayer().isAlive = true;

		}
	}
}
