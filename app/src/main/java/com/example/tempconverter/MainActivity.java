package com.example.tempconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText userInput;
    private Button conversionButton;
    private TextView result;
    private RadioButton cels;
    private RadioButton farh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = (EditText) findViewById(R.id.inputText);;
        conversionButton = (Button) findViewById(R.id.convertButton);
        result = (TextView) findViewById(R.id.outputText);

        cels = (RadioButton) findViewById(R.id.radioCelsius);
        farh = (RadioButton) findViewById(R.id.radioFahrenheight);

        View.OnClickListener robsListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(cels.isChecked() == true)
                        convertToCels();
                    else
                        convertToFahr();
            }
        };
        conversionButton.setOnClickListener(robsListener);



    }

    private void convertToCels() {
       double temp = Double.parseDouble(userInput.getText().toString());
       temp = (temp * 1.8) + 32;
       temp *= 100;
       temp = (int)temp;
       temp = (double)temp;
       temp /= 100;
       result.setText(temp + " F");
    }

    private void convertToFahr() {
        double temp = Double.parseDouble(userInput.getText().toString());
        temp = (temp-32)/1.8;
        temp *= 100;
        temp = (int)temp;
        temp = (double)temp;
        temp /= 100;
        result.setText(temp + " C");
    }



}