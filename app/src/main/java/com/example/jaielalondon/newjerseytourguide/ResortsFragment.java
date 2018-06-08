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
public class ResortsFragment extends Fragment {


    public ResortsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate places_list view
        View rootView = inflater.inflate(R.layout.places_list, container,false);

        //Create new ArrayList of Fun Places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place("Mountain Creek",
                "Ski Resort",
                "Vernon Township", R.drawable.mountain_creek,
                "Whether you seek the thrill of sliding on snow at the largest ski area" +
                        " in New Jersey, plunging into the world’s tallest and only double-looping" +
                        " waterpark slide or descending the uniquely East Coast trails of the Mountain" +
                        " Creek Bike Park, there’s no shortage of adventures to leave you with stories " +
                        "that will last a lifetime. With a range of accommodations from mountaintop cabins" +
                        " to poolside condos and townhomes, there are also plenty of options to relax.",
                "200 Route 94, Vernon Township, NJ 07462",
                "https://www.mountaincreek.com/"));

        places.add(new Place("Grand Cascades Lodge",
                "Hotel",
                "Hamburg", R.drawable.grand_cascades_lodge,
                "The striking architecture of the luxurious, AAA 4-Diamond Grand Cascades" +
                        " Lodge can be seen for miles across the valley, sitting amongst three world-class" +
                        " golf courses with the Kittatinny Mountain Range providing an immaculate backdrop." +
                        " Unquestionably the finest property in the region, this Adirondack-style lodge " +
                        "sets the stage for the perfect harmony of luxury and nature’s bounty, creating " +
                        "a four-star escape like no other.",
                "3 Wild Turkey Way, Hamburg, NJ 07419",
                "https://www.crystalgolfresort.com/stay/grand-cascades-lodge/"));

        places.add(new Place("The Asbury Hotel",
                "Hotel",
                "Asbury Park", R.drawable.asbury_hotel,
                "There’s something for everyone at The Asbury, whether it’s hanging by" +
                        " the pool, enjoying live music in the lobby, soaking up a sunrise yoga class " +
                        "on Baronet or simply relaxing in your room, this is the new Asbury Park.",
                "210 5th Ave, Asbury Park, NJ 07712",
                "https://www.theasburyhotel.com/"));


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
