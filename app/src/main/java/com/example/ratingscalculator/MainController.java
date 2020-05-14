package com.example.ratingscalculator;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.RouterTransaction;

public class MainController extends Controller implements RatingsCallback {

    private Button startButton;
    private TextView tvResult;

    public MainController() {

    }

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.main_controller, container, false);
        startButton = view.findViewById(R.id.start_btn);
        tvResult = view.findViewById(R.id.tv_result);
        initListener();
        return view;
    }

    private void initListener() {
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchController();
            }
        });
    }

    private void launchController() {
        RatingsController controller = new RatingsController();
        controller.registerCallback(this);
        getRouter().pushController(RouterTransaction.with(controller));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onRatingsCompleted(String result) {
        startButton.setVisibility(View.GONE);
        tvResult.setVisibility(View.VISIBLE);
        tvResult.setText(getResources().getString(R.string.final_ratings) + result);
    }

}
