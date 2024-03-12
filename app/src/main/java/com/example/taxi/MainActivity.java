package com.example.taxi;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.taxi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private static final String TAG = "MainActivity"; // Tag for logging
    SharedPreferences sPref;
    final String keyName = "phoneNumber";
    final String keyName2 = "name";
    final String keyName3 = "Surname";


    private void saveText() {
        sPref = getPreferences(MODE_PRIVATE); //MODE_PRIVATE - privacy settings, after using it, data will be available only for this app
        SharedPreferences.Editor editor = sPref.edit();
        //adding data that can be saved
        editor.putString(keyName, binding.pn.getText().toString());
        editor.putString(keyName2, binding.name.getText().toString());
        editor.putString(keyName3, binding.surname.getText().toString());

        editor.commit(); //saves data
        Log.d(TAG, "Saved data to SharedPreferences");
    }

    private void loadText() {
        sPref = getPreferences(MODE_PRIVATE);
        //extracting saved data

        String savedText = sPref.getString(keyName, "");
        binding.pn.setText(savedText); //output in the text field

        savedText = sPref.getString(keyName2, "");
        binding.name.setText(savedText); //output in the text field

        savedText = sPref.getString(keyName3, "");
        binding.surname.setText(savedText); //output in the text field
        Log.d(TAG, "Loaded data from SharedPreferences");
    }






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater()); //work with binding
        View view = binding.getRoot();
        setContentView(view);
        loadText();

        //creating an intent
        Intent intent = new Intent(this, SecondActivity.class);
        binding.btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("PhoneNumber",binding.pn.getText().toString()); //transferring PhoneNumber
                intent.putExtra("Name",binding.name.getText().toString()); //transferring Name
                intent.putExtra("Surname",binding.surname.getText().toString()); //transferring Surname
                startActivity(intent);
            }
        });

        if (sPref.contains("phoneNumber")){
            binding.btnReg.setText("LOG IN");
        }
        Log.d(TAG, "onCreate executed");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveText();
        Log.d(TAG, "onDestroy executed");
    }
}