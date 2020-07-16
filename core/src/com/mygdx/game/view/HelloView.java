package com.mygdx.game.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.mygdx.game.LavaGame;

public class HelloView extends AbstractView {
	
	
	private Texture imageBackground; 
	Button startGame;
	Button instruction;


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
initButtons();
	}

	
	public void initButtons() {
	startGame = new Button(new ButtonStyle());
	startGame.setWidth(100);
	startGame.setHeight(50);
	startGame.setX(100);
	startGame.setY(100);
	startGame.setDebug(true);
	stage.addActor(startGame);
	
	
	startGame.addListener(new ClickListener(){
		
		@Override
		public boolean touchDown(InputEvent event, float x, float y,
				int pointer, int button) {
			System.out.print("tutaj start gry przejscie do okna gry");
			return super.touchDown(event, x, y, pointer, button);
		}
	});
	
	
	instruction = new Button(new ButtonStyle());
	instruction.setWidth(100);
	instruction.setHeight(50);
	instruction.setX(100);
	instruction.setY(150);
	instruction.setDebug(true);
	stage.addActor(instruction);
	
	instruction.addListener(new ClickListener(){
		
		@Override
		public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
			System.out.print("tutaj start gry przejscie do okna gry");
			return super.touchDown(event, x, y, pointer, button);
		}
	});
	
	
}
	
	
	
	@Override
	public void render(float delta) {

		super.render(delta);

		spriteBatch.begin();
		
		spriteBatch.draw(imageBackground, LavaGame.width - imageBackground.getWidth(),
				LavaGame.height - imageBackground.getHeight());
		spriteBatch.setProjectionMatrix(camera.combined);
		
		stage.draw();
		spriteBatch.end();
	}
}
