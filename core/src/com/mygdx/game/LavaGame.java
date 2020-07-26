package com.mygdx.game;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.controller.GameController;
import com.mygdx.game.controller.IGameController;
import com.mygdx.game.model.*;
import com.mygdx.game.view.GameplayView;
import com.mygdx.game.view.LooserView;
import com.mygdx.game.view.WelcomeView;
import com.mygdx.game.view.WinnerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LavaGame extends Game {

    public SpriteBatch batch;
    public OrthographicCamera camera;
    ShapeRenderer shapeRenderer;
    BitmapFont font;

    IGameController gameController;
    IModelManager modelManager;

    WelcomeView welcomeView;
    GameplayView gameplayView;
    WinnerView winnerView;
    LooserView looserView;

    static public int width;
    static public int height;

    public Level level;

    public boolean cameraRepositionIsEnable;

    public boolean soundIsOn;

    public Music gameMusic;


    public LavaGame(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void create() {
        camera = new OrthographicCamera(width, height);
        //camera.translate(width/2,height/2);
        camera.zoom = 1;
        cameraRepositionIsEnable = true;

        modelManager = new ModelManager(this);

        gameController = new GameController(this,
                modelManager);

        welcomeView = new WelcomeView(this, modelManager);
        gameplayView = new GameplayView(this, gameController, modelManager);

        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        font = new BitmapFont();
        soundIsOn = true;

        gameMusic = modelManager.getGameMusic();
        gameMusic.play();
        setScreen(welcomeView);
    }

    @Override
    public void dispose() {
        batch.dispose();
        shapeRenderer.dispose();
        font.dispose();
    }

    public void exit() {
        dispose();
        Gdx.app.exit();
    }

    public void changeViewToGameplay() {
        setScreen(gameplayView);
    }

    public void changeViewToLooser() {
        looserView = new LooserView(this, gameController, modelManager);
        setScreen(looserView);
    }

    public void changeViewToWinnerView() {
        winnerView  = new WinnerView(this, gameController, modelManager);
        setScreen(winnerView);
    }

    public void reinitializeGame() {
        modelManager.init(level);
        setScreen(gameplayView);
    }

    public void changeCameraViewToUser() {
        camera.position.set(modelManager.getPlayer().x + width/3,
                modelManager.getPlayer().y + height/3, 0);
        camera.zoom = 1;
        camera.update();
    }

    public String generateScoreTable(String endingInitialText) {
        StringBuilder scoreTable = new StringBuilder(endingInitialText);
        List<Points> rangList = new ArrayList<>(modelManager.getHighScore());
        Collections.reverse(rangList);

        for (Points highScore: rangList) {
            scoreTable.append(highScore);
            scoreTable.append("\n");
        }

        return scoreTable.toString();
    }


    public void pause(){}

    public void resume(){}

}
