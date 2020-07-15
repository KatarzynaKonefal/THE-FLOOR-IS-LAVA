package com.mygdx.game.desktop;

import java.io.File;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.GameBoard;
import com.mygdx.game.controller.Assets;

public class DesktopLauncher {
	
	public static void main (String[] arg) {
		
		LwjglApplicationConfiguration floorIsLava = new LwjglApplicationConfiguration();
		
		floorIsLava.title = GameBoard.gameName;
		
		floorIsLava.width = GameBoard.width;
		floorIsLava.height = GameBoard.height;
		
		floorIsLava.resizable = false;
		
		
		new LwjglApplication(new GameBoard(), floorIsLava);
	}
}
