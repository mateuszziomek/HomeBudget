package com.mateuszziomek.homebudget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_list);

        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account("Stan konta"));
        accounts.add(new Account("Oszczędności"));
        accounts.add(new Account("Konto Matys"));
        accounts.add(new Account("Portfel Matys"));
        accounts.add(new Account("Konto Lu"));
        accounts.add(new Account("Portfel Lu"));
        accounts.add(new Account("Koperta"));

        // create ArrayAdapter
        AccountAdapter itemsAdapter = new AccountAdapter(this, accounts);

        // find ListView
        ListView accountsList = (ListView) findViewById(R.id.list);

        // populate ListView with ArrayAdapter
        accountsList.setAdapter(itemsAdapter);

        // find button
        Button addButton = (Button) findViewById(R.id.addButton);

        // set onClickListener on the button
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Position.class);
                startActivity(intent);
            }
        });

    }
}
