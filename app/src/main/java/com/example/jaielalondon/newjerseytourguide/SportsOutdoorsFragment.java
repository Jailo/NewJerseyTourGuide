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
public class SportsOutdoorsFragment extends Fragment {


    public SportsOutdoorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate places_list view
        View rootView = inflater.inflate(R.layout.places_list, container,false);

        //Create new ArrayList of Fun Places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place("Echo Lake Stable",
                "Horseback Trail Rides",
                " Newfoundland", R.drawable.echo_lakes_stables,
                "For horseback riding NJ, stop by Echo Lakes Stables where you can " +
                        "enjoy scenic trails, stunning horses, and friendly trail guides.",
                "55 Blakely Ln, Newfoundland, NJ 07435",
                "www.echolakestables.com/"));

        places.add(new Place("A-Lot-A Hot Air Balloon Rides",
                "Balloon ride tour agency",
                "Frenchtown", R.drawable.a_lot_a_hot_air,
                "Hot air balloon rides in NJ, New York, PA, & NYC. Balloon flights" +
                        " over beautiful country side. Views of the earth like you have never seen.",
                "155 Union Rd, Frenchtown, NJ 08825",
                "http://www.upnoa.com/"));

        places.add(new Place("Turtle Back Zoo",
                "Zoo",
                "West Orange", R.drawable.turtle_back_zoo,
                "Essex County's Turtle Back Zoo was voted #1 Zoo in New Jersey with " +
                        "over 200 species representing animals from around the world.",
                "560 Northfield Ave, West Orange, NJ 07052",
                "turtlebackzoo.com/"));


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
