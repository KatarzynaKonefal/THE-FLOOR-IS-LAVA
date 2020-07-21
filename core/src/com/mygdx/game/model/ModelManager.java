package com.mygdx.game.model;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.LavaGame;

import java.util.ArrayList;
import java.util.List;

import static com.mygdx.game.model.SafeField.timeToDestroy;

public class ModelManager implements IModelManager {
    LavaGame lavaGame;
    private Assets assets;

    private LavaPlayer player;
    private List<SafeField> safeFields;
    private Exit exit;






    public ModelManager(LavaGame lavaGame) {
        this.lavaGame = lavaGame;

        assets = new Assets();
        assets.load();
        assets.manager.finishLoading();
    }

    @Override
    public LavaPlayer getPlayer() {
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
                new Position(player.x, player.y), assets.manager.get(assets.musicFilenamesMap.get("Looser"), Music.class));
    }

    @Override
    public Winner getWinner() {
        return new Winner(assets.manager.get(assets.textureFilenamesMap.get("Winner"), Texture.class),
                new Position(player.x - 200, player.y - 200));
    }



    @Override
    public int getPoints() {
        return 0;
    }


    @Override
    public void init(Level level) {

        // music.play();

;
        Texture background = getBackground();
        Position exitPosition = new Position(background.getWidth() - 2 * lavaGame.width / 3, background.getHeight() - lavaGame.height);

        exit = new Exit(assets.manager.get(assets.textureFilenamesMap.get("Exit"), Texture.class), exitPosition);

        Position playerStartPosition = new Position(-lavaGame.width / 3, -lavaGame.height / 3);

        player = new LavaPlayer(assets.manager.get(assets.textureFilenamesMap.get(level.playerImageFilename), Texture.class),
                assets.manager.get(assets.musicFilenamesMap.get("Jump"), Music.class),
                playerStartPosition);


        String baseSafeFieldIdentifier = "SafeFieldStage";
        List<Texture> textures = new ArrayList<>();


        for (int numberSafeFieldStage = 1; numberSafeFieldStage < 6; ++numberSafeFieldStage) {
            textures.add(assets.manager.get(assets.textureFilenamesMap.get(baseSafeFieldIdentifier + numberSafeFieldStage),
                    Texture.class));




        }
        timeToDestroy = level.timeToDestroy;
        SafeField.textures = textures;

        Position firstSafeFieldPosition = new Position(playerStartPosition.x,
                playerStartPosition.y - textures.get(0).getHeight() / 2);

        FieldGenerator fieldGenerator = new FieldGenerator(this, firstSafeFieldPosition);

        safeFields = fieldGenerator.generateFields(level.numberOfSafeFields, level.minimalDistanceBetweenFields);
    }


}

