package com.example.activitylifecycle;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = SecondActivity.class.getName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Toast.makeText(getApplicationContext(), "Second Activity Created", Toast.LENGTH_LONG).show();
        Log.d(TAG, "Second Activity Created");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "Second Activity Started", Toast.LENGTH_LONG).show();
        Log.d(TAG, "Second Activity Started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "Second Activity Resumed", Toast.LENGTH_LONG).show();
        Log.d(TAG, "Second Activity Resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "Second Activity Paused", Toast.LENGTH_LONG).show();
        Log.d(TAG, "Second Activity Paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "Second Activity Stopped", Toast.LENGTH_LONG).show();
        Log.d(TAG, "Second Activity Stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "Second Activity Destroyed", Toast.LENGTH_LONG).show();
        Log.d(TAG, "Second Activity Destroyed");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "Second Activity Restarted", Toast.LENGTH_LONG).show();
        Log.d(TAG, "Second Activity Restarted");
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
