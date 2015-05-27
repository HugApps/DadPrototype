package com.example.hugo.dadprototype;


import android.app.FragmentManager;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;



public class ServicesFrag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){


        View view = inflater.inflate(R.layout.services,container,false);

        ImageButton  Realtor = (ImageButton) view.findViewById(R.id.RealButton);
        ImageButton  Notory = (ImageButton) view.findViewById(R.id.NotoryButton);
        ImageButton  Insure = (ImageButton) view.findViewById(R.id.InsuranceButton);
        ImageButton  HomeIn = (ImageButton) view.findViewById(R.id.HomeInspectButton);
        ImageButton  Mortgage = (ImageButton) view.findViewById(R.id.MortgageButton);
        ImageButton  Law = (ImageButton) view.findViewById(R.id.LawyerButton);


        Realtor.setOnClickListener(onClickListener);
        Notory.setOnClickListener(onClickListener);
        Insure.setOnClickListener(onClickListener);
        HomeIn.setOnClickListener(onClickListener);
        Mortgage.setOnClickListener(onClickListener);
        Law.setOnClickListener(onClickListener);
        return view;



    }

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


                case R.id.RealButton:
                    category = "Realtors";

                    bundle.putString("category",category);
                    frag.setArguments(bundle);
                    // pass category to SearchScreen Fragment and load Fragment//

                    break;


                case R.id.NotoryButton:
                    // pass category to SearchScreen Fragment and load Fragment//
                    category = "Notory Public";
                    bundle.putString("category",category);
                    frag.setArguments(bundle);
                    break;


                case R.id.LawyerButton:
                    // pass category to SearchScreen Fragment and load Fragment//
                    category = "Lawyers";
                    bundle.putString("category",category);
                    frag.setArguments(bundle);
                    break;

                case R.id.HomeInspectButton:
                    // pass category to SearchScreen Fragment and load Fragment//
                    category = "Home Inspectors";
                    bundle.putString("category",category);
                    frag.setArguments(bundle);
                    break;


                case R.id.InsuranceButton:
                    // pass category to SearchScreen Fragment and load Fragment//
                    category = "Insurance Companies";
                    bundle.putString("category",category);
                    frag.setArguments(bundle);
                    break;

                case R.id.MortgageButton:
                    // pass category to SearchScreen Fragment and load Fragment//
                    category = "Mortage Broker";
                    bundle.putString("category",category);
                    frag.setArguments(bundle);
                    break;


            }


            m.beginTransaction().replace(R.id.contentDisplay, frag).addToBackStack("Search").commit();


        }


    };




}
