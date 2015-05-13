package com.example.hugo.dadprototype;


import android.app.FragmentManager;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.RatingBar;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchScreen extends Fragment {

   String category ;
   TableLayout table;
    public SearchScreen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.resultstable,container,false);
        table = (TableLayout) view.findViewById(R.id.resulttable);
        populateRow(3);
        category = getArguments().getString("category");
        TextView title = (TextView) view.findViewById(R.id.searchtitle);

        title.setText( category);

        return view;


    }


    public void populateRow (int numofresults){
        // For now just make 3 rows, eventually fetch from database

        for (int i = 1 ; i <10 ; i ++){

            // make new instance of table row
            int id = i;
            TableRow row = new TableRow(getActivity());
            HorizontalScrollView scroller = new HorizontalScrollView(getActivity());
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);scroller.setLayoutParams(lp);
            row.setLayoutParams(lp);
            FrameLayout frame = new FrameLayout(getActivity());
            frame.setId(id); scroller.addView(frame);row.addView(scroller);
           //ow.addView(frame);

            // Pass i specfic data to display on the row//
            TableRowFrag rowdata = new TableRowFrag();

            FragmentManager m = getFragmentManager();

            m.beginTransaction().replace(i, rowdata).commit();
            rowdata.addDetails("a","b","c","d","e");

            table.addView(row);

        }



    }

}
