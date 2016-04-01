package com.example.hollis.myapplication;

/**
 * Created by hollis on 3/31/16.
 */
public class Robot {
    private int speed;
    private boolean isMurderer;


    Robot(){
        int speed = 5;
        super();
    }
    public int speak (){
        System.out.println("BEEP BOOP I AM A ROBOT");
    }

    public destroyHuman(Human innocentCivilian){
        innocentCivilian.die();
        isMurderer = true;
    }

    public boolean isMurderer(){
        return isMurderer;
    };
}
