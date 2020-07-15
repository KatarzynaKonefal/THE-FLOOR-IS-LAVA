package com.mygdx.game.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.mygdx.game.LavaGame;

public class HelloView extends AbstractView {
	
	
	private Texture imageBackground; 
	Button startGame;
	Button instruction;
	Skin  skinButton = new Skin();

	public HelloView(LavaGame lavaBoard) {
		super(lavaBoard);
		
		Timer.schedule(new Task() {
			
			@Override
			public void run() {
				lavaBoard.setScreen(new GamePlayView(lavaBoard));
//				//lavaBoard.setScreen(new MainView( lavaBoard));
			}
			
		}, 1);
	}

	@Override
	protected void init() {
		
imageBackground = new Texture("Hello.gif");
initButton();
	}

	
	public void initButton() {
	startGame = new Button( );
	startGame.setWidth(100);
	startGame.setHeight(50);
	startGame.setX(100);
	startGame.setY(100);
	
	instruction = new Button();
	instruction.setWidth(100);
	instruction.setHeight(50);
	instruction.setX(100);
	instruction.setY(150);
	
	}
	
	@Override
	public void render(float delta) {

		super.render(delta);

		spriteBatch.begin();
		spriteBatch.draw(imageBackground, LavaGame.width - imageBackground.getWidth(),
				LavaGame.height - imageBackground.getHeight());
		spriteBatch.setProjectionMatrix(camera.combined);
		spriteBatch.end();
	}
}
