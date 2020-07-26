package com.mygdx.game.model;

import java.util.ArrayList;
import java.util.List;

public class Points {


  //przekazanmie przez model do looser/winner view i print
    //nowe okno po rozgrywce?

 List<Points> highScore = new ArrayList<Points>();
 

    private int points;


    public Points(int points) {
        ;
        this.points = points;
    }

    public void pointsAdd() {
        points = points - 100;
    }


    public void addBonusExit() {
        points = points + 5000;
    }

    public int getPoints() {
        return points;
    }
}
