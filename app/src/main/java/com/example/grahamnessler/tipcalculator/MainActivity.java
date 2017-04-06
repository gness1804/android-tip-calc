package com.example.grahamnessler.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    double tipPercent;
    private String[] choices = {"10", "15", "20", "25"};
    double billAmount;
    double totalTip;
    double totalBill;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createSpinner();
    }

    public void createSpinner () {
        spinner = (Spinner) findViewById(R.id.tipPercentDropdown);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.choices_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        String choice = choices[pos];
        tipPercent = Integer.parseInt(choice) * 0.01;
    }

    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculateTip (View view) {
        EditText amt = (EditText) findViewById(R.id.billAmountInput);
        TextView total = (TextView) findViewById(R.id.tipTotalOutput);
        TextView billTotal = (TextView) findViewById(R.id.totalBillOutput);
        String bill = amt.getText().toString();
        billAmount = Double.parseDouble(bill);
        totalTip = tipPercent * billAmount;
        String tipString = Double.toString(totalTip);
        total.setText(tipString);
        totalBill = billAmount + totalTip;
        String billString = Double.toString(totalBill);
        billTotal.setText(billString);
    }
}
