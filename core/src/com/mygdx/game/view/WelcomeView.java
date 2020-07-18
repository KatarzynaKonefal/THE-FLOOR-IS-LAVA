package com.mygdx.game.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.LavaGame;
//import com.mygdx.game.model.Fire;

public class WelcomeView extends ScreenAdapter {
    LavaGame lavaGame;
    protected Stage stage;

    private Texture imageBackground;


    private Texture buttonStartTexture;
    private TextureRegion buttonStartTextureRegion;
    private TextureRegionDrawable buttonStartTexRegionDrawable;
    private ImageButton startButton;
//    private Button startGame;
    private Button instruction;

    private Label textLabel;
    private Label.LabelStyle labelStyle;

    private Color color;

    public WelcomeView(LavaGame lavaGame) {
        this.lavaGame = lavaGame;
        stage = new Stage(new StretchViewport(LavaGame.width, LavaGame.height, lavaGame.camera));

        imageBackground = new Texture("image/kaczucha.png");


//        startGame.addListener(new ClickListener() {
//
//            @Override
//            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
//                lavaGame.setScreen(new GamePlayView(lavaGame));
//                System.out.print("tutaj start gry przejscie do okna gry");
//                //rozpoczecie odliczabia czasu
//                return super.touchDown(event, x, y, pointer, button);
//            }
//        });

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
    public void show(){
        initButtons();
    }

    @Override
    public void render(float delta) {
        lavaGame.batch.begin();
        Gdx.gl.glClearColor(0, .25f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        lavaGame.batch.draw(imageBackground, LavaGame.width - imageBackground.getWidth(),
                (LavaGame.height - imageBackground.getHeight()));


        lavaGame.batch.setProjectionMatrix(lavaGame.camera.combined);

        labelFont.draw(lavaGame.batch, welcomeTxt, 100, 700, (int)(LavaGame.width / 4), Align.center, true);
        lavaGame.batch.end();

        lavaGame.batch.begin();
        stage.draw();
        lavaGame.batch.end();
    }


    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }

//    @Override
//    protected void init() {
//        initButtons();
//        imageBackground = new Texture("Hello.gif");
//        initFire();

//initLabelStyle();
//initTextLabel();


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

//    private void initFire() {
//        fire = new Fire();
//        fire.getRotation();
//        stage.addActor(fire);
//
//    }

    private void initButtons() {
        buttonStartTexture = new Texture(Gdx.files.internal("kaczucha.png"));
        buttonStartTextureRegion = new TextureRegion(buttonStartTexture);
        buttonStartTexRegionDrawable = new TextureRegionDrawable(buttonStartTextureRegion);
        startButton = new ImageButton(buttonStartTexRegionDrawable);
        startButton.setWidth(100);
        startButton.setHeight(50);
        startButton.setX(100);
        startButton.setY(100);
        startButton.setDebug(true);
        stage.addActor(startButton);
        Gdx.input.setInputProcessor(stage);

        startButton.addListener(new ClickListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                lavaGame.changeViewToGameplay();
                System.out.print("tutaj start gry przejscie do okna gry");
                //rozpoczecie odliczabia czasu
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

        instruction.addListener(new ClickListener() {

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.print("tutaj przejscie do instrukcji dla matołkow");

                return super.touchDown(event, x, y, pointer, button);
            }
        });

        stage.addActor(startButton);
        stage.addActor(instruction);
    }

    BitmapFont labelFont = new BitmapFont();

    String welcomeTxt = "Welcome  Team Prymuski Kasia&Beata presents FLOOR IS LAVA\r\n"
            + "Year 2020 it wasn't good for humanity but is not the end of the catastrophs.\r\n"
            + "It is the begging of end.\r\n"
            + "The most dangerous and the biggest vulcano of the mother earth show in the end of july its anger.\r\n"
            + "The only hope is jump and run because THE FLOOR IS LAVA!";
}
