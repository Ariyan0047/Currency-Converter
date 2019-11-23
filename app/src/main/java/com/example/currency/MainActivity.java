package com.example.currency;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import static android.R.id.input;
import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    float a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Switch switch1 = findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){

                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);

                }else{
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });
    }

    public void convertUsdToBdt()
    {
        EditText usd= (EditText) findViewById(R.id.usd);
        usd.setInputType(InputType.TYPE_CLASS_NUMBER);

        EditText  bdt=(EditText) findViewById(R.id.bdt);
        bdt.setInputType(InputType.TYPE_CLASS_NUMBER);

        double a=Integer.parseInt(usd.getText().toString());
        double result=a*85;
        bdt.setText(String.valueOf(result));

    }

    public  void convertBdtToUsd()
    {
        EditText usd= (EditText) findViewById(R.id.usd);
        usd.setInputType(InputType.TYPE_CLASS_NUMBER);
        EditText  bdt=(EditText) findViewById(R.id.bdt);
        bdt.setInputType(InputType.TYPE_CLASS_NUMBER);

        double a=Integer.parseInt(bdt.getText().toString());
        double result=a/85;
        usd.setText(String.valueOf(result));
    }


    public void click(View view)
    {
        convertUsdToBdt();
        Button b2=(Button) findViewById(R.id.submit2);
        b2.setEnabled(false);
    }

    public void reset(View view)
    {
        Button b1=(Button) findViewById(R.id.submit);
        b1.setEnabled(true);
        Button b2=(Button) findViewById(R.id.submit2);
        b2.setEnabled(true);
        EditText usd= (EditText) findViewById(R.id.usd);
        EditText  bdt=(EditText) findViewById(R.id.bdt);
        usd.setText("");
        bdt.setText("");

    }

    public void click2(View view)
    {
        Button b1=(Button) findViewById(R.id.submit);
        b1.setEnabled(false);
        convertBdtToUsd();
    }

}