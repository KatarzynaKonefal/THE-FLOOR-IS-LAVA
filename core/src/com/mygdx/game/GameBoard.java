package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

public class GameBoard extends ApplicationAdapter {

	private Assets assets;

	private Music music;
	private Texture imagePlayer, imageField, imageBackground, imageExit;
	private Sprite imageBackgroundSprite;
	private LavaPlayer player;
	private ArrayList<SafeField> safeFields;
	private OrthographicCamera camera;
	private Exit exit;

	private int width;
	private int heigh;

	private float gravity = -20;

	SpriteBatch batch;

	public GameBoard(int width, int heigh) {
		this.width = width;
		this.heigh = heigh;
	}

	@Override
	public void create() {

		assets = new Assets();
		assets.load();
		assets.manager.finishLoading();

		if (assets.manager.update()) {
			loadData();
			init();
		}
	}

	private void init() {
		batch = new SpriteBatch();
		// music.play();
		camera = new OrthographicCamera(width, heigh);

		exit = new Exit(imageExit, assets);

		player = new LavaPlayer(imagePlayer, assets);
		safeFields = new ArrayList<SafeField>();

		for (int i = 1; i < 170; i++) {

			SafeField s = new SafeField(imageField);
			s.x = MathUtils.random(width);
			s.y = 50 * i;
			safeFields.add(s);

			// doodac zeby nie nachodzily

		}

	}

	private void loadData() {
		imageBackground = assets.manager.get("backBig.png", Texture.class);
		imageBackgroundSprite = new Sprite(imageBackground);

		imagePlayer = assets.manager.get("sensej.png", Texture.class);
		imageField = assets.manager.get("table.png", Texture.class);

		imageExit = assets.manager.get("door.png", Texture.class);
		music = assets.manager.get("basic.mp3", Music.class);

	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(240 / 255f, 128 / 255f, 128 / 255f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		update();

		batch.begin();
		batch.draw(imageBackgroundSprite, -width / 2, -heigh / 2);
		batch.setProjectionMatrix(camera.combined);

		for (SafeField s : safeFields) {
			s.draw(batch);
		}

		player.draw(batch);

		exit.draw(batch);

		batch.end();
	}

	private void update() {
		
		hadleInput();

		camera.update();
		camera.position.set(player.x + player.width / 2, player.y + 300, 0);
		// camera.position.set(0,0, 0);

		player.y += player.jumpVelocity * Gdx.graphics.getDeltaTime();

		if (player.y > 0) {
			player.jumpVelocity += gravity;
		} else {
			player.y = 0;
			player.canJump = true;

			player.jumpVelocity = 0;
		}

		for (SafeField s : safeFields) {
			if (isPlayerOnSafeField(s)) {
				player.canJump = true;
				player.jumpVelocity = 0;
				player.y = s.y + s.height;
				}
//			if (isPlayerOnExit(exit)) {
//					//Gdx.app.exit();
//				}
			}
		
	}

	private boolean isPlayerOnSafeField(SafeField s) {
		return player.jumpVelocity <= 0 && player.overlaps(s) && !(player.y <= s.y);

	}
	//naprawic
	private boolean isPlayerOnExit(Exit exit) {
		return player.jumpVelocity <= 0 && player.overlaps(exit)&& player.y == exit.y  && player.x == exit.x;

	}
	
	private void hadleInput() {

		if (Gdx.input.isKeyPressed(Keys.A)) {
			player.x -= 500 * Gdx.graphics.getDeltaTime();

		}

		if (Gdx.input.isKeyPressed(Keys.D)) {
			player.x += 500 * Gdx.graphics.getDeltaTime();

		}
		if (Gdx.input.isKeyPressed(Keys.W)) {
			player.jump();

		}
		if (Gdx.input.isKeyPressed(Keys.Z)) {
			camera.zoom += 0.02f;

		}

		if (Gdx.input.isKeyPressed(Keys.X)) {
			camera.zoom -= 0.02f;

		}

//		android
//		if(Gdx.input.justTouched()) {
//			player.jump();
//		}
//		camera.rotate(0.20f);

	}

}
