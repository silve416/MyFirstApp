package com.example.maxwell.myfirstapp;

/**
 * Created by Maxwell on 9/27/2017.
 */

public interface Components {
    interface View{
        //Methods that anything which implements the View must also implement
    }

    interface Model{
        public int isCount();
        public boolean incCount();
        public void setCount(int j);
        public void saveCount();
        public int isProgress();
        public void setProgress(int i);
        public int isTime();
        public void setTime(int l);
        public int getScoreAt(int k);
        //Model Methods that anything which implements the Model must also implement
    }

    interface Presenter{
        public int getCount();
        public void incCount();
        public void setCount(int j);
        public void saveCount();
        public int getProgress();
        public void setProgress(int i);
        public int getTime();
        public void setTime(int l);
        public int getScoreAt(int k);
        // Presenter Methods that anything which implements the Presenter must also implement
    }
}