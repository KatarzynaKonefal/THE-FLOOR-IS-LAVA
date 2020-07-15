package com.mygdx.game.view;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.mygdx.game.LavaGame;
import com.mygdx.game.SafeField;
import com.mygdx.game.model.LavaPlayer;

public class MainView extends AbstractView{
	
	private Texture imagePlayer, imageField, imageExit, imageBackground;
//	private LavaPlayer player;
//	private ArrayList<SafeField> safeFields;

	HelloView helloView;
	LooserView looserView;
	
	
	public MainView(LavaGame lavaBoard) {
		super(lavaBoard);
		init();
		
		
		
		//timer do wywalonia koplejnego okna po x czsie 
		//Hello i instrukcje, po klikaniu? 
		//Bye Bye, looser/winner po porażce/zwycięstwie
		
//		Timer.schedule(new Task() {
//			
//			@Override
//			public void run() {
//				lavaBoard.setScreen(new GamePlayView(lavaBoard));
////				//lavaBoard.setScreen(new MainView( lavaBoard));
//			}
//			
//		}, 1);
		
		
	}
	
		
	
	

	protected void init() {
		
		imageBackground = new Texture("Hello.gif");
	}
	

	


	@Override
	public void render(float delta) {

		super.render(delta);


	
	}
	

	
	
}



