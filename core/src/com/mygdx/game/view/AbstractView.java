//package com.mygdx.game.view;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.badlogic.gdx.scenes.scene2d.Stage;
//import com.badlogic.gdx.utils.viewport.StretchViewport;
//import com.mygdx.game.controller.GameController;
//
//public abstract class AbstractView implements Screen{
//
//
//
//
//
////	HelloView helloView;
////	LooserView looserView;
//
//    protected Stage stage;
//
//    protected OrthographicCamera camera;
//
//    protected SpriteBatch spriteBatch;
//
//
//
//    public AbstractView(GameController gameBoard) {
//        this.gameBoard = gameBoard;
//        createCamera();
//        stage = new Stage(new StretchViewport(LavaGame.width, LavaGame.height, camera));
//        spriteBatch = new SpriteBatch();
//        Gdx.input.setInputProcessor(stage);
//        init();
//    }
//
//    protected abstract void init();
//
//    private void createCamera() {
//        camera = new OrthographicCamera();
//        camera.setToOrtho(false, LavaGame.width, LavaGame.height);
//        camera.update();
//    }
//
//    @Override
//    public void render (float delta) {
//        clearSreen();
//        camera.update();
//        spriteBatch.setProjectionMatrix(camera.combined);
//
//    }
//
//    @Override
//    public void show() {
//        // TODO Auto-generated method stub
//
//    }
//
//    private void clearSreen() {
//        Gdx.gl.glClearColor(0/ 255f, 0 / 255f,0/ 255f, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//    }
//
//    @Override
//    public void resume() {
//        gameBoard.setPaused(false);
//    }
//
//    @Override
//    public void pause() {
//        gameBoard.setPaused(true);
//    }
//
//    @Override
//    public void hide() {
//
//    }
//
//    @Override
//    public void dispose() {
//        gameBoard.dispose();
//
//    }
//
//    @Override
//    public void resize(int width, int height) {
//        // TODO Auto-generated method stub
//
//    }
//}
