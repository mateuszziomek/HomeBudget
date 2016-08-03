package com.mateuszziomek.homebudget;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by PC on 2016-08-03.
 */
public class AccountAdapter extends ArrayAdapter<Account> {

    // custom constructor
    public AccountAdapter(Activity context, ArrayList<Account> accounts) {
        super(context, 0, accounts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // get the object located at current position
        Account currentAccount = getItem(position);

        TextView account_name = (TextView) listItemView.findViewById(R.id.account);
        account_name.setText(currentAccount.getName());

        // return the whole list_item layout so that it can be shown in the ListView
        return listItemView;
    }
}
