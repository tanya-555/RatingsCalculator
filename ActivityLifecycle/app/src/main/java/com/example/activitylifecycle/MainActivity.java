package com.example.activitylifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getName();
    Button launchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        launchBtn = findViewById(R.id.launch_btn);
        Toast.makeText(getApplicationContext(), "First Activity Created", Toast.LENGTH_LONG).show();
        Log.d(TAG, "First Activity Created");
        initListener();
    }

    private void initListener() {
        launchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "First Activity Started", Toast.LENGTH_LONG).show();
        Log.d(TAG, "First Activity Started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "First Activity Resumed", Toast.LENGTH_LONG).show();
        Log.d(TAG, "First Activity Resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "First Activity Paused", Toast.LENGTH_LONG).show();
        Log.d(TAG, "First Activity Paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "First Activity Stopped", Toast.LENGTH_LONG).show();
        Log.d(TAG, "First Activity Stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "First Activity Destroyed", Toast.LENGTH_LONG).show();
        Log.d(TAG, "First Activity Destroyed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "First Activity Restarted", Toast.LENGTH_LONG).show();
        Log.d(TAG, "First Activity Restarted");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
