package com.example.hollis.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Robot mrRoboto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        intializeRobot();

    }

    public void initializeViews(){
        TextView textView = findViewById(R.id.robot);
        setRobotText();
    };

    public void initializeRobot(){
        Robot mrRoboto = new Robot();
    }

    public void setRobotText(){
        if(mrRoboto.isMurderer()){
            textView.setText("Run!");
        }else{
            textView.setText("Don't Run!");
        }
    }
}
