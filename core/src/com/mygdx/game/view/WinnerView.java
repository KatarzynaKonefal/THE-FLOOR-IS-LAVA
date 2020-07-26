package com.mygdx.game.view;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.LavaGame;
import com.mygdx.game.controller.IGameController;
import com.mygdx.game.model.IModelManager;

public class WinnerView extends GameplayView {

    protected Stage stage;

    BitmapFont labelFont = new BitmapFont();

    String highScore;
    //przekazanie najlepszych wartosci

    String winningText = " YES MY LORD\n" +
            "    YES YOU DID IT\n" +
            "We hope you had as much fun as we did when writing this code!\n"+
            "POINT RESULT: " +
            modelManager.getPoints();

    public WinnerView(LavaGame lavaGame, IGameController controller, IModelManager modelManager) {
        super(lavaGame, controller, modelManager);
        stage = new Stage(new StretchViewport(LavaGame.width, LavaGame.height, lavaGame.camera));
        initButtons();
    }
    @Override
    public void show() {
        initButtons();
    }

    @Override
    public void render(float deltaTime) {
        super.render(deltaTime);

        lavaGame.batch.begin();

        stage.draw();
        modelManager.getWinner().draw(lavaGame.batch);
        lavaGame.batch.end();


        lavaGame.batch.begin();
        modelManager.getWinner().draw(lavaGame.batch);
        labelFont.draw(lavaGame.batch,
                winningText,
                modelManager.getPlayer().x + modelManager.getPlayer().width + 50,
                modelManager.getPlayer().y +modelManager.getPlayer().height + 50,
                (int)(LavaGame.width / 4),
                Align.center,
                true);


        lavaGame.batch.end();


    }

    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }

    private void initButtons() {
        GameButton exitButton = new GameButton("image/exit.png",
                modelManager.getPlayer().x + modelManager.getPlayer().width,
                modelManager.getPlayer().y + modelManager.getPlayer().height,
                300,
                250);

        exitButton.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                lavaGame.exit();
                return super.touchDown(event, x, y, pointer, button);
            }
        });

        Gdx.input.setInputProcessor(stage);
        stage.addActor(exitButton.getButton());

        GameButton playAgainButton = new GameButton("image/start.png",
                modelManager.getPlayer().x + modelManager.getPlayer().width + 300,
                modelManager.getPlayer().y + modelManager.getPlayer().height,
                300,
                250);

        playAgainButton.addListener(new ClickListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                lavaGame.reinitializeGame();
                return super.touchDown(event, x, y, pointer, button);
            }
        });

        Gdx.input.setInputProcessor(stage);
        stage.addActor(playAgainButton.getButton());


    }


}
