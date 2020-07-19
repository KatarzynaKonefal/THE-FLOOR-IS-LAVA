package com.mygdx.game.view;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.LavaGame;
import com.mygdx.game.controller.IGameController;
import com.mygdx.game.model.IModelManger;
import com.mygdx.game.model.SafeField;

public class GameplayView extends ScreenAdapter {
    protected LavaGame lavaGame;
    protected IGameController controller;
    protected IModelManger modelManager;

    private Music music;

    private Sprite imageBackgroundSprite;


    public GameplayView(LavaGame lavaGame, IGameController controller, IModelManger modelManager) {
        this.lavaGame = lavaGame;
        this.controller = controller;
        this.modelManager = modelManager;

        imageBackgroundSprite = new Sprite(this.modelManager.getBackground());
    }

//    @Override
//    public void show() {
////        initButtons();
//    }

    @Override
    public void render(float deltaTime) {
        Gdx.gl.glClearColor(0 / 255f, 0 / 255f, 0 / 255f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        controller.update();

//        Rectangle backgroundRectangle = imageBackgroundSprite.getBoundingRectangle();
        lavaGame.camera.position.set(modelManager.getPlayer().x + lavaGame.width/3,
                                     modelManager.getPlayer().y + lavaGame.height/3, 0);
        lavaGame.camera.update();

        lavaGame.batch.begin();
        lavaGame.batch.draw(imageBackgroundSprite, (int)(-lavaGame.width / 2),(int) (-lavaGame.height / 2));
        lavaGame.batch.setProjectionMatrix(lavaGame.camera.combined);

        for (SafeField s : modelManager.getSafeFields()) {
            s.draw(lavaGame.batch);
        }

        modelManager.getPlayer().draw(lavaGame.batch);

        modelManager.getExitField().draw(lavaGame.batch);

        lavaGame.batch.end();
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }
}
