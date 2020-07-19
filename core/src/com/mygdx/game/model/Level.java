package com.mygdx.game.model;

public class Level {

    public String playerImageFilename;
    public int numberOfSafeFields;
    public int minimalDistanceBetweenFields;
    public double timeToDestroy;

    public Level(String playerImageFilename,
                 int numberOfSafeFields,
                 int minimalDistanceBetweenFields,
                 double timeToDestroy) {

        this.playerImageFilename = playerImageFilename;
        this.numberOfSafeFields = numberOfSafeFields;
        this.minimalDistanceBetweenFields = minimalDistanceBetweenFields;
        this.timeToDestroy = timeToDestroy;
    }
}
