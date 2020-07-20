package com.mygdx.game.view;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.LavaGame;
import com.mygdx.game.model.Assets;
import com.mygdx.game.model.IModelManager;
import com.mygdx.game.model.Level;


public class WelcomeView extends ScreenAdapter {

    LavaGame lavaGame;
    IModelManager modelManager;
    private Assets assets;

    protected Stage stage;
    private GameButton easyButton, hardButton, soundButton;

    private Music music;


    private Texture imageBackground, imageInstruction;

    public WelcomeView(LavaGame lavaGame, IModelManager modelManager) {
        this.lavaGame = lavaGame;
        stage = new Stage(new StretchViewport(LavaGame.width, LavaGame.height, lavaGame.camera));

        this.modelManager = modelManager;

        imageBackground = new Texture("image/Hello.gif");

        imageInstruction = new Texture("image/wsad.jpg");




    }

    @Override
    public void show(){
        initButtons();
    }

    @Override
    public void render(float delta) {
        lavaGame.batch.begin();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        lavaGame.batch.draw(imageBackground,0, 0);

        lavaGame.batch.draw(imageInstruction,1450,  50);


        lavaGame.batch.setProjectionMatrix(lavaGame.camera.combined);

        labelFont.draw(lavaGame.batch, welcomeTxt, 1350, 750, (int)(LavaGame.width / 4), Align.center, true);
        lavaGame.batch.end();

        lavaGame.batch.begin();
        stage.draw();
        lavaGame.batch.end();

    }

    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }
    private void initButtons() {
        easyButton = new GameButton("image/easy.png", 1220, 700, 400, 400);
        easyButton.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                lavaGame.level = new Level("Kaczucha", 100, 250,0.3);
                modelManager.init(lavaGame.level);
                lavaGame.changeViewToGameplay();
                return super.touchDown(event, x, y, pointer, button);
            }
        });

        Gdx.input.setInputProcessor(stage);
        stage.addActor(easyButton.getButton());




        hardButton = new GameButton("image/Hard.png", 1550, 700, 400, 400);
        hardButton.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                lavaGame.level = new Level("Player", 70, 350, 0.1);
                modelManager.init(lavaGame.level);
                lavaGame.changeViewToGameplay();
                return super.touchDown(event, x, y, pointer, button);
            }
        });

        Gdx.input.setInputProcessor(stage);
        stage.addActor(hardButton.getButton());


        soundButton = new GameButton("image/sound.png", 1500, 300, 200, 200);
        soundButton.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                return super.touchDown(event, x, y, pointer, button);
            }
        });

        Gdx.input.setInputProcessor(stage);
        stage.addActor(soundButton.getButton());


    }



    BitmapFont labelFont = new BitmapFont();

    String welcomeTxt = "Welcome \r\n\n " +
            " Team Prymuski\r\n\n" +
            " Kasia&Beata\r\n" +
            " presents\r\n\n"  +
            " THE FLOOR IS LAVA\r\n\n"
            + "Year 2020 wasn't good for the humanity but it’s not the end of the catastrophes yet\r\n"
            + "It’s the begging of the end\r\n"
            + "Mother Earth’s deadliest volcano unleashed its anger\r\n"
            + "The only hope is to jump and run because THE FLOOR IS LAVA";
}
