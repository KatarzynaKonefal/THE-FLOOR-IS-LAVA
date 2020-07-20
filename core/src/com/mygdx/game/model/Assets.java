package com.mygdx.game.model;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;
import java.util.Map;

public class Assets {

	public AssetManager manager;
	public Map<String,String> textureFilenamesMap;
	public Map<String, String> musicFilenamesMap;
	public Map<String, String> soundFilenamesMap;

	public Assets() {
		manager = new AssetManager();
		textureFilenamesMap = new HashMap<>();
		textureFilenamesMap.put("Player", "image/sensej.png");
		textureFilenamesMap.put("Kaczucha", "image/kaczucha.png");
		textureFilenamesMap.put("Exit", "image/door.png");
		textureFilenamesMap.put("SafeFieldStage1", "image/tableStage1.png");
		textureFilenamesMap.put("SafeFieldStage2", "image/tableStage2.png");
		textureFilenamesMap.put("SafeFieldStage3", "image/tableStage3.png");
		textureFilenamesMap.put("SafeFieldStage4", "image/tableStage4.png");
		textureFilenamesMap.put("SafeFieldStage5", "image/tableStage5.png");
		textureFilenamesMap.put("ImageBackground", "image/background3times.png");
		textureFilenamesMap.put("Fire", "image/fire.png");
		textureFilenamesMap.put("Winner", "image/winner.png");
		textureFilenamesMap.put("Sound", "image/sound.png");

		musicFilenamesMap = new HashMap<>();
		musicFilenamesMap.put("Basic", "sound/basic.mp3");
		musicFilenamesMap.put("Looser","sound/sreaming.mp3");

		soundFilenamesMap = new HashMap<>();
		soundFilenamesMap.put("Jump", "sound/jump.wav");


	}

	public void load () {
		for(Map.Entry<String, String> entry : textureFilenamesMap.entrySet()) {
			manager.load(entry.getValue(), Texture.class);
		}

		for(Map.Entry<String,String > entry: musicFilenamesMap.entrySet()){
			manager.load(entry.getValue(), Music.class);
		}


		for(Map.Entry<String,String > entry: soundFilenamesMap.entrySet()){
			manager.load(entry.getValue(), Sound.class);
		}

	}
}