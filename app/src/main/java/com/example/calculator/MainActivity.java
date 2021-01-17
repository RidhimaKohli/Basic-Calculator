package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.content.Context;

import android.util.Log;


public class MainActivity extends AppCompatActivity {
   TextView num3;
   EditText num1;
    EditText num2;
    protected LocationManager locationManager;
    protected LocationListener locationListener;
    protected Context context;
    TextView txtLat;
    String lat;
    String provider;
    protected String latitude,longitude;
    protected boolean gps_enabled,network_enabled;
   Button add,sub,multiply,div,sin,cos,tan,pow,log,sqrt,clear,location;
    double number3,number1,number2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1=(EditText)findViewById(R.id.num1); //input1
        num2=(EditText)findViewById(R.id.num2); //input2
        num3=(TextView)findViewById(R.id.num3); //output
        //buttons
        add=(Button)findViewById(R.id.add);
        sub=(Button)findViewById(R.id.sub);
        multiply=(Button)findViewById(R.id.multiply);
        div=(Button)findViewById(R.id.div);
        sin=(Button)findViewById(R.id.sin);
        cos=(Button)findViewById(R.id.cos);
        tan=(Button)findViewById(R.id.tan);
        pow=(Button)findViewById(R.id.pow);
        log=(Button)findViewById(R.id.log);
        sqrt=(Button)findViewById(R.id.sqrt);
        clear=(Button)findViewById(R.id.clear);
        location=(Button)findViewById(R.id.location);

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


        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1=Double.parseDouble(num1.getText().toString());
                number3=Math.sin(number1);
                num3.setText(String.valueOf(number3));
            }
        });

        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1=Double.parseDouble(num1.getText().toString());
                number3=Math.cos(number1);
                num3.setText(String.valueOf(number3));
            }
        });

        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1=Double.parseDouble(num1.getText().toString());
                number3=Math.tan(number1);
                num3.setText(String.valueOf(number3));
            }
        });

        pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1=Double.parseDouble(num1.getText().toString());
                number2=Double.parseDouble(num2.getText().toString());
                number3=Math.pow(number1,number2);
                num3.setText(String.valueOf(number3));
            }
        });
        //log num1 base num2
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1=Double.parseDouble(num1.getText().toString());
                number2=Double.parseDouble(num2.getText().toString());
                if((number1>0)&(number2>0)&(number2!=1)){
                    number3=(Math.log(number1))/(Math.log(number2));
                    num3.setText(String.valueOf(number3));
                }
                else {
                    num3.setText("Error");
                }

            }
        });

        sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number1=Double.parseDouble(num1.getText().toString());

                if((number1>=0)){
                    number3=(Math.sqrt(number1));
                    num3.setText(String.valueOf(number3));
                }
                else {
                    num3.setText("Error");
                }

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1.setText("");
                num2.setText("");
                num3.setText("");
            }
        });

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                txtLat = (TextView) findViewById(R.id.textview1);
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
            }
            @Override
            public void onLocationChanged(Location location) {
                txtLat = (TextView) findViewById(R.id.textview1);
                txtLat.setText("Latitude:" + location.getLatitude() + ", Longitude:" + location.getLongitude());
            }

            @Override
            public void onProviderDisabled(String provider) {
                Log.d("Latitude","disable");
            }

            @Override
            public void onProviderEnabled(String provider) {
                Log.d("Latitude","enable");
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                Log.d("Latitude","status");
            }
        });

    }

}



