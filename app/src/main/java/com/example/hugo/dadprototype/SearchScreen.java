package com.example.hugo.dadprototype;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchScreen extends Fragment {

   String category ;

    public SearchScreen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.resultstable,container,false);
        category = getArguments().getString("category");
        TextView title = (TextView) view.findViewById(R.id.searchtitle);
        RatingBar stars = (RatingBar) view.findViewById(R.id.ratingBar);
        title.setText("Search for: " +" " +category);
        stars.setRating(3);
        return view;


    }


}
