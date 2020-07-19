package com.mygdx.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
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

public class LavaGame extends Game {

    public SpriteBatch batch;
    public OrthographicCamera camera;
    ShapeRenderer shapeRenderer;
    BitmapFont font;

    IGameController gameController;
    IModelManger modelManger;

    WelcomeView welcomeView;
    GameplayView gameplayView;
    WinnerView winnerView;
    LooserView looserView;

    static public int width;
    static public int height;

    public LavaGame(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void create() {
        camera = new OrthographicCamera(width, height);
        camera.zoom = 1;

        modelManger = new ModelManager(this,
                                       50);

        gameController = new GameController(this,
                                            modelManger,
                                            width,
                                            height);

        welcomeView = new WelcomeView(this);
        gameplayView = new GameplayView(this, gameController, modelManger);
        winnerView = new WinnerView(this, gameController, modelManger);

        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        font = new BitmapFont();
        setScreen(welcomeView);
//        setScreen(gameplayView);
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
        looserView = new LooserView(this, gameController, modelManger);
        setScreen(looserView);
    }

    public void changeViewToWelcomeView() {
        welcomeView = new WelcomeView(this);
        setScreen(welcomeView);
    }

    public void changeViewToWinnerView() {
        setScreen(winnerView);
    }
}
