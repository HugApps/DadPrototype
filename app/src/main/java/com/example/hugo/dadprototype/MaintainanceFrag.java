package com.example.hugo.dadprototype;


import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class MaintainanceFrag extends Fragment {
  // refrences to image buttons
  private ImageButton homeReno, plumber,landScape,security,handy,elect;

    public MaintainanceFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.maintainance,container, false);
        // Attach layout button to each reference and assign a onClick Listener//
        homeReno =(ImageButton) v.findViewById(R.id.RenovationsButton);
        //homeReno.findViewById(R.id.RenovationsButton).setOnClickListener(onClickListener);
        plumber= (ImageButton) v.findViewById(R.id.PlumberButton);
        landScape= (ImageButton) v.findViewById(R.id.LandScapeButton);
        security = (ImageButton) v.findViewById(R.id.SecurityButton);
        handy = (ImageButton) v.findViewById(R.id.HandyButton);
        elect = (ImageButton) v.findViewById(R.id.ElectricButton);

        homeReno.setOnClickListener(onClickListener);
        plumber.setOnClickListener(onClickListener);
        landScape.setOnClickListener(onClickListener);
        security.setOnClickListener(onClickListener);
        handy.setOnClickListener(onClickListener);
        elect.setOnClickListener(onClickListener);


        return v;
    }


    // Button Method that passes category to SearchScreen Fragment and inflates it //
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        // Detect which image button is clicked
        public void onClick(View v) {
            Fragment frag = new SearchScreen();
            String category;
            FragmentManager m = getFragmentManager();
            //Intiate a bundle to pass arguments, search query
            Bundle bundle  = new Bundle();
            // v.getId() returns the id on the button thats clicked
            switch (v.getId()) {


                case R.id.RenovationsButton:
                    category = "renovations";

                    bundle.putString("category",category);
                    frag.setArguments(bundle);
                    // pass category to SearchScreen Fragment and load Fragment//

                    break;


                case R.id.PlumberButton:
                    // pass category to SearchScreen Fragment and load Fragment//
                    category = "Plumber";
                    bundle.putString("category",category);
                    frag.setArguments(bundle);
                    break;


                case R.id.LandScapeButton:
                    // pass category to SearchScreen Fragment and load Fragment//
                    category = "LandScape";
                    bundle.putString("category",category);
                    frag.setArguments(bundle);
                    break;

                case R.id.HandyButton:
                    // pass category to SearchScreen Fragment and load Fragment//
                    category = "Handy";
                    bundle.putString("category",category);
                    frag.setArguments(bundle);
                    break;


                case R.id.SecurityButton:
                    // pass category to SearchScreen Fragment and load Fragment//
                    category = "Security";
                    bundle.putString("category",category);
                    frag.setArguments(bundle);
                    break;

                case R.id.ElectricButton:
                    // pass category to SearchScreen Fragment and load Fragment//
                    category = "Electric";
                    bundle.putString("category",category);
                    frag.setArguments(bundle);
                    break;


            }


            m.beginTransaction().replace(R.id.contentDisplay, frag).addToBackStack("search2").commit();


        }


    };
}
