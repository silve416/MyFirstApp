package com.example.maxwell.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.CollationElementIterator;

import static com.example.maxwell.myfirstapp.R.id.text;
import static com.example.maxwell.myfirstapp.R.id.textView2;

public class DisplayMessageActivity extends AppCompatActivity implements Components.View{

    Presenter present;
    private static final String TAG = "DisplayMessageActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        setupComponentPresenter();

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message);

        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(Integer.toString(present.getCount()));//present.getCount());
        Log.d(TAG, "in onCreate Method");
    }

    public void setupComponentPresenter(){
        present = new Presenter(this);
        Log.d(TAG, "in setupComponentPresenter Method");
    }

    public void onClick(View view){
        present.incCount();

        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(Integer.toString(present.getCount()));
        Log.d(TAG, "in onClick Method");
    }

    public void startGame(View view){
        Intent intent = new Intent(this, ClickerGameActivity.class);
        startActivity(intent);
        Log.d(TAG, "in startGame Method");
    }

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
//public class DisplayMessageActivity extends AppCompatActivity {
//    private int count = 0;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_display_message);
//
//        // GET THE INTENT THAT STARTED THIS ACTIVITY AND EXTRACT THE STRING
//        Intent intent = getIntent();
//        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
//
//        //  CAPTURE THE LAYOUT'S TEXTVIEW AND SET THE STRING AS ITS TEXT
//        TextView textView = (TextView) findViewById(R.id.textView);
//        textView.setText(message);
//
//        TextView textView2 = (TextView) findViewById(R.id.textView2);
//        textView2.setText(Integer.toString(count));
//    }
//
//    public void onClick(View view){
//        count++;
//        setCounter(Integer.toString(count));
//    }
//
//    public void setCounter(String numVal){
//       TextView textView2 = (TextView) findViewById(R.id.textView2);
//        textView2.setText(numVal);
//    }
//}
