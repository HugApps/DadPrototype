package com.example.hugo.dadprototype;


import android.app.FragmentManager;
import android.content.Intent;
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
    private String  name,description,address,phone,email;


    // Gets the necessary information to display on each table row fragment//
    public TableRowFrag() {



        // Required empty public constructor
    }



    public void  addDetails(String name,String description,String address,String phone, String email){
        this.name = name;
        this.description = description;
        this.address = address;
        this.phone = phone;
        this.email = email;

    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.customerowfrag,container,false);
        Title = (TextView)view.findViewById(R.id.title);

        //if(name!=null){Title.setText(name);}
        Details = (TextView) view.findViewById(R.id.DetailsText);
        Contact = (TextView) view.findViewById(R.id.ContactText);
        Contact.setOnClickListener(CallClickListener);
        Details.setOnClickListener(DetailClickListener);
        Logo  = (ImageView) view.findViewById(R.id.logo);




        return view;

    }

    // Carries out function to load Details
    private View.OnClickListener DetailClickListener = new View.OnClickListener() {


        public void onClick(View v) {
            // Loads new Fragment and passes details to fragment
         FragmentManager m =  getFragmentManager();
         DetailsFragment f = new DetailsFragment(); // Replacee with new Fragment
         Bundle bundle = new Bundle();

         bundle.putString("name",name);
         bundle.putString("description",description);
         bundle.putString("address",address);
         bundle.putString("email",email);
         bundle.putString("phone",phone);
         f.setArguments(bundle);
         m.beginTransaction().replace(R.id.contentDisplay, f).commit();


        }

    };


    // Carries out emailling and phone calling
    private View.OnClickListener CallClickListener = new View.OnClickListener() {


        public void onClick(View v) {
         Intent sendIntent = new Intent();
         sendIntent.setAction(Intent.ACTION_SEND);
         sendIntent.setType("plain/text");
         sendIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"ykc10@sfu.ca"});
         sendIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject");
         sendIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Text");

/* Send it off to the Activity-Chooser */
         getActivity().startActivity(Intent.createChooser(sendIntent, "Send mail...")) ;

        }

    };


}
