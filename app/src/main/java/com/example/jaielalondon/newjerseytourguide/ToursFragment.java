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
public class ToursFragment extends Fragment {


    public ToursFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate places_list view
        View rootView = inflater.inflate(R.layout.places_list, container,false);

        //Create new ArrayList of Fun Places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place("Thomas Edison National Historical Park",
                "Historic Site",
                "West Orange", R.drawable.thomas_edison,
                "Thomas Edison National " +
                "Historical Park preserves Thomas Edison's laboratory and residence, Glenmont, in " +
                "Llewellyn Park in West Orange in Essex County, New Jersey, United States.",
                "211 Main St, West Orange, NJ 07052",
                "https://www.nps.gov/edis/index.htm"));

        places.add(new Place("Empty Sky - 9/11 Memorial",
                "Monument",
                "Jersey City", R.drawable.empty_sky,
                "Empty Sky is the official " +
                "New Jersey September 11 memorial to the state's victims of the September 11 attacks" +
                " on the United States.",
                "Empty Sky - 9/11 Memorial",
                "https://nj911memorial.org/empty-sky/"));

        places.add(new Place("Cape May Whale Watcher",
                "Whale watching tour agency",
                "Cape May", R.drawable.cape_may_whale_watcher,
                "Whale watching " +
                "and dolphin watching cruises with Guaranteed Sightings! Climb aboard The Cape May" +
                " Whale Watcher, the largest and fastest in New Jersey.",
                "1218 Wilson Dr, Cape May, NJ 08204",
                "capemaywhalewatcher.com/"));


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
