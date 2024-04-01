package com.example.taxi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.example.taxi.databinding.ActivityMainBinding;
import com.example.taxi.databinding.ActivityThirdBinding;

public class ThirdActivity extends AppCompatActivity {
    private ActivityThirdBinding binding;

    private static final String TAG = "ThirdActivity"; // Tag for logging

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityThirdBinding.inflate(getLayoutInflater()); //work with binding
        View view = binding.getRoot();
        setContentView(view);

        Log.d(TAG, "onCreate ThirdActivity");

        EditText streetFromEditText = findViewById(R.id.StreetFrom);
        EditText houseFromEditText = findViewById(R.id.HouseFrom);
        EditText flatFromEditText = findViewById(R.id.FlatFrom);

        EditText streetToEditText = findViewById(R.id.StreetTo);
        EditText houseToEditText = findViewById(R.id.HouseTo);
        EditText flatToEditText = findViewById(R.id.FlatTo);

        //Creating an instance for playing music
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.music);

        //Getting link for SwitchCompat
        SwitchCompat soundSwitch = findViewById(R.id.btnSwitch);

        // Installing listeners
        streetFromEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                // Making sound when is typing
                mediaPlayer.start();
            }
        });

        houseFromEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mediaPlayer.start();
            }
        });


        flatFromEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                mediaPlayer.start();
            }
        });


        streetToEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                // Making sound when is typing
                mediaPlayer.start();
            }
        });

        houseToEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mediaPlayer.start();
            }
        });

        flatToEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                mediaPlayer.start();
            }
        });
        soundSwitch.setChecked(true);
        // Installing listener for SwitchCompat which will turn off/on sound
        soundSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Включить звук
                    mediaPlayer.start();
                } else {
                    // Отключить звук
                    mediaPlayer.stop();
                }
            }
        });

        binding.btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("StF",binding.StreetFrom.getText().toString()); //transferring Street From
                intent.putExtra("HoF",binding.HouseFrom.getText().toString()); //transferring House From
                intent.putExtra("FlF",binding.FlatFrom.getText().toString()); //transferring Flat From

                intent.putExtra("StT",binding.StreetTo.getText().toString()); //transferring Street To
                intent.putExtra("HoT",binding.HouseTo.getText().toString()); //transferring House To
                intent.putExtra("FlT",binding.FlatTo.getText().toString()); //transferring Flat To
                setResult(RESULT_OK,intent);
                Log.d(TAG, "finish ThirdActivity");
                finish();
            }
        });
    }


}