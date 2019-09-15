package com.example.currencyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double moneyInput;
    double convertPrice;
    double moneyTotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final RadioButton radioOne = (RadioButton) findViewById(R.id.mexicanRadio);
        final RadioButton radioTwo = (RadioButton) findViewById(R.id.europeRadio);
        final RadioButton radioThree = (RadioButton) findViewById(R.id.canadaRadio);
        final EditText inputUS = (EditText)findViewById(R.id.inputUSDollar);
        final TextView convertContry = (TextView) findViewById(R.id.convertOutput);
        final TextView convertMoney = (TextView) findViewById(R.id.convertMoneyOutput);
        Button convert = (Button)findViewById(R.id.convertButton);

        convert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                moneyInput = Double.parseDouble(inputUS.getText().toString());
                if (moneyInput > 100000){
                    Toast notify = Toast.makeText(MainActivity.this,"the amount must be \nless than one hundred thousands",Toast.LENGTH_LONG);
                }
                if (radioOne.isChecked()){
                    convertPrice = 19.43;
                    moneyTotal = convertPrice * moneyInput;
                    DecimalFormat currency = new DecimalFormat("$###,###.##");
                    convertContry.setText("US Dollar to Mexico Peso");
                    convertMoney.setText(currency.format(moneyTotal));
                }
                else if (radioTwo.isChecked()){
                    convertPrice = 0.90;
                    moneyTotal = convertPrice * moneyInput;
                    DecimalFormat currency = new DecimalFormat("$###,###.##");
                    convertContry.setText("US Dollar to European Euro");
                    convertMoney.setText(currency.format(moneyTotal));
                }
                else if (radioThree.isChecked()){
                    convertPrice = 1.32;
                    moneyTotal = convertPrice * moneyInput;
                    DecimalFormat currency = new DecimalFormat("$###,###.##");
                    convertContry.setText("US Dollar to Canada Dollar");
                    convertMoney.setText(currency.format(moneyTotal));
                }
            }
        });
    }
}
