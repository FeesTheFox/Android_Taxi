package com.example.taxi;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.example.taxi.databinding.ActivityMainBinding;
import com.example.taxi.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {
    private ActivitySecondBinding binding;

    private static final String TAG = "SecondActivity"; // Tag for logging
    ActivityResultLauncher<Intent> startThirdActivityForResult = registerForActivityResult
            (new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override
                        //handling result, that returned from SecondActivity
                        public void onActivityResult(ActivityResult result) { //ActivityResult result -
                            // object that gives info about executing the operation
                            if (result.getResultCode() == Activity.RESULT_OK) { //if the activity executed perfectly,
                                // then (RESULT_OK) -
                                // const, that checks if the Activity is executed
                                Intent intent = result.getData(); //result contains that are returned by Intent,
                                // this line extracts Intent
                                if (intent != null) { // if object intent is not null
                                    // from getStringExtra method,
                                    // "Name" - key for extracting the String
                                    binding.userPathText.setText("Taxi will arrive at " + intent.getStringExtra("StF")
                                            + ", " + intent.getStringExtra("HoF") + ", "
                                            + intent.getStringExtra("FlF") + " in 5 minutes and" + "\n" + "take you in " +
                                            intent.getStringExtra("StT")+ ", " + intent.getStringExtra("HoT") + ", " +
                                            intent.getStringExtra("FlT") + ". If you are agreed with terms. Click \n" +
                                            "Call Taxi");
                                    binding.btnCallTaxi.setEnabled(true);
                                }
                            } else { //if result of activity is not fine, then
                                binding.btnCallTaxi.setEnabled(false);
                            }
                        }
                    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater()); //work with binding
        View view = binding.getRoot();
        setContentView(view);

        binding.btnCallTaxi.setEnabled(false);


        Intent intent = getIntent();
        binding.userInfoText.setText(intent.getStringExtra("Name")+" " //extracting data from Main
                +intent.getStringExtra("Surname")+"\n"
                +intent.getStringExtra("PhoneNumber"));


        Log.d(TAG, "onCreate executed");


        Intent intent2 = new Intent("android.intent.action.ThirdActivity");
        binding.btnSetPath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startThirdActivityForResult.launch(intent2);

            }
        });

        binding.btnCallTaxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Taxi is coming, have a nice ride", Toast.LENGTH_SHORT).show();
            }
        });



    }




}