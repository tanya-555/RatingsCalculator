package com.example.ratingscalculator;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.bluelinelabs.conductor.Conductor;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;

public class MainActivity extends AppCompatActivity {

    private Router router;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        router = Conductor.attachRouter(MainActivity.this, (ViewGroup) findViewById(R.id.router), savedInstanceState);
        launchController();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void launchController() {
        if (!router.hasRootController()) {
            router.pushController(RouterTransaction.with(new MainController()));
        }
    }
}
