package com.mygdx.game.view;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.game.LavaGame;
import com.mygdx.game.controller.IGameController;
import com.mygdx.game.model.IModelManger;

public class WinnerView extends GameplayView {

    protected Stage stage;

    public WinnerView(LavaGame lavaGame, IGameController controller, IModelManger modelManager) {
        super(lavaGame, controller, modelManager);
        stage = new Stage(new StretchViewport(LavaGame.width, LavaGame.height, lavaGame.camera));
        initButtons();
    }
    private void initButtons() {
    }
    protected void init() {
    }
    //again
    //tablica wynikow
    //YES MY LORD
    //yES YOU DID IT
//	We hope you had as much fun as we did when writing this code!
}
