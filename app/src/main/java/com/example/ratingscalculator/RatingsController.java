package com.example.ratingscalculator;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.bluelinelabs.conductor.Controller;

public class RatingsController extends Controller {

    private SeekBar foodRatings;
    private SeekBar serviceRatings;
    private SeekBar ambienceRatings;
    private Button doneButton;
    private int fRatings = 0;
    private int sRatings = 0;
    private int aRatings = 0;
    private RatingsCallback callback;

    public RatingsController() {

    }

    public RatingsController(RatingsCallback callback) {
        this.callback = callback;
    }

    public void registerCallback(RatingsCallback callback) {
        this.callback = callback;
    }

    @NonNull
    @Override
    protected View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(R.layout.ratings_controller, container, false);
        foodRatings = view.findViewById(R.id.food_rating);
        serviceRatings = view.findViewById(R.id.service_rating);
        ambienceRatings = view.findViewById(R.id.ambience_rating);
        doneButton = view.findViewById(R.id.done_btn);
        initRatingsListener();
        initButtonListener();
        return view;
    }

    private void initRatingsListener() {
        foodRatings.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                fRatings = progress;
                Toast.makeText(getActivity(), String.valueOf(progress), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        serviceRatings.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sRatings = progress;
                Toast.makeText(getActivity(), String.valueOf(progress), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        ambienceRatings.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                aRatings = progress;
                Toast.makeText(getActivity(), String.valueOf(progress), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void initButtonListener() {
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = calculateAverageRatings();
                removeController();
                callback.onRatingsCompleted(result);
            }
        });
    }

    private String calculateAverageRatings() {
        return String.valueOf((fRatings + aRatings + sRatings) / 3);
    }

    private void removeController() {
        if (getRouter().hasRootController()) {
            getRouter().popController(this);
        }
    }

}
