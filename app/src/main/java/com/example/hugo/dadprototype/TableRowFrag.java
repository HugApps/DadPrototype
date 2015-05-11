package com.example.hugo.dadprototype;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */

// Search SCreen will dynamically inflate this fragment into each table row depending on the number of query result from database

public class TableRowFrag extends Fragment {
    private TextView Title,Details,Contact;
    private ImageView Logo ;


    // Gets the necessary information to display on each table row fragment//
    public TableRowFrag() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.customerowfrag,container,false);
        Title = (TextView)view.findViewById(R.id.title);
        Details = (TextView) view.findViewById(R.id.DetailsText);
        Contact = (TextView) view.findViewById(R.id.ContactText);

        Logo  = (ImageView) view.findViewById(R.id.logo);


        return view;

    }


}
