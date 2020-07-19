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

		labelFont.draw(lavaGame.batch, endingTxt, modelManager.getPlayer().x - modelManager.getPlayer().width, modelManager.getPlayer().y +modelManager.getPlayer().height, (int)(LavaGame.width / 4), Align.center, true);
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
		buttonExitTexture = new Texture(Gdx.files.internal("image/fire.png"));
		buttonExitTextureRegion = new TextureRegion(buttonExitTexture);
		buttonExitTexRegionDrawable = new TextureRegionDrawable(buttonExitTextureRegion);
		exitButton = new ImageButton(buttonExitTexRegionDrawable);
		exitButton.setWidth(300);
		exitButton.setHeight(250);
		exitButton.setX(modelManager.getPlayer().x + modelManager.getPlayer().width);
		exitButton.setY(modelManager.getPlayer().y + modelManager.getPlayer().height);
		exitButton.setDebug(true);
		stage.addActor(exitButton);
		Gdx.input.setInputProcessor(stage);


		exitButton.addListener(new ClickListener() {

			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				lavaGame.exit();
				return super.touchDown(event, x, y, pointer, button);
			}
		});
		stage.addActor(exitButton);
	}


	BitmapFont labelFont = new BitmapFont();

	String endingTxt = new String("Are you looser baby?\n" +
			"\tTry again - button\n" +
			"\tGet Out - button");
}