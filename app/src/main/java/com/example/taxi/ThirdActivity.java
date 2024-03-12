package com.example.taxi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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