package com.example.hugo.dadprototype;


import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {
   TextView Details ;
   TextView Title;
   GoogleMap googleMap;
   FrameLayout mapframe;
   ImageButton mapbutton,callbutton,emailbutton,webbutton;

    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_details, container, false);
        Details = (TextView) v.findViewById(R.id.DText);
        Title = (TextView) v.findViewById(R.id.DTitle);
        mapframe = (FrameLayout) v.findViewById(R.id.mapframe);
        webbutton = (ImageButton) v.findViewById(R.id.webbutton);webbutton.setOnClickListener(WebMapClickListener);
        mapbutton= (ImageButton) v.findViewById(R.id.map);mapbutton.setOnClickListener(MapClickListener);
        callbutton =(ImageButton) v.findViewById(R.id.callbutton);callbutton.setOnClickListener(CallClickListener);
        emailbutton = (ImageButton)v.findViewById(R.id.email);emailbutton.setOnClickListener(EmailClickListener);


            Details.setText(getArguments().getString("description"));
            Title.setText(getArguments().getString("name"));




        //OpenMap();
        return v;
    }




    private View.OnClickListener MapClickListener = new View.OnClickListener() {


        public void onClick(View v) {
            // Loads new Fragment and passes details to fragment
           if(mapframe.getVisibility()== View.VISIBLE) {
               mapframe.setVisibility(View.GONE);
               return;
           }
          // mapframe.addView(v.findViewById(R.id.mapView));
           mapframe.setVisibility(View.VISIBLE);



        }

    };

    private View.OnClickListener CallClickListener = new View.OnClickListener() {


        public void onClick(View v) {
            // Loads new Fragment and passes details to fragment
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" +Uri.encode("12345")));
             startActivity(intent);


        }

    };

    private View.OnClickListener EmailClickListener = new View.OnClickListener() {


        public void onClick(View v) {
            // Loads new Fragment and passes details to fragment
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




    private View.OnClickListener WebMapClickListener = new View.OnClickListener() {


        public void onClick(View v) {
            // Loads new Fragment and passes details to fragment
          String url ="http://www.facebook.com";
          Intent web = new Intent(Intent.ACTION_VIEW);
          web.setData(Uri.parse(url));
          startActivity(web);



        }

    };


}
