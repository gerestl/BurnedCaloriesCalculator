package com.example.geres.burnedcaloriescalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TextView.OnEditorActionListener {


    private EditText weightET;
    private EditText milesET;
    private EditText caloriesET;
    private EditText bmiEt;
    private String weightString="";
    private SeekBar milesSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightET =(EditText) findViewById(R.id.weightET);
        milesET = (EditText) findViewById(R.id.milesET);
        caloriesET =(EditText) findViewById(R.id.caloriesET);
        bmiEt = (EditText) findViewById(R.id.bmiET);
        milesSeekBar.setOnSeekBarChangeListener(seekBarChangeListener);

    }

    @Override
    public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent){
        if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
            calculateAndDisplay();
        }
        return false;
    }
    private SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
            //
            milesET.setText(progress);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            calculateAndDisplay();
        }
    };

    private void calculateAndDisplay() {
        weightString = weightET.getText().toString();
        float weight;
        if(weightString.equals("")){
            weight = 0;
        }
        else{
            weight= Float.parseFloat(weightString);
        }
        int progress = milesSeekBar.getProgress();
       milesET.setText(progress);
        double caloriesBurned = 0.75 * weight * progress;
        



    }

}
