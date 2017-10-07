package com.example.bmicalculator;

import android.content.Intent;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText HeightEditText, WeightEditText;
    private Button CalculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HeightEditText = (EditText) findViewById(R.id.height_edit_text);
        WeightEditText = (EditText) findViewById(R.id.weight_edit_text);
        CalculateButton = (Button) findViewById(R.id.calculate_button);

        CalculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double height = Double.valueOf(HeightEditText.getText().toString());
                Double weight = Double.valueOf(WeightEditText.getText().toString());

                Double bmi = weight / ((height/100) * (height/100));
                String bmiText = getBmiText(bmi);

                Intent intent = new Intent((MainActivity.this),BmiResult.class);
                intent.putExtra("bmi_value",bmi);
                intent.putExtra("bmi_text",bmiText);
                startActivity(intent);
            }
        });
    }

        private String getBmiText(Double bmi){
            String bmiText = "";
            if(bmi < 18.5){
                bmiText = "น้ำหนักน้อยกว่าปกติ";
            }else if(bmi < 25){
                bmiText = "น้ำหนักปกติ";
            }else if (bmi < 30){
                bmiText = "น้ำหนักมากกว่าปกติ (ท้วม)";
            }else {
                bmiText = "น้ำหนักมากกว่าปกติมาก(อ้วน)";
            }
            return bmiText;
        }
}
