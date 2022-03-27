package com.example.myfirstapp;

import android.annotation.SuppressLint;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Declare widgets
    String Val;
    EditText editTextNumber;
    TextView Value1, Value2, Value3, SValue1, SValue2, SValue3;
    ImageButton Length, Temp, Weight;
    Spinner Spinner;
    DecimalFormat precision = new DecimalFormat("0.00");

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Spinner = (Spinner) findViewById(R.id.Spinner);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Metre");
        arrayList.add("Celsius");
        arrayList.add("Kilograms");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner.setAdapter(arrayAdapter);

        Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                Val = Spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // Instantiating Widgets

        Value1 = findViewById(R.id.Value1);
        Value2 = findViewById(R.id.Value2);
        Value3 = findViewById(R.id.Value3);
        SValue1= findViewById(R.id.SValue1);
        SValue2= findViewById(R.id.SValue2);
        SValue3= findViewById(R.id.SValue3);


        editTextNumber = findViewById(R.id.editTextNumber);

        Length = findViewById(R.id.Length);
        Temp = findViewById(R.id.Temp);
        Weight = findViewById(R.id.Weight);

        // Adding a click event for button

        Length.setOnClickListener(this);
        Temp.setOnClickListener(this);
        Weight.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Length:
                ConvertFromMetre();
                break;
            case R.id.Temp:
                ConvertFromCelsius();
                break;
            case R.id.Weight:
                ConvertFromKilo();
                break;
        }
    }

    private void ConvertFromCelsius() {
        String ValueEnteredInCelsius = editTextNumber.getText().toString();
        //converting string to number
        double Celsius = Double.parseDouble(ValueEnteredInCelsius);
        //convert Metre to Centi
        double Fahrenheit = (Celsius * 9/5) + 32;
        double Kelvin = Celsius + 273.15;
        // Display the value resulted in textView
        if (Val.equals("Celsius")) {
            Value1.setText(precision.format(Fahrenheit));
            Value2.setText(precision.format(Kelvin));
            Value3.setText("");
            SValue1.setText("" + "Fahrenheit");
            SValue2.setText("" + "Kelvin");
            SValue3.setText("");
        }
        else
        {
            Toast.makeText(this, "Please select the correct conversion icon", Toast.LENGTH_SHORT).show();
        }
    }

    private void ConvertFromKilo() {
        String ValueEnteredInKilo = editTextNumber.getText().toString();
        //converting string to number
        double Kilo = Double.parseDouble(ValueEnteredInKilo);
        //convert Metre to Centi
        double Gram = Kilo * 1000;
        double Ounce = Kilo * 35.274;
        double Pound = Kilo * 2.20462;
        // Display the value resulted in textView
        if (Val.equals("Kilograms")) {
            Value1.setText(precision.format(Gram));
            Value2.setText(precision.format(Ounce));
            Value3.setText(precision.format(Pound));
            SValue1.setText("" + "Gram");
            SValue2.setText("" + "Ounce(Oz)");
            SValue3.setText("" + "Pound(lb)");
        }
        else
        {
            Toast.makeText(this, "Please select the correct conversion icon", Toast.LENGTH_SHORT).show();
        }
    }

    private void ConvertFromMetre() {
        String ValueEnteredInMetre = editTextNumber.getText().toString();
        //converting string to number
        double Metre = Double.parseDouble(ValueEnteredInMetre);
        //convert Metre to Centi
        double Centimetre = Metre * 1000;
        double Foot = Metre * 3.28084;
        double Inch = Metre * 39.3701;
        // Display the value resulted in textView
        if (Val.equals("Metre")) {
            Value1.setText(precision.format(Centimetre));
            Value2.setText(precision.format(Foot));
            Value3.setText(precision.format(Inch));
            SValue1.setText("" + "Centimetre");
            SValue2.setText("" + "Foot");
            SValue3.setText("" + "Inch");
        }
        else
        {
            Toast.makeText(this, "Please select the correct conversion icon", Toast.LENGTH_SHORT).show();
        }
    }

}



















