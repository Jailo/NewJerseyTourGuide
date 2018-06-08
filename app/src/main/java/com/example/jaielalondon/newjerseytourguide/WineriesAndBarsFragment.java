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
public class WineriesAndBarsFragment extends Fragment {


    public WineriesAndBarsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate places_list view
        View rootView = inflater.inflate(R.layout.places_list, container,false);

        //Create new ArrayList of Fun Places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place("Hopewell Valley Vineyards",
                "Winery",
                "Pennington", R.drawable.hopewell_valley_vineyards,
                "Hopewell Valley Vineyards is a winery dedicated to the creation of " +
                        "handcrafted wines by blending Old World traditions with New World flair." +
                        " Our missions is to provide a relaxing, quaint, and beautiful environment " +
                        "where to experience world class wines, enjoy the company of friends ," +
                        " and create long lasting memories.",
                "46 Yard Rd, Pennington, NJ 08534",
                "www.hopewellvalleyvineyards.com/"));

        places.add(new Place("Shanghai Jazz Restaurant & Bar",
                "Asian Restaurant",
                "Madison", R.drawable.shanghai_jazz,
                "Celebrating Great American Jazz and Asian-Inspired Cuisine," +
                        " Shanghai Jazz® has been named \"One of the Top 100 Great Jazz Clubs in" +
                        " the World!\" World class live music 6 nights a week. " +
                        "No music charge except for Special Events.",
                "1818 24 Main Street, Madison, NJ 07940",
                "www.shanghaijazz.com/"));

        places.add(new Place("Cielo Wine Bar",
                "Italian Restaurant",
                "Atlantic City", R.drawable.cielo_wine_bar,
                "With an intimate setting, artisanal small bites and an immaculate" +
                        " wine selection, Cielo Wine Bar is the perfect place to unwind.",
                "1133 Boardwalk, Atlantic City, NJ 08401",
                "https://resortsac.com/locations/cielo-wine-bar/"));

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
