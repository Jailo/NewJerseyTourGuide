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
public class FleaAndFarmersMarketsFragment extends Fragment {


    public FleaAndFarmersMarketsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate places_list view
        View rootView = inflater.inflate(R.layout.places_list, container,false);

        //Create new ArrayList of Fun Places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place("Dutch Country Farmers Market",
                "Farmers Market",
                "Flemington", R.drawable.dutch_contry_farmers_market,
                "Welcome to the Dutch Country Farmers Market.  An array of delicious home-style " +
                        "comfort foods, sweet treats and farm fresh products await you.  \n" + "Each Thursday," +
                        " Friday & Saturday the market is bustling with the sights, sounds and smells of" +
                        " a variety of Amish vendors all under one roof, bringing you a wonderful blend of" +
                        " fresh delicious foods as well as foods unique to the Pennsylvania Dutch countryside of Lancaster County.",
                "19 Commerce St, Flemington, NJ 08822",
                "www.dutchfarmersmarket.com/"));

        places.add(new Place("Alstede Farms",
                "Produce Market",
                " Chester", R.drawable.alstede_farms,
                "The best thing about produce is that it just keeps growing. Each season’s" +
                        " change brings new flavors, new colors, new aromas to the table. And that’s" +
                        " why every visit to Alstede Farms is a discovery.",
                "1 Alstede Farms Ln, Chester Township, NJ 07930",
                "https://alstedefarms.com/"));

        places.add(new Place("Berlin Farmer's Market",
                "Farmers Market",
                "Berlin", R.drawable.berlin_farmers_market,
                "Inside you'll find over 70 stores offering unique goods and services " +
                        "from Amish Bakery, Amish Meat Market, Furniture, Fresh Local Produce, Clothing & much more!",
                "41 Clementon Rd, Berlin, NJ 08009",
                "https://www.berlinfarmersmarket.com/"));


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
