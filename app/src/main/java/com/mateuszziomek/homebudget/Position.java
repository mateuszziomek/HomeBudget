package com.mateuszziomek.homebudget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Mateusz Ziomek on 2016-07-20.
 */
public class Position extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String TAG = "MyActivity";

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

        // Create an Account object to control values of the accounts
        Account account = new Account();

        // Find views
        final Spinner spinner1 = (Spinner) findViewById(R.id.spinner_1);
        final Spinner spinner2 = (Spinner) findViewById(R.id.spinner_2);
        final Spinner spinner3 = (Spinner) findViewById(R.id.spinner_3);
        final EditText editText1 = (EditText) findViewById(R.id.date);
        final EditText editText2 = (EditText) findViewById(R.id.what);
        final EditText editText3 = (EditText) findViewById(R.id.amount);

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

        // Find view of the add button
        final Button addButton = (Button) findViewById(R.id.addItemButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new Item object
                Item item = new Item();

                // Get all values input by the user
                item.setPositionType(spinner1.getSelectedItem().toString());
                item.setCategory(spinner2.getSelectedItem().toString());
                item.setDate(editText1.getText().toString());
                item.setWhat(editText2.getText().toString());
                item.setAmount(Double.parseDouble(editText3.getText().toString()));
                item.setAccount(spinner3.getSelectedItem().toString());


                Toast.makeText(getApplicationContext(), "Pozycja dodana", Toast.LENGTH_SHORT).show();
                Log.i(TAG, item.toString());
            }
        });
    }


}
