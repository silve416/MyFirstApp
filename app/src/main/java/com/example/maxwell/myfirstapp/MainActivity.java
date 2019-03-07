package com.example.maxwell.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private static final String TAG = "MainActivity";

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "in OnCreate Method");
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

    /** Called when the user taps the Send button */
    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
        Log.d(TAG, "in sendMessage Method");
    }
}
