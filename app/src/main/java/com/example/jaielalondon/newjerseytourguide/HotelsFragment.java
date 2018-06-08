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
public class HotelsFragment extends Fragment {


    public HotelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate places_list view
        View rootView = inflater.inflate(R.layout.places_list, container,false);

        //Create new ArrayList of Fun Places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place("Caesars Atlantic City Hotel and Casino",
                "Hotel",
                "Atlantic City", R.drawable.caesars,
                "Caesars Atlantic City is a luxury hotel, casino, and spa resort in " +
                        "Atlantic City, New Jersey. Like Caesars Palace in Las Vegas, " +
                        "it has an ancient Roman and ancient Greek theme.",
                " 2100 Pacific Ave, Atlantic City, NJ 08401",
                "https://www.caesars.com/caesars-ac"));

        places.add(new Place("The Westin Jersey City Newport",
                "Hotel",
                "Jersey City", R.drawable.the_westin,
                "Situated on the Hudson River waterfront, steps away from downtown " +
                        "Jersey City, The Westin Jersey City Newport offers hotel guests a compelling " +
                        "blend of convenience and sophistication.",
                "479 Washington Blvd, Jersey City, NJ 07310",
                "www.westinjerseycitynewport.com/"));

        places.add(new Place("Ocean Club Hotel",
                "Hotel",
                "Cape May", R.drawable.ocean_club_hotel_in_cape,
                "Welcome to the Ocean Club Hotel located in historic Cape May, NJ." +
                        " This boutique beachfront hotel, designed by Duncan Design, offers stunning " +
                        "views of the Atlantic Ocean and Cape May's beaches, private balconies," +
                        " luxury linens and so much more.",
                "1035 Beach Ave, Cape May, NJ 08204",
                "https://www.capemayoceanclubhotel.com/"));


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
