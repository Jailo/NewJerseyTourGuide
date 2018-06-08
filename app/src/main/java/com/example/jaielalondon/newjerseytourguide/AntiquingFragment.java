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
public class AntiquingFragment extends Fragment {


    public AntiquingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate places_list view
        View rootView = inflater.inflate(R.layout.places_list, container,false);

        //Create new ArrayList of Fun Places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place("Carnival of Collectables",
                "Antique store",
                "Sicklerville", R.drawable.carnival_of_collectables,
                "Carnival of Collectables is a 12000 sq ft Antique and Art mall located" +
                        " minutes outside Philadelphia, PA right off the Atlantic City Expressway in Southern NJ.",
                "368 Berlin - Cross Keys Rd, Sicklerville, NJ 08081",
                "https://www.carnivalofcollectables.com/"));

        places.add(new Place("Lafayette Mill Antiques Center",
                "Antiques Center",
                "Lafayette", R.drawable.lafayette_mill,
                "New Jersey's Premier Antiques Center, with over 55 specially-selected" +
                        " antiques dealers.",
                "12 Morris Farm Rd, Lafayette Township, NJ 07848",
                "www.millantiques.com/"));

        places.add(new Place("Winterhill Antiques",
                "Antique store",
                "Scotch Plains", R.drawable.winterhill_antiques,
                "We love finding beautiful and unusual pieces and we are always happy " +
                        "when they find a new home! " +
                        "Do come and visit -you will not be disappointed-truly!",
                "425 Park Ave, Scotch Plains, NJ 07076",
                "www.winterhillantiques.com/"));


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
