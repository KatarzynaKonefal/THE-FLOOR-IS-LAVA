package com.mygdx.game.view;

import com.mygdx.game.GameBoard;
import com.mygdx.game.model.Fire;

public class GamePlayView extends AbstractView{
	
	
	private Fire fire;

	public GamePlayView(GameBoard gameBoard) {
		super(gameBoard);
		init();
	}

	private void init() {
		intFire();
		
	}

	private void intFire() {
		fire  = new Fire();
		stage.addActor(fire);
		
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		update();
		spriteBatch.begin();
		stage.draw();
		spriteBatch.end();
	}

	private void update() {
		stage.act();
		
	}

}
