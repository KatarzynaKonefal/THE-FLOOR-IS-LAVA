package com.mygdx.game.model;

        import com.badlogic.gdx.audio.Music;
        import com.badlogic.gdx.graphics.Texture;
        import java.util.List;
        import java.util.TreeSet;

public interface IModelManager {

    LavaPlayer getPlayer();

    List<SafeField> getSafeFields();

    Points getPoints();

    Exit getExitField();

    Texture getBackground();

    Fire getFire();

    void init(Level level);

    Winner getWinner();

    Music getGameMusic();

    void addNewScore();

    List<Points> getHighScore();

}
