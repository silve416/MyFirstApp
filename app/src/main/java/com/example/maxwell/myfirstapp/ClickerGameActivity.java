package com.example.maxwell.myfirstapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;

import static android.os.SystemClock.sleep;
import static com.example.maxwell.myfirstapp.R.id.text;
import static com.example.maxwell.myfirstapp.R.id.textView;
import static com.example.maxwell.myfirstapp.R.id.textView2;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.sql.Types.NULL;

public class ClickerGameActivity extends AppCompatActivity implements Components.View {
    private static final String TAG = "in ClickerGameActivity";

    Presenter present;
    CountDownTimer cTime;
    ProgressBar progressBar;
    Button button1;
    Button button2;
    TextView textView;
    ListView list;

    int i;
    int listnum;

    String[] clicks;

    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        i = 0;
        listnum = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clicker_game_activity);

        setupComponentPresenter();

        //Initialize views
        textView = (TextView) findViewById(R.id.textView4);
        textView.setText(Integer.toString(present.getCount()));

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setProgress(i);
        progressBar.setIndeterminate(false);

        button1 = (Button) findViewById(R.id.button5);
        button1.setVisibility(View.INVISIBLE);

        button2 = (Button) findViewById(R.id.button6);

        //initializes list view and handlers
        list = (ListView) findViewById(R.id.viewScores);

        clicks = new String[0];

        ArrayList<String> clickList = new ArrayList<String>();
        clickList.addAll( Arrays.asList(clicks));

        listAdapter = new ArrayAdapter<String>(this, R.layout.list_clicks, clickList);

        list.setAdapter(listAdapter);

        present.setTime(10);
    }

    public void setupComponentPresenter() {
        present = new Presenter(this);
    }

    public void setupCountDownTimer(){
        cTime = new CountDownTimer(present.getTime() * 1000, 1000) {
            int i = present.getProgress();

            @Override
            public void onTick(long millisUntilFinished) {
                i++;
                progressBar.setProgress((int) i * 100/((present.getTime() * 1000 /1000)));
                present.setProgress(i);
            }

            @Override
            public void onFinish() {
                button1.setEnabled(FALSE);
                button1.setVisibility(View.INVISIBLE);

                button2.setEnabled(TRUE);
                button2.setVisibility(View.VISIBLE);

                progressBar.setProgress(0);

                present.saveCount(); //Saves count to score array
                present.setProgress(0); //Resets progress bar to 0
                present.setCount(0); //Resets clilck count to 0
                textView.setText(Integer.toString(present.getCount()));

                populateScore(); //Adds click score to list view
            }
        };
    }

    public void startClick(View view) {
        button1.setVisibility(view.VISIBLE);
        button1.setEnabled(TRUE);

        button2.setEnabled(FALSE);
        button2.setVisibility(view.INVISIBLE);

        setupCountDownTimer();
        cTime.start();
    }

    public void onClick2(View view) {
        present.incCount();
        TextView textView = (TextView) findViewById(R.id.textView4);
        textView.setText(Integer.toString(present.getCount()));
        }

    public void populateScore(){
        listAdapter.add(Integer.toString(present.getScoreAt(listnum)));
        listnum++;
    }

    //TAGS
    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG, "in onStart Method");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "in onResume Method");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "in onRestart Method");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "in onPause Method");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "in onStop Method");
    }

}