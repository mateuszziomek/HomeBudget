package com.mateuszziomek.homebudget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by Mateusz Ziomek on 2016-07-20.
 */
public class Position extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // 2 methods of OnItemSelectedListener interface that need to be implemented
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.position);

        // Find spinners' views
        final Spinner spinner1 = (Spinner) findViewById(R.id.spinner_1);
        final Spinner spinner2 = (Spinner) findViewById(R.id.spinner_2);
        final Spinner spinner3 = (Spinner) findViewById(R.id.spinner_3);

        // Create an ArrayAdapter using the string array and a default spinner layout
        final ArrayAdapter<CharSequence> adapter_type = ArrayAdapter.createFromResource(this,
                R.array.position_type, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> adapter_expense = ArrayAdapter.createFromResource(this,
                R.array.expense_category, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> adapter_income = ArrayAdapter.createFromResource(this,
                R.array.income_category, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> adapter_account = ArrayAdapter.createFromResource(this,
                R.array.account_category, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter_type.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_expense.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_income.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_account.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner1
        spinner1.setAdapter(adapter_type);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            // Depending on the option chosen in spinner1:
            // income/expense/internal wire/set account balance - populate spinner2 accordingly
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                EditText editText1 = (EditText) findViewById(R.id.date);
                EditText editText2 = (EditText) findViewById(R.id.what);

                if (spinner1.getSelectedItem().equals("Wydatek")) {
                    spinner2.setAdapter(adapter_expense);
                    editText1.setVisibility(View.VISIBLE);
                    editText2.setVisibility(View.VISIBLE);
                    spinner3.setVisibility(View.VISIBLE);
                } else if (spinner1.getSelectedItem().equals("Przychód")) {
                    spinner2.setAdapter(adapter_income);
                    editText1.setVisibility(View.VISIBLE);
                    editText2.setVisibility(View.VISIBLE);
                    spinner3.setVisibility(View.VISIBLE);
                } else if (spinner1.getSelectedItem().equals("Przelew własny")) {
                    spinner2.setAdapter(adapter_account);
                    editText1.setVisibility(View.VISIBLE);
                    editText2.setVisibility(View.VISIBLE);
                    spinner3.setVisibility(View.VISIBLE);
                } else if (spinner1.getSelectedItem().equals("Ustaw stan konta")) {
                    spinner2.setAdapter(adapter_account);
                    editText1.setVisibility(View.INVISIBLE);
                    editText2.setVisibility(View.INVISIBLE);
                    spinner3.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        // Set the rest spinners
        spinner2.setOnItemSelectedListener(this);
        spinner3.setAdapter(adapter_account);
        spinner3.setOnItemSelectedListener(this);
    }


}
