package com.mygdx.game.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.mygdx.game.LavaGame;
import com.mygdx.game.model.Fire;

public class HelloView extends AbstractView {

	private Texture imageBackground;
	private Button startGame;
	private Button instruction;

	private Label textLabel;
	private Label.LabelStyle labelStyle;

	private Color color;
	private Fire fire;

	public HelloView(LavaGame lavaBoard) {
		super(lavaBoard);

		startGame.addListener(new ClickListener() {

			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				lavaBoard.setScreen(new GamePlayView(lavaBoard));
				System.out.print("tutaj start gry przejscie do okna gry");
				//rozpoczecie odliczabia czasu
				return super.touchDown(event, x, y, pointer, button);
			}
		});

//		Timer.schedule(new Task() {
//			
//			@Override
//			public void run() {
//				lavaBoard.setScreen(new GamePlayView(lavaBoard));
////				//lavaBoard.setScreen(new MainView( lavaBoard));
//			}
//			
//		}, 10);
	}

	@Override
	protected void init() {
		initButtons();
		imageBackground = new Texture("Hello.gif");
		initFire();

//initLabelStyle();
//initTextLabel();

	}

//	private void initLabelStyle() {
//		labelStyle = new Label.LabelStyle();
//		labelFont = new BitmapFont(Gdx.files.internal("Calibri.fnt"),Gdx.files.internal("Calibri.png"),false);
//		labelStyle.font = labelFont;
//	}
//
//	private void initTextLabel() {
//		textLabel = new Label("Welcome", labelStyle);
//		textLabel.setColor(color.BLACK);
//		textLabel.setPosition(600, 600);
//		
//		stage.addActor(textLabel);
//		
//	}

	private void initFire() {
		fire = new Fire();
		fire.getRotation();
		stage.addActor(fire);

	}

	public void initButtons() {
		startGame = new Button(new ButtonStyle());
		startGame.setWidth(100);
		startGame.setHeight(50);
		startGame.setX(100);
		startGame.setY(100);
		startGame.setDebug(true);
		stage.addActor(startGame);

		instruction = new Button(new ButtonStyle());
		instruction.setWidth(100);
		instruction.setHeight(50);
		instruction.setX(100);
		instruction.setY(150);
		instruction.setDebug(true);
		stage.addActor(instruction);

		instruction.addListener(new ClickListener() {

			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				System.out.print("tutaj przejscie do instrukcji dla matołkow");

				return super.touchDown(event, x, y, pointer, button);
			}
		});

		stage.addActor(startGame);
		stage.addActor(instruction);
	}

	BitmapFont labelFont = new BitmapFont();

	String welcomeTxt = new String("Welcome  Team Prymuski Kasia&Beata presents FLOOR IS LAVA\r\n"
			+ "Year 2020 it wasn't good for humanity but is not the end of the catastrophs.\r\n"
			+ "It is the begging of end.\r\n"
			+ "The most dangerous and the biggest vulcano of the mother earth show in the end of july its anger.\r\n"
			+ "The only hope is jump and run because THE FLOOR IS LAVA!");

	@Override
	public void render(float delta) {

		super.render(delta);

		spriteBatch.begin();

		spriteBatch.draw(imageBackground, LavaGame.width - imageBackground.getWidth(),
				(LavaGame.height - imageBackground.getHeight()));
		
		
		spriteBatch.setProjectionMatrix(camera.combined);
			
		labelFont.draw(spriteBatch, welcomeTxt, 100, 700, LavaGame.width / 4, Align.center, true);

		
		spriteBatch.end();
		
		spriteBatch.begin();
		stage.draw();
		spriteBatch.end();
	}

}
