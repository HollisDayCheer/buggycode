package com.example.hollis.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by hollis on 3/31/16.
 */
public class FragmentRobot extends Fragment {
        RobotFightListener robotFightListener;
        Robot ourRobot;
        int position;
    TextView textView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        robotFightListener = (RobotFightListener) getActivity();
        ourRobot = new Robot();
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_robot,container, false);
        Button button = (Button) v.findViewById(R.id.fragment_robot_button);
        textView = (TextView) v.findViewById(R.id.fragment_robot_health);
        textView.setText(ourRobot.getHealth() + "");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                robotFightListener.fightRobots(ourRobot, position);
            }
        });
        return v;
    }

    public void setPosition(int position){
        this.position = position;
    }

    public int getPosition(){
        return position;
    }
    public interface RobotFightListener{
        void fightRobots(Robot robot, int position);
    }

    public void fightRobot(Robot otherRobot){
        otherRobot.punchRobot(ourRobot);
        textView.setText(ourRobot.getHealth() + "");
    }


}