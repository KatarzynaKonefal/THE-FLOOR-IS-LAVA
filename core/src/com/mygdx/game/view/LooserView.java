package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.LavaGame;
import com.mygdx.game.controller.IGameController;
import com.mygdx.game.model.IModelManager;
import com.mygdx.game.model.Points;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LooserView extends GameplayView {

	protected Stage stage;

	BitmapFont labelFont = new BitmapFont();

	String endingTxt = "Are you looser baby?\n"
			  + "The best point results are:\n";

	public LooserView(LavaGame lavaGame, IGameController controller, IModelManager modelManager) {
		super(lavaGame, controller, modelManager);
		stage = new Stage(new StretchViewport(LavaGame.width, LavaGame.height, lavaGame.camera));

	}

	@Override
	public void show() {
		initButtons();

		PlayerNameInputListener listener = new PlayerNameInputListener(modelManager);
		Gdx.input.getTextInput(listener, "Player name", "", "type your name");
	}

	@Override
	public void render(float deltaTime) {
		super.render(deltaTime);
		lavaGame.batch.begin();
		modelManager.getFire().draw(lavaGame.batch);

		labelFont.draw(lavaGame.batch,
				lavaGame.generateScoreTable(endingTxt),
				modelManager.getPlayer().x + modelManager.getPlayer().getWidth(),
				modelManager.getPlayer().y + modelManager.getPlayer().getHeight(),
				(int)(LavaGame.width / 4),
				Align.center,
				true);

		lavaGame.batch.end();

		lavaGame.batch.begin();
		stage.draw();
		lavaGame.batch.end();

	}

	@Override
	public void hide(){
		Gdx.input.setInputProcessor(null);
	}

	private void initButtons() {
		GameButton exitButton = new GameButton("image/exit.png",
				modelManager.getPlayer().x + modelManager.getPlayer().width,
				modelManager.getPlayer().y + modelManager.getPlayer().height + 150,
				300,
				250);

		exitButton.addListener(new ClickListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				Gdx.app.exit();
				return super.touchDown(event, x, y, pointer, button);
			}
		});

		Gdx.input.setInputProcessor(stage);
		stage.addActor(exitButton.getButton());

		GameButton playAgainButton = new GameButton("image/start.png",
				modelManager.getPlayer().x + modelManager.getPlayer().width ,
				modelManager.getPlayer().y + modelManager.getPlayer().height,
				300,
				250);

		playAgainButton.addListener(new ClickListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				lavaGame.reinitializeGame();
				return super.touchDown(event, x, y, pointer, button);
			}
		});

		Gdx.input.setInputProcessor(stage);
		stage.addActor(playAgainButton.getButton());
	}

}