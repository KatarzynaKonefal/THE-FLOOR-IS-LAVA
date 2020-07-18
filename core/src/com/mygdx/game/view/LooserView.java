package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.LavaGame;
import com.mygdx.game.controller.IGameController;
import com.mygdx.game.model.IModelManger;

public class LooserView extends GameplayView {

	protected Stage stage;

	private Texture buttonExitTexture;
	private TextureRegion buttonExitTextureRegion;
	private TextureRegionDrawable buttonExitTexRegionDrawable;
	private ImageButton exitButton;

	private Texture buttonAgainTexture;
	private TextureRegion buttonAgainTextureRegion;
	private TextureRegionDrawable buttonAgainTexRegionDrawable;
	private ImageButton againButton;


	public LooserView(LavaGame lavaGame, IGameController controller, IModelManger modelManager) {
		super(lavaGame, controller, modelManager);
		stage = new Stage(new StretchViewport(LavaGame.width, LavaGame.height, lavaGame.camera));
		initButtons();
	}

	@Override
	public void render(float deltaTime) {
		super.render(deltaTime);
		lavaGame.batch.begin();
		modelManager.getFire().draw(lavaGame.batch);
		labelFont.draw(lavaGame.batch, welcomeTxt, 100, 700, (int)(LavaGame.width / 4), Align.center, true);

		stage.addActor(exitButton);
		stage.addActor(againButton);
		lavaGame.batch.end();
	}

	private void initButtons() {
		buttonExitTexture = new Texture(Gdx.files.internal("image/kaczucha.png"));
		buttonExitTextureRegion = new TextureRegion(buttonExitTexture);
		buttonExitTexRegionDrawable = new TextureRegionDrawable(buttonExitTextureRegion);
		exitButton = new ImageButton(buttonExitTexRegionDrawable);
		exitButton.setWidth(100);
		exitButton.setHeight(50);
		exitButton.setX(100);
		exitButton.setY(100);
		exitButton.setDebug(true);
		stage.addActor(exitButton);
		Gdx.input.setInputProcessor(stage);

		exitButton.addListener(new ClickListener() {

			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				lavaGame.changeViewToGameplay();
				System.out.print("tutaj start gry przejscie do okna gry");
				//rozpoczecie odliczabia czasu
				return super.touchDown(event, x, y, pointer, button);
			}
		});
		buttonAgainTexture = new Texture(Gdx.files.internal("image/kaczucha.png"));
		buttonAgainTextureRegion = new TextureRegion(buttonExitTexture);
		buttonExitTexRegionDrawable = new TextureRegionDrawable(buttonExitTextureRegion);
		againButton = new ImageButton(buttonExitTexRegionDrawable);
		againButton.setWidth(100);
		againButton.setHeight(50);
		againButton.setX(100);
		againButton.setY(150);
		againButton.setDebug(true);
		stage.addActor(againButton);

		exitButton.addListener(new ClickListener() {

			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				lavaGame.exit();
				return super.touchDown(event, x, y, pointer, button);
			}
		});

		againButton.addListener(new ClickListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				System.out.print("tutaj przejscie do instrukcji dla matołkow");
				lavaGame.changeViewToWelcomeView();
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}

	BitmapFont labelFont = new BitmapFont();

	String welcomeTxt = new String("Are you looser baby?\n" +
			"\tTry again - button\n" +
			"\tGet Out - button");
}


