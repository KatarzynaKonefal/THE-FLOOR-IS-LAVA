//package com.mygdx.game.view;
//
//import com.badlogic.gdx.scenes.scene2d.InputEvent;
//import com.badlogic.gdx.scenes.scene2d.ui.Button;
//import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
//import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
//import com.mygdx.game.controller.IClickController;
//
//public class ButtonGame extends Button {
//
//	public ButtonGame(final IClickController clikController) {
//		super(new ButtonStyle());
//		init(clikController);
//	}
//
//	private void init(final IClickController clikController) {
//		this.setWidth(100);
//		this.setHeight(50);
//		this.setX(100);
//		this.setY(100);
//		
//		
//		this.addListener(new ClickListener() {
//			@Override 
//			public boolean touchDown(InputEvent event, float x, float y,
//					int pointer, int button) {
//				
//				clikController.clickButton();
//				
//				return super.touchDown(event, x, y, pointer, button);
//			}
//		});
//		
//	
//	}
//
//}
