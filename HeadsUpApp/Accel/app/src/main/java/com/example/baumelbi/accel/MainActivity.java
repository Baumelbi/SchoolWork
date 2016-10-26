package com.example.baumelbi.accel;

import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends Activity implements SensorEventListener, Observer {
    private final double actionTheshold = 8.5;
    private final double unblockThreshold = 3.5;
    private TextView wordText, score, finalScore;
    private RelativeLayout background;
    private Sensor mySensor;
    private SensorManager SM;
    public boolean actionsAreBlocked = false;
    private HeadsUpModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create our SensorManager
        SM = (SensorManager) getSystemService(SENSOR_SERVICE);

        //Accelerometer Sensor
        mySensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        //Register sensor Listener
        SM.registerListener(this, mySensor, SensorManager.SENSOR_DELAY_NORMAL);

        //Assign our text views
        background = (RelativeLayout) findViewById(R.id.backgroundSetter);
        wordText = (TextView) findViewById(R.id.wordText);
        score = (TextView) findViewById(R.id.score);
        finalScore = (TextView) findViewById(R.id.finalScore);

        //instaniate the model
        model = new HeadsUpModel();
        model.startGame(0);
        model.addObserver(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //not in use
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        double zForce = event.values[2];

        if (zForce >= actionTheshold && !isBlocked())
            pass();
        else if (zForce <= -actionTheshold && !isBlocked())
            correct();
        else if (zForce < unblockThreshold && zForce > -unblockThreshold && isBlocked())
            unblock();
    }

    private boolean isBlocked() {
        return actionsAreBlocked;
    }

    private void unblock() {
        actionsAreBlocked = false;
    }

    private void correct() {
        model.correct();
        actionsAreBlocked = true;
    }

    private void pass() {
        model.pass();
        actionsAreBlocked = true;
        return;
    }

    @Override
    public void update(Observable observable, Object data) {
        String nextWord = model.getCurrentWord();
        int currentScore = model.getScore();

        if (nextWord == null) {
            actionsAreBlocked = true;
            background.setBackgroundColor(Color.parseColor("#FFFFEE01"));
            wordText.setText("GAME OVER!");
            finalScore.setText("Your Score Was: " + currentScore);
            score.setText("");
            return;
        }
        wordText.setText(nextWord);

        this.score.setText(currentScore + "");
    }
}
