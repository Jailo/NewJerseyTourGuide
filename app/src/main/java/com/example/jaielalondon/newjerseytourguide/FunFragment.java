package com.example.jaielalondon.newjerseytourguide;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FunFragment extends Fragment {

    public FunFragment() {
        // Required empty public constructor
    }

    //Create new ArrayList of Fun Places
    private ArrayList<Place> places = new ArrayList<Place>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate places_list view
        View rootView = inflater.inflate(R.layout.places_list, container,false);

        places.add(new Place("IPlay America",
                "Amusement center",
                "Freehold", R.drawable.iplay,
                "New Jersey's Premier Indoor Theme " +
                "Park, with a full-service bar and grill alongside 200+ games, rides, attractions, " +
                "laser tag, go karts and much more.",
                "2938, 110 Schanck Rd, Freehold, NJ " +
                "07728",
                "https://www.iplayamerica.com/"));


        places.add(new Place("Six Flags Great Adventure & Safari",
                "Amusement park",
                "Jackson", R.drawable.sixflags,
                "New Jersey's biggest, most popular" +
                " theme park featuring dozens of thrill rides, shows, and activities",
                "1 Six Flags Blvd, Jackson, NJ 08527",
                "https://www.sixflags.com/greatadventure"));

        places.add(new Place("Adventure Rooms",
                "Room Escape Games",
                "Montclair", R.drawable.adventure_rooms,
                "Adventure Rooms New Jersey is a premier private escape room offering" +
                        " adventures with immersive environments, logic and tactile based puzzles " +
                        "and thrilling experiences! You have 60 minutes to solve the challenge in " +
                        "front of you. We are the ultimate room escape for enthusiasts!",
                "119 Grove St, Montclair, NJ 07042",
                "www.myadventurerooms.com/"));



        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.

        PlaceAdapter adapter = new PlaceAdapter(getActivity(), places);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called places_list,
        // which is declared in the places_list layout file.
        ListView listView = rootView.findViewById(R.id.places_list);

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
