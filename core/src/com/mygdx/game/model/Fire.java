package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Fire extends Image{
	
	
	//odniesc do wymiarow okna
	int widht = 120;
	int height = 101;
	
	int startX = 50;
	int startY = 50;
	
	public Fire () {
		super(new Texture("fire120x101.png"));
		
		this.setOrigin(widht/2, height/2);
		this.setSize(widht, height);
		
		this.setPosition(startX, startY);
	}
	

}
