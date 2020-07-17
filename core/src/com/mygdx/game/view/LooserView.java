package com.mygdx.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.LavaGame;

public class LooserView extends AbstractView{

	private Button getOut;
	private Button tryAgain;
	
	
	
	public LooserView(LavaGame gameBoard) {
		super(gameBoard);
	
		
		
		getOut.addListener(new ClickListener() {

			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				Gdx.app.exit();
				System.out.print("tutaj wyjscie z gry");
				//rozpoczecie odliczania czasu
				return super.touchDown(event, x, y, pointer, button);
			}
		});
		
		tryAgain.addListener(new ClickListener() {
		@Override
		public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
			
			System.out.print("tutaj nowa gra");
			return super.touchDown(event, x, y, pointer, button);
		}
	});
		
	}

	@Override
	protected void init() {
		initTryAgainButton();
		initGetOutButton();
		
	}

	private void initGetOutButton() {
		getOut = new Button();
		getOut.setWidth(100);
		getOut.setHeight(50);
		getOut.setX(100);
		getOut.setY(100);
		getOut.setDebug(true);
		//getOut.addActor(startGame);
			
		
	}

	private void initTryAgainButton() {
		tryAgain = new Button();
		tryAgain.setWidth(100);
		tryAgain.setHeight(50);
		tryAgain.setX(100);
		tryAgain.setY(100);
		tryAgain.setDebug(true);
		
	}

	//tablica wynikow
	
	//Are you looser baby? 
	//Try again - button 
	//Get Out - button 
}
