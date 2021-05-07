package com.tuomasjar.pointcalculator;

import android.graphics.Color;

public class Player {
   private int points,cars;


    public Player() {
        this.cars=45;
        this.points=0;
    }



    public int useCars(int usedCars){
        if(usedCars>cars)return 0;

        switch(usedCars){
            case 1:
                points++;
                cars--;
                break;
            case 2:
                points+=2;
                cars-=2;
                break;
            case 3:
                points+=4;
                cars-=3;
                break;
            case 4:
                points+=7;
                cars-=4;
                break;
            case 5:
                points+=10;
                cars-=5;
                break;
            case 6:
                points+=15;
                cars-=6;
                break;
            case 8:
                points+=21;
                cars-=8;
                break;
            default:
                return 0;
        }
        return points;
    }
    public int getPoints(){
        return points;
    }

    public int getCars(){
        return cars;
    }


}
