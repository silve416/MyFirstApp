package com.example.maxwell.myfirstapp;

import java.sql.Array;

/**
 * Created by Maxwell on 9/27/2017.
 */

public class Model implements Components.Model {
    int count;
    int progress;
    int time;
    int[] score;
    int l;
    private Components.Presenter mpresenter;

    public Model(Components.Presenter present){
        mpresenter = present;
        count = 0;
        progress = 0;// tie in progress with time in case I want to make them seperate
        time = 0;
        score = new int[10];
        l = 0;
    }

    public int isCount() {
        return this.count;
    }

    public boolean incCount(){
        this.count++;
        return true;
    }

    public void setCount(int j){
        this.count = j;
    }

    public void saveCount(){
        this.score[l] = this.count;
        l++;
    }

    public int getScoreAt(int i){
        return this.score[i];
    }

    public int isProgress(){
        return this.progress;
    }

    public int isTime(){
        return this.time;
    }

    public void setTime(int i){
        this.time = i;
    }

    public void setProgress(int i){
        this.progress = i;
        }
    }
    //MORE CODE HERE

