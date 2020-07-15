package com.mygdx.game.view;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.GameBoard;
import com.mygdx.game.SafeField;
import com.mygdx.game.model.LavaPlayer;

public class MainView extends AbstractView{
	
	private Texture imagePlayer, imageField, imageExit, imageBackground;
	private LavaPlayer player;
	private ArrayList<SafeField> safeFields;
	
	

	

	public MainView(GameBoard gameBoard) {
		super(gameBoard);
		init();
	}

	private void init() {
		
		imageBackground = new Texture("backBig.png");
		//player = new LavaPlayer(imagePlayer, assets);
		//safeFields = new ArrayList<SafeField>();
		
		
//	batch = new SpriteBatch();
//	// music.play();
//	camera = new OrthographicCamera(width, heigh);
//
//	exit = new Exit(imageExit, assets);
//
//	
//
//	for (int i = 1; i < 170; i++) {
//
//		SafeField s = new SafeField(imageField);
//		s.x = MathUtils.random(width);
//		s.y = 50 * i;
//		safeFields.add(s);
//
//		// doodac zeby nie nachodzily

	}
	private void loadData() {
	//imageBackground = assets.manager.get("backBig.png", Texture.class);
	//imageBackground = new SpriteBatch("imageBackground". SpriteBatch);

	imagePlayer = assets.manager.get("sensej.png", Texture.class);
	imageField = assets.manager.get("table.png", Texture.class);

	imageExit = assets.manager.get("door.png", Texture.class);
	//music = assets.manager.get("basic.mp3", Music.class);

}

	@Override
	public void render(float delta) {
		
		super.render(delta);


		spriteBatch.begin();
		spriteBatch.draw(imageBackground, 0, 0);
		spriteBatch.setProjectionMatrix(camera.combined);

//		for (SafeField s : safeFields) {
//			s.draw(spriteBatch);
//		}
//
//		player.draw(spriteBatch);

		//exit.draw(spriteBatch);
//
		spriteBatch.end();
	
	}
	

	
	
}



