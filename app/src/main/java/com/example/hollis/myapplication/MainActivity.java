package com.example.hollis.myapplication;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements FragmentRobot.RobotFightListener {
    TextView textView;
    FragmentRobot fragmentRobot1;
    FragmentRobot fragmentRobot2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.winner_text);
        initializeRobotFragment();
        initializeRobotFragment2();
    }



    public void initializeRobotFragment(){
        //instantiate a robotfragment
        fragmentRobot1 = new FragmentRobot();

        //Create our fragment manager to manage our fragments and transactions
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_1, fragmentRobot1);
        fragmentRobot1.setPosition(1);
        fragmentTransaction.commit();
    }
    public void initializeRobotFragment2(){
        //instantiate a robotfragment
        fragmentRobot2 = new FragmentRobot();

        //Create our fragment manager to manage our fragments and transactions
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_2, fragmentRobot2);
        fragmentRobot2.setPosition(2);
        fragmentTransaction.commit();
    }

    @Override
    public void fightRobots(Robot robot, int position){
        System.out.println(robot.getHealth() + " and position is: " + position);
        if(position ==1){
            fragmentRobot2.fightRobot(robot);
        }else{
            fragmentRobot1.fightRobot(robot);
        }
    }

    @Override
    public void setWinner(int position) {
        if(position==1) {
            textView.setText("Winner is: " + 2);
        }else{
            textView.setText("Winner is: " + 1);
        }
        fragmentRobot1.disableButton();
        fragmentRobot2.disableButton();
    }
}
