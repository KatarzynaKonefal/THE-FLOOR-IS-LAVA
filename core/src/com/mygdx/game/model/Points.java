package com.mygdx.game.model;
public class Points {


private int points;


public Points( int points){ ;
    this.points = points;
}

    public void calculatePoints() {
        points = points - 100;
    }


    public void addBonusExit() {
        points += 5000;
    }


//    public void setPoints() {
//    return; startPoints();
//    }
}