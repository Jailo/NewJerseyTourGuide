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
public class BedAndBreakfastsFragment extends Fragment {


    public BedAndBreakfastsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate places_list view
        View rootView = inflater.inflate(R.layout.places_list, container,false);

        //Create new ArrayList of Fun Places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place("The Wooden Duck Bed & Breakfast",
                "Hotel",
                "Newton", R.drawable.wooden_duck,
                " Imagine a secluded estate not very far away yet far enough to escape " +
                        "from the real world. A comfortable, friendly B&B at the center of all Northern " +
                        "New Jersey has to offer. Mountain lakes, shopping, entertainment, romance & dining.\n" +
                        "\n" +
                        "Come see why travelers stay with us, not from just the northeast US but from all over the world.",
                "140 Goodale Rd, Newton, NJ 07860",
                "https://www.woodenduckinn.com/"));

        places.add(new Place("Sand Castle Bed & Breakfast",
                "Hotel",
                "Barnegat Light", R.drawable.sand_castle,
                "Find top resort amenities with the privacy and quiet you desire at " +
                        "the Sand Castle Inn, our Long Beach Island bed and breakfast just two blocks from the beach.",
                "710 Bayview Ave, Barnegat Light, NJ 08006",
                "https://www.sandcastlelbi.com/"));

        places.add(new Place("The Majestic Hotel",
                "Hotel",
                "Ocean Grove", R.drawable.the_majestic_hotel,
                "The Majestic Hotel is a top rated boutique hotel along the New Jersey" +
                        " shoreline in the historical landmark town of Ocean Grove.  Originally built " +
                        "with 20 rooms in 1870, this historic New Jersey Shore hotel has been completely" +
                        " renovated with 16 spacious rooms, ranging from premium queen rooms to a luxurious three-room Penthouse.",
                "19 Main Ave, Ocean Grove, NJ 07756",
                "majesticoceangrove.com/"));


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
