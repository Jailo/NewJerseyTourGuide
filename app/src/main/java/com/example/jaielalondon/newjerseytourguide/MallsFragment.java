package com.example.jaielalondon.newjerseytourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MallsFragment extends Fragment {


    public MallsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate places_list view
        View rootView = inflater.inflate(R.layout.places_list, container,false);

        //Create new ArrayList of Fun Places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place("The Quarter at Tropicana",
                "Shopping Mall",
                "Atlantic City", R.drawable.the_quarter_tropicana,
                "The Quarter at Tropicana is an Old Havana-themed enclosed shopping" +
                        " mall located at the Tropicana Casino Resort Atlantic City in Atlantic City," +
                        " New Jersey. It contains over 40 stores, nine restaurants, eleven nightclubs, and a spa.",
                "2831 Boardwalk Atlantic City, NJ 08401",
                "https://tropicana.net/quarter/"));

        places.add(new Place("Jersey Gardens",
                "Shopping Mall",
                "Elizabeth", R.drawable.jersey_gardens_mall,
                "Get ready to splurge at The Mills at Jersey Gardens, New Jersey's" +
                        " largest premium outlet mall with over 200 stores under one roof! " +
                        "They welcome over 18 million people each year, nearly 5 times more people" +
                        " than the Statue of Liberty.",
                "651 Kapkowski Rd, Elizabeth, NJ 07201",
                "www.simon.com/mall/the-mills-at-jersey-gardens"));

        places.add(new Place("Bridgewater Commons",
                "Shopping Mall",
                "Bridgewater Township", R.drawable.bridgewater_commons,
                "Shop the brands you love at the best shopping mall in Bridgewater. " +
                        "Visit Bridgewater Commons for shopping, dining, and entertainment activities.",
                "400 Commons Way, Bridgewater, NJ 08807",
                "https://www.bridgewatercommons.com/en.html"));


        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called places_list,
        // which is declared in the places_list layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.places_list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        /**
         * create a list view click listener that starts intent to place info page
         * and send data about the place, like its Image Id, name, description, address, and website
         * through the intent to the PlaceInfoActivity
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Get the current place that the user has clicked on
                Place currentPlace = places.get(position);

                //Create Intent that goes to PlaceInfoActivity
                Intent intent = new Intent(getActivity(), PlaceInfoActivity.class);

                // Send the data from the currentPlace to the PlaceInfoActivity
                // The data we're sending is the current place's image Id, name, long description...
                intent.putExtra("imageId", currentPlace.getPlaceImageResourceId());
                intent.putExtra("name", currentPlace.getPlaceName());
                intent.putExtra("longDescription", currentPlace.getLongDescription());
                intent.putExtra("address", currentPlace.getAddress());
                intent.putExtra("websiteUrl", currentPlace.getWebsiteUrl());

                startActivity(intent);
            }

        });


        return rootView;
    }

}
