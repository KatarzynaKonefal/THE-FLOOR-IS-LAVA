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
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

public class GameBoard extends ApplicationAdapter {

	private Assets assets;

	private Music music;
	private Texture imagePlayer, imageField;
	private LavaPlayer player;
	private ArrayList<SafeField> safeFields;
	private OrthographicCamera camera;

	private float gravity = -15;

	SpriteBatch batch;

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
		music.play();
		camera = new OrthographicCamera(1000, 900);

		player = new LavaPlayer(imagePlayer, assets);
		safeFields = new ArrayList<SafeField>();

		for (int i = 1; i < 7; i++) {

			SafeField s = new SafeField(imageField);
			s.x = MathUtils.random(480);
			s.y = 250 * i;
			safeFields.add(s);

		}

	}

	private void loadData() {
		imagePlayer = assets.manager.get("sensej.png", Texture.class);
		imageField = assets.manager.get("table.png", Texture.class);
		music = assets.manager.get("basic.mp3", Music.class);
	}

	@Override
	public void render() {
		update();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.setProjectionMatrix(camera.combined);

		for (SafeField s : safeFields) {
			s.draw(batch);
		}

		player.draw(batch);
		batch.end();
	}

	private void update() {
		hadleInput();

		camera.update();
		camera.position.set(player.x + player.width / 2, player.y + 300, 0);

		player.y += player.jumpVelocity * Gdx.graphics.getDeltaTime();

		if (player.jumpVelocity > 0) {
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
		}

	}

	private boolean isPlayerOnSafeField(SafeField s) {
		return player.jumpVelocity <= 0 && player.overlaps(s) && !(player.y <= s.y);

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
		
//		if (Gdx.input.isKeyPressed(Keys.S)) {
//			gameObject_1.y -= 500 * Gdx.graphics.getDeltaTime();

	}

}
	
//	
//	private Music music;
//	private Sound sound;
//	
//	private OrthographicCamera camera;
//	
//	private SpriteBatch batch;
//	private Texture img;
//	private BitmapFont font;
//	private GameObject gameObject_1, gameObject_2;
//	private float timeHelper;
//
//	@Override
//	public void create() {
//		
//		music = Gdx.audio.newMusic(Gdx.files.internal("Python.wav"));
//		music.play();
//		
//		sound = Gdx.audio.newSound(Gdx.files.internal("Python.wav"));
//		
//		
//		camera = new OrthographicCamera(18000,9000);
//		
//		batch = new SpriteBatch();
//		img = new Texture("Kasia1.png");
//		
//		font = new BitmapFont();
//		font.setColor(Color.BLACK);
//
//		gameObject_1 = new GameObject(img);
//		gameObject_1.x = 50;
//		gameObject_1.y = 50;
//		gameObject_1.height = gameObject_1.getTexture().getHeight();
//		gameObject_1.width = gameObject_1.getTexture().getWidth();
//		
//		
//		gameObject_2 = new GameObject(img);
//		gameObject_2.x = 1000;
//		gameObject_2.y = 400;
//		gameObject_2.height =  gameObject_2.getTexture().getHeight();
//		gameObject_2.width = gameObject_2.getTexture().getWidth();
//		
//	}
//
//	@Override
//	public void render() {
//		update();
//
//		Gdx.gl.glClearColor(1, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.begin();
//
//		batch.draw(gameObject_1.getTexture(), gameObject_1.x, gameObject_1.y);
//		batch.draw(gameObject_2.getTexture(), gameObject_2.x, gameObject_2.y);
//		font.draw(batch, "helloWord", 300, 300);
//		batch.end();
//	}
//
//	private void update() {
//		
//		camera.update();
//		batch.setProjectionMatrix(camera.combined);
//		camera.position.set(gameObject_1.x + gameObject_1.width/2,gameObject_1.y + gameObject_1.height/2, 0);
//		
//		
//		if (Gdx.input.isKeyPressed(Keys.Z)) {
//			camera.zoom += 0.02f;
//
//			}
//
//		if (Gdx.input.isKeyPressed(Keys.X)) {
//			camera.zoom -= 0.02f;
//
//			}
//		
//		
//		if (Gdx.input.isKeyPressed(Keys.W)) {
//		gameObject_1.y += 500*Gdx.graphics.getDeltaTime();
//
//		}
//		if (Gdx.input.isKeyPressed(Keys.A)) {
//			gameObject_1.x -= 500*Gdx.graphics.getDeltaTime();
//
//		}
//		if (Gdx.input.isKeyPressed(Keys.S)) {
//			gameObject_1.y -= 500*Gdx.graphics.getDeltaTime();
//		}
//		if (Gdx.input.isKeyPressed(Keys.D)) {
//			gameObject_1.x +=500*Gdx.graphics.getDeltaTime();
//
//		}
//		
//		if(gameObject_1.overlaps(gameObject_2)) {
//			//Gdx.app.exit();
//			sound.play();
//			gameObject_1.x = 0;
//			gameObject_1.y = 0;
//		}
//		timeHelper += Gdx.graphics.getDeltaTime();
//		if(timeHelper > 0.02f) {
//		//wyzszelvl
//			//camera.rotate(0.20f);
//			timeHelper = 0;
//		}
//	}
//
//	@Override
//	public void dispose() {
//		font.dispose();
//		batch.dispose();
//		img.dispose();
//		music.dispose();
//		sound.dispose();
//		System.out.println("dispose");
//	}
//}
