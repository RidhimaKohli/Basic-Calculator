package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
   TextView num3;
   EditText num1;
    EditText num2;
   Button add,sub,multiply,div;
    double number3,number1,number2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1=(EditText)findViewById(R.id.num1); //input1
        num2=(EditText)findViewById(R.id.num2); //input2
        num3=(TextView)findViewById(R.id.num3); //ouput
        //buttons
        add=(Button)findViewById(R.id.add);
        sub=(Button)findViewById(R.id.sub);
        multiply=(Button)findViewById(R.id.multiply);
        div=(Button)findViewById(R.id.div);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 number1=Double.parseDouble(num1.getText().toString());
                 number2=Double.parseDouble(num2.getText().toString());
                 number3=number1+number2;
                 num3.setText(String.valueOf(number3));
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1=Double.parseDouble(num1.getText().toString());
                number2=Double.parseDouble(num2.getText().toString());
                number3=number1-number2;
                num3.setText(String.valueOf(number3));
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1=Double.parseDouble(num1.getText().toString());
                number2=Double.parseDouble(num2.getText().toString());
                number3=number1*number2;
                num3.setText(String.valueOf(number3));
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1=Double.parseDouble(num1.getText().toString());
                number2=Double.parseDouble(num2.getText().toString());
                if(number2!=0){
                    number3=number1/number2;
                    num3.setText(String.valueOf(number3));
                }
                else{
                    num3.setText("ERROR"); //divide  by zero
                }

            }
        });
    }

}