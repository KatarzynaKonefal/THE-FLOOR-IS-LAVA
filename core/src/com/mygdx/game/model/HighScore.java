package com.mygdx.game.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class HighScore {
    public List<Points> bestPlayers = new ArrayList<>();
    String fileName;

    public HighScore() {
        FileInputStream fileIn;
        fileName ="bestPlayers.ser";

        try {
            fileIn = new FileInputStream(fileName);
            try (ObjectInputStream inputStream = new ObjectInputStream(fileIn)) {
                bestPlayers = (ArrayList<Points>) inputStream.readObject();
            }
            fileIn.close();
        } catch (Exception e) {
            System.out.println("Previous high scores was not found in file: " + fileName);
        }
    }

    void addNewScore(Points points) {
        bestPlayers.add(points);
        Collections.sort(bestPlayers);
        if(bestPlayers.size() > 5) {
            bestPlayers.remove(0);
        }
        updateHighScoresFile();
    }

    void updateHighScoresFile() {
        FileOutputStream fileOut;

        try {
            fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(bestPlayers);
            out.close();
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
