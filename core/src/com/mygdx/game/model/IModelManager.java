package com.mygdx.game.model;

        import com.badlogic.gdx.graphics.Texture;
        import java.util.List;

public interface IModelManager {

    LavaPlayer getPlayer();

    List<SafeField> getSafeFields();

    int getPoints();

    Exit getExitField();

    Texture getBackground();

    Fire getFire();

    void init(Level level);

    Winner getWinner();


}
