package com.example.hollis.myapplication;

import java.util.Random;

/**
 * Created by hollis on 3/31/16.
 */
public class Robot {
    private int health;
    private boolean isMurderer;


    Robot(){
        health = new Random().nextInt(10) + 10;
    }

    public void punchRobot(Robot otherRobot){
        otherRobot.loseHealth();
    }

    public void loseHealth(){
        health-= new Random().nextInt(5);
    }

    public boolean isBroken(){
        return health<=0;
    }

    public int getHealth(){
        return health;
    }


}
