package com.example.bmicalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class BmiResult extends AppCompatActivity {
    ImageView showImage;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_result);

        Intent intent = getIntent();
        Double bmi = intent.getDoubleExtra("bmi_value",0);
        String bmiText = intent.getStringExtra("bmi_text");
        String result = String.format("ค่า BMI ที่ได้คือ %.1f\n\nอยู่ในเกณฑ์ : %s",bmi,bmiText);
        String resulttext = result;
        showImage = (ImageView) findViewById(R.id.image);
        TextView v = (TextView)findViewById(R.id.result);
        v.setText(resulttext);
        getBmiImage(bmi);
    }
    private void getBmiImage(Double bmi){
        if(bmi < 18.5){
            showImage.setImageResource(R.drawable.bmi_underweight);
        }else if (bmi < 25){
            showImage.setImageResource(R.drawable.bmi_normal_weight);
        }else if (bmi < 30){
            showImage.setImageResource(R.drawable.bmi_overweight);
        }else {
            showImage.setImageResource(R.drawable.bmi_obesity);
        }
    }
}
