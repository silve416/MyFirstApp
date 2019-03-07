package com.example.maxwell.myfirstapp;

/**
 * Created by Maxwell on 9/27/2017.
 */

public class Presenter implements Components.Presenter {
    private Components.Model pmodel;
    private Components.View pview;

    public Presenter(Components.View view){
        pview = view;
        pmodel = new Model(this);
    }

    public int getCount(){
        return pmodel.isCount();
    }

    public void incCount(){
        pmodel.incCount();
    }

    public void setCount(int j){
        pmodel.setCount(j);
    }

    public void saveCount(){
        pmodel.saveCount();
    }

    public int getScoreAt(int i){
        return pmodel.getScoreAt(i);
    }

    public int getProgress(){
        return pmodel.isProgress();
    }

    public int getTime(){
        return pmodel.isTime();
    }

    public void setTime(int i){
        pmodel.setTime(i);
    }

    public void setProgress(int i){
        pmodel.setProgress(i);
    }

    //MORE CODE HERE
}
