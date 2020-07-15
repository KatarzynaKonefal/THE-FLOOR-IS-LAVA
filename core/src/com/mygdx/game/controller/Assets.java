package com.mygdx.game.controller;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;

public class Assets implements Disposable{

	public final AssetManager manager = new AssetManager();
	
	public void load () {
		manager.load("sensej.png", Texture.class);
		manager.load("table.png", Texture.class);
		manager.load("basic.mp3", Music.class);
		manager.load("jump.wav", Sound.class);
		manager.load("backBig.png", SpriteBatch.class);
		manager.load("door.png", Texture.class);
		manager.load("Kasia1.png",Texture.class);
	}
	
	
	@Override
	public void dispose() {
		manager.dispose();
		
	}

}
