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
public class CafesAndTreatsFragment extends Fragment {


    public CafesAndTreatsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate places_list view
        View rootView = inflater.inflate(R.layout.places_list, container,false);

        //Create new ArrayList of Fun Places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place("Americas Cup Coffee Company",
                "Coffee Shop",
                "Asbury Park", R.drawable.americas_cup_coffee,
                "Relaxed coffeehouse featuring java, desserts & sandwiches in simple " +
                        "digs with outdoor seating.",
                "633 Cookman Ave, Asbury Park, NJ 07712",
                "www.americascupcoffee.com/"));

        places.add(new Place("Duck Donuts",
                "Donut Shop",
                "Green Brook Township", R.drawable.duck_donuts,
                "Warm, delicious and made-to-order donuts, coffee, donut sundaes and" +
                        " sandwiches, and donut catering packages. More than 100 stores in the US and growing!",
                "215 Route 22 East, Unit 7, Green Brook Township, NJ 08812",
                "https://www.duckdonuts.com/"));

        places.add(new Place("Cookman Creamery",
                "Ice Cream Shop",
                "Asbury Park", R.drawable.cookman_creamery,
                "Family-owned parlor preparing artisanal ice cream in surprising " +
                        "flavors, plus lots of vegan options.",
                "711 Cookman Ave, Asbury Park, NJ 07712",
                "www.cookmancreamery.com/"));



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
