package com.example.hugo.dadprototype;


import android.app.FragmentManager;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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

        title.setText("Search for: " + " " + category);

        return view;


    }


    public void populateRow (int numofresults){
        // For now just make 3 rows

        for (int i = 0 ; i <3 ; i ++){

            // make new instance of table row

            TableRow row = new TableRow(getActivity());
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);
            FrameLayout frame = new FrameLayout(getActivity());

            row.addView(frame);

            // inflate fragment replace frame with fragment //

            // Pass i specfic data to display on the row//
            Fragment rowdata = new TableRowFrag();
            FragmentManager m = getFragmentManager();
            m.beginTransaction().replace(frame.getId(), rowdata).commit();

            table.addView(row);

        }



    }

}
