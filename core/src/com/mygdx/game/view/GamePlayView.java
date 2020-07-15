package com.mygdx.game.view;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.mygdx.game.LavaGame;
import com.mygdx.game.SafeField;
import com.mygdx.game.controller.Assets;
import com.mygdx.game.model.Exit;
import com.mygdx.game.model.Fire;
import com.mygdx.game.model.LavaPlayer;

public class GamePlayView extends AbstractView {
	
	
	private Texture imagePlayer, imageField, imageBackground, imageExit;
	private Exit exit;
	private Assets assets;
	private LavaPlayer lavaPlayer;
	private Fire fire;
	private ArrayList<SafeField> safeFields;
	

	private Music music;
	
	private float gravity = -20;

	public GamePlayView(LavaGame lavaBoard) {
		super(lavaBoard);

		Timer.schedule(new Task() {

			@Override
			public void run() {
				lavaBoard.setScreen(new LooserView(lavaBoard));
//				//lavaBoard.setScreen(new MainView( lavaBoard));
			}

		}, 1);
	}

	public void create() {
		assets = new Assets();
		assets.load();
		assets.manager.finishLoading();

		if (assets.manager.update()) {
			loadData();
			init();
		}
	}

	@Override
	protected void init() {
		initFire();

		lavaPlayer = new LavaPlayer(imagePlayer, assets);
		safeFields = new ArrayList<SafeField>();

		// music.play();

		exit = new Exit(imageExit, assets);
	}

	private void initFire() {
		fire = new Fire();
		stage.addActor(fire);

	}

	@Override
	public void render(float delta) {
		super.render(delta);
		update();
		create();
		spriteBatch.begin();
		stage.draw();
		spriteBatch.end();
	}

	private void update() {
		stage.act();
		hadleInput();
		
		lavaPlayer.y += lavaPlayer.jumpVelocity * Gdx.graphics.getDeltaTime();
	
				if (lavaPlayer.y > 0) {
					lavaPlayer.jumpVelocity += gravity;
				} else {
					lavaPlayer.y = 0;
					lavaPlayer.canJump = true;
		
					lavaPlayer.jumpVelocity = 0;
				}
		
				for (SafeField s : safeFields) {
					if (isPlayerOnSafeField(s)) {
						lavaPlayer.canJump = true;
						lavaPlayer.jumpVelocity = 0;
						lavaPlayer.y = s.y + s.height;
						}
					if (isPlayerOnExit(exit)) {
							//Gdx.app.exit();
		
		

	
				}
				}
	}
	private boolean isPlayerOnSafeField(SafeField s) {
	return lavaPlayer.jumpVelocity <= 0 && lavaPlayer.overlaps(s) && !(lavaPlayer.y <= s.y);

}
//naprawic
//private boolean isPlayerOnExit(Exit exit) {
//	return lavaPlayer.jumpVelocity <= 0 && lavaPlayer.overlaps(exit)&& lavaPlayer.y == exit.y  && lavaPlayer.x == exit.x;
//
//}

private void hadleInput() {

	if (Gdx.input.isKeyPressed(Keys.A)) {
		lavaPlayer.x -= 500 * Gdx.graphics.getDeltaTime();

	}

	if (Gdx.input.isKeyPressed(Keys.D)) {
		lavaPlayer.x += 500 * Gdx.graphics.getDeltaTime();

	}
	if (Gdx.input.isKeyPressed(Keys.W)) {
		lavaPlayer.jump();

	}
	if (Gdx.input.isKeyPressed(Keys.Z)) {
		camera.zoom += 0.02f;

	}

	if (Gdx.input.isKeyPressed(Keys.X)) {
		camera.zoom -= 0.02f;

	}
}
	

//	android
//	if(Gdx.input.justTouched()) {
//		player.jump();
//	}
//	camera.rotate(0.20f);



	private void loadData() {

		imagePlayer = assets.manager.get("sensej.png", Texture.class);
		imageField = assets.manager.get("table.png", Texture.class);

		imageExit = assets.manager.get("door.png", Texture.class);
		music = assets.manager.get("basic.mp3", Music.class);

	}
}


