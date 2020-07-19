package com.mygdx.game.view;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.LavaGame;
import com.mygdx.game.model.IModelManager;
import com.mygdx.game.model.Level;


public class WelcomeView extends ScreenAdapter {

    LavaGame lavaGame;
    IModelManager modelManager;

    protected Stage stage;
    private GameButton easyButton, hardButton;


    private Texture imageBackground, imageInstruction, startButton;

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

        labelFont.draw(lavaGame.batch, welcomeTxt, 1350, 600, (int)(LavaGame.width / 4), Align.center, true);
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
        easyButton = new GameButton("image/easy.png", 1400, 500, 400, 400);
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




        hardButton = new GameButton("image/Hard.png", 1350, 800, 400, 400);
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

    }



    BitmapFont labelFont = new BitmapFont();

    String welcomeTxt = "Welcome \r\n\n " +
            " Team Prymuski\r\n\n" +
            " Kasia&Beata\r\n" +
            " presents\r\n\n"  +
            " FLOOR IS LAVA\r\n\n"
            + "Year 2020 it wasn't good for humanity but is not the end of the catastrophs.\r\n"
            + "It is the begging of end.\r\n"
            + "The most dangerous and the biggest vulcano of the mother earth show in the end of july its anger.\r\n"
            + "The only hope is jump and run because THE FLOOR IS LAVA!";
}
