package com.tuomasjar.pointcalculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity {
    private Button startButton,resetButton;
    private Switch redSwitch,blackSwitch,greenSwitch,blueSwitch,yellowSwitch,eurooppa;
    private LinearLayout start,game,blackPlay,bluePlay,greenPlay,redPlay,yellowPlay,lastRound;
    private Player Red,Green,Blue,Yellow,Black;
    private TextView blackCars, blueCars, greenCars, redCars,yellowCars;
    private TextView blackCurrent, blueCurrent, greenCurrent, redCurrent,yellowCurrent;
    private TextView blackPoints, bluePoints, greenPoints, redPoints,yellowPoints;
    private SeekBar blackBar,blueBar,redBar,greenBar,yellowBar;
    private boolean finalRound=false,europe;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton=findViewById(R.id.startButton);
        redSwitch = findViewById(R.id.redPlayer);
        blackSwitch = findViewById(R.id.blackPlayer);
        blueSwitch = findViewById(R.id.bluePlayer);
        yellowSwitch = findViewById(R.id.yellowPlayer);
        greenSwitch = findViewById(R.id.greenPlayer);
        eurooppa = findViewById(R.id.eurooppaSwitch);

        start = findViewById(R.id.starter);
        game = findViewById(R.id.game);

        blackCars = findViewById(R.id.blackCars);
        blueCars = findViewById(R.id.blueCars);
        greenCars = findViewById(R.id.greenCars);
        redCars = findViewById(R.id.redCars);
        yellowCars = findViewById(R.id.yellowCars);

        blackCurrent = findViewById(R.id.blackCurrent);
        blueCurrent = findViewById(R.id.blueCurrent);
        greenCurrent = findViewById(R.id.greenCurrent);
        redCurrent = findViewById(R.id.redCurrent);
        yellowCurrent = findViewById(R.id.yellowCurrent);

        blackPoints = findViewById(R.id.blackPoints);
        bluePoints = findViewById(R.id.bluePoints);
        greenPoints = findViewById(R.id.greenPoints);
        redPoints = findViewById(R.id.redPoints);
        yellowPoints = findViewById(R.id.yellowPoints);

        blackBar = findViewById(R.id.blackSeek);
        blueBar = findViewById(R.id.blueSeek);
        greenBar = findViewById(R.id.greenSeek);
        redBar = findViewById(R.id.redSeek);
        yellowBar = findViewById(R.id.yellowSeek);

        lastRound = findViewById(R.id.lastRound);
        resetButton = findViewById(R.id.resetButton);
        game.setVisibility(View.GONE);
        start.setVisibility(View.VISIBLE);

        blackPlay = findViewById(R.id.blackPlay);
        bluePlay = findViewById(R.id.bluePlay);
        greenPlay = findViewById(R.id.greenPlay);
        redPlay = findViewById(R.id.redPlay);
        yellowPlay = findViewById(R.id.yellowPlay);

        startButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                boolean red,blue,black,green,yellow,moveOn;
                moveOn=false;
                red = redSwitch.isChecked();
                blue = blueSwitch.isChecked();
                green = greenSwitch.isChecked();
                yellow = yellowSwitch.isChecked();
                black = blackSwitch.isChecked();
                europe = eurooppa.isChecked();

                if(red){
                    Red = new Player();
                    moveOn=true;
                }
                if(blue){
                    Blue = new Player();
                    moveOn=true;
                }
                if(black){
                    Black = new Player();
                    moveOn=true;
                }
                if(yellow){
                    Yellow = new Player();
                    moveOn = true;
                }
                if(green){
                    Green = new Player();
                    moveOn = true;
                }
                if(moveOn){
                    start.setVisibility(View.GONE);
                    game.setVisibility(View.VISIBLE);
                    if(red){
                        redPlay.setVisibility(View.VISIBLE);
                    }else{
                        redPlay.setVisibility(View.GONE);
                    }
                    if(black){
                        blackPlay.setVisibility(View.VISIBLE);
                    }else{
                        blackPlay.setVisibility(View.GONE);
                    }
                    if(blue){
                        bluePlay.setVisibility(View.VISIBLE);
                    }else{
                        bluePlay.setVisibility(View.GONE);
                    }
                    if(green){
                        greenPlay.setVisibility(View.VISIBLE);
                    }else{
                        greenPlay.setVisibility(View.GONE);
                    }
                    if(yellow){
                        yellowPlay.setVisibility(View.VISIBLE);
                    }else{
                        yellowPlay.setVisibility(View.GONE);
                    }
                    lastRound.setVisibility(View.GONE);
                    updateTexts();
                    alustaPelaajat();

                }
            }
        });


    }
    protected void alustaPelaajat(){
        if(Black != null){
            if(!europe){
                blackBar.setMax(6);
            }else {
                blackBar.setMax(7);
            }
        blackBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int progr=progress;
                if(progr==7)progr++;
                String arvo = String.valueOf(progr);
                blackCurrent.setText(arvo);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if(Black != null){
                    int progr = blackBar.getProgress();
                    if(progr==7)progr++;
                    Black.useCars(progr);
                    updateTexts();
                    blackBar.setProgress(0);
                }
            }
        });
        }
        if(Blue != null){
            if(!europe){
                blueBar.setMax(6);
            }else {
                blueBar.setMax(7);
            }
        blueBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int progr=progress;
                if(progr==7)progr++;
                String arvo = String.valueOf(progr);
                blueCurrent.setText(arvo);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int progr = blueBar.getProgress();
                if(progr==7)progr++;
                Blue.useCars(progr);
                updateTexts();
                blueBar.setProgress(0);
            }
        });
        }
        if(Red != null){
            if(!europe){
                redBar.setMax(6);
            }else {
                redBar.setMax(7);
            }
            redBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    int progr=progress;
                    if(progr==7)progr++;
                    String arvo = String.valueOf(progr);
                    redCurrent.setText(arvo);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    int progr = redBar.getProgress();
                    if(progr==7)progr++;
                    Red.useCars(progr);
                    updateTexts();
                    redBar.setProgress(0);
                }
            });
        }
        if(Green != null){
            if(!europe){
                greenBar.setMax(6);
            }else {
                greenBar.setMax(7);
            }
            greenBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    int progr=progress;
                    if(progr==7)progr++;
                    String arvo = String.valueOf(progr);
                    greenCurrent.setText(arvo);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    int progr = greenBar.getProgress();
                    if(progr==7)progr++;
                    Green.useCars(progr);
                    updateTexts();
                    greenBar.setProgress(0);
                }
            });
        }
        if(Yellow != null){
            if(!europe){
                yellowBar.setMax(6);
            }else {
                yellowBar.setMax(7);
            }
            yellowBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    int progr=progress;
                    if(progr==7)progr++;
                    String arvo = String.valueOf(progr);
                    yellowCurrent.setText(arvo);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    int progr = yellowBar.getProgress();
                    if(progr==7)progr++;
                    Yellow.useCars(progr);
                    updateTexts();
                    yellowBar.setProgress(0);
                }
            });
        }
    }

    protected void updateTexts(){
        if(Black != null){
            String teksti = "Vaunuja:"+String.valueOf(Black.getCars());
            blackCars.setText(teksti);
            String toinen = "Pisteitä:"+String.valueOf(Black.getPoints());
            blackPoints.setText(toinen);
            if(Black.getCars() <= 2){
                finalRound=true;
            }
        }
        if(Blue != null){
            String teksti = "Vaunuja:"+String.valueOf(Blue.getCars());
            blueCars.setText(teksti);
            String toinen = "Pisteitä:"+String.valueOf(Blue.getPoints());
            bluePoints.setText(toinen);
            if(Blue.getCars()<=2){
                finalRound=true;
            }
        }
        if(Green != null){
            String teksti = "Vaunuja:"+String.valueOf(Green.getCars());
            greenCars.setText(teksti);
            String toinen = "Pisteitä:"+String.valueOf(Green.getPoints());
            greenPoints.setText(toinen);
            if(Green.getCars()<=2){
                finalRound=true;
            }
        }
        if(Red != null){
            String teksti = "Vaunuja:"+String.valueOf(Red.getCars());
            redCars.setText(teksti);
            String toinen = "Pisteitä:"+String.valueOf(Red.getPoints());
            redPoints.setText(toinen);
            if(Red.getCars()<=2){
                finalRound=true;
            }
        }
        if(Yellow != null){
            String teksti = "Vaunuja:"+String.valueOf(Yellow.getCars());
            yellowCars.setText(teksti);
            String toinen = "Pisteitä:"+String.valueOf(Yellow.getPoints());
            yellowPoints.setText(toinen);
            if(Yellow.getCars()<=2){
                finalRound=true;
            }
        }
        if(finalRound){
            lastRound.setVisibility(View.VISIBLE);
            resetButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    game.setVisibility(View.GONE);
                    start.setVisibility(View.VISIBLE);
                    finalRound=false;
                    eurooppa.setChecked(false);
                    redSwitch.setChecked(false);
                    blackSwitch.setChecked(false);
                    blueSwitch.setChecked(false);
                    greenSwitch.setChecked(false);
                    yellowSwitch.setChecked(false);



                }
            });
        }

    }
}