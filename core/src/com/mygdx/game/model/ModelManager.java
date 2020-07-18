package com.mygdx.game.model;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.LavaGame;

import java.util.ArrayList;
import java.util.List;

public class ModelManager implements IModelManger {
    LavaGame lavaGame;
    private Assets assets;

    private LavaPlayer player;
    private List<SafeField> safeFields;
    private Exit exit;

    private Music music;

    int numberOfSafeFields;

    public ModelManager(LavaGame lavaGame,
                        int numberOfSafeFields){
        this.lavaGame = lavaGame;
        this.numberOfSafeFields = numberOfSafeFields;

        assets = new Assets();
        assets.load();
        assets.manager.finishLoading();

        if (assets.manager.update()) {
            init();
        }

    }

    @Override
    public LavaPlayer getPlayer(){
        return player;
    }

    @Override
    public List<SafeField> getSafeFields() {
        return safeFields;
    }

    @Override
    public Exit getExitField() {
        return exit;
    }

    @Override
    public Texture getBackground() {
        return assets.manager.get(assets.textureFilenamesMap.get("ImageBackground"), Texture.class);
    }

    @Override
    public Fire getFire() {
        return new Fire(assets.manager.get(assets.textureFilenamesMap.get("Fire"), Texture.class),
                new Position(player.x, player.y));
    }

    private void init() {

        // music.play();

        Position exitPosition = new Position(1920, 300);

        exit = new Exit(assets.manager.get(assets.textureFilenamesMap.get("Exit"), Texture.class), exitPosition);

        Position playerStartPosition = new Position(-lavaGame.width/3, -lavaGame.height/3);

        player = new LavaPlayer(assets.manager.get(assets.textureFilenamesMap.get("Player"), Texture.class),
                                assets.manager.get(assets.soundFilename, Sound.class),
                                playerStartPosition);


        String baseSafeFieldIdentifier = "SafeFieldStage";
        List<Texture> textures = new ArrayList<>();
        for(int i = 1; i < 6; ++i) {
            textures.add(assets.manager.get(assets.textureFilenamesMap.get(baseSafeFieldIdentifier + i),
                                            Texture.class));
        }
        safeFields = new ArrayList<>();

        Position firstSafeFieldPosition = new Position(playerStartPosition.x + textures.get(0).getWidth()/2,
                                                       playerStartPosition.y - textures.get(0).getHeight()/2);
        safeFields.add(new SafeField(textures, firstSafeFieldPosition));

        for (int i = -1; i < numberOfSafeFields - 1; i++) {

//            s.x = MathUtils.random(lavaGame.width);
            safeFields.add(new SafeField(textures, new Position(200 * i, 200 * i)));

        }
    }
}
