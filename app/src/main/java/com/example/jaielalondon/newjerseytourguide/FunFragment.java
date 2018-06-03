package com.example.jaielalondon.newjerseytourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FunFragment extends Fragment {


    public FunFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate places_list view
        View rootView = inflater.inflate(R.layout.places_list, container,false);

        //Create new ArrayList of Fun Places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place("IPlay America", "Indoor Theme Park",
                "Freehold, NJ", R.drawable.dokidoki, "New Jersey's Premier " +
                "Indoor Theme Park, with a full-service bar and grill alongside 200+ games, rides," +
                " attractions, laser tag, go karts and much more."));

        places.add(new Place("Liberty Science Center", "Museum",
                "Jersey City, NJ", R.drawable.dokidoki, "Liberty Science Center " +
                "is an interactive science museum and learning center located in Liberty State " +
                "Park in Jersey City in Hudson County, New Jersey, United States."));

        places.add(new Place("IPlay America", "Indoor Theme Park",
                "Freehold", R.drawable.dokidoki, "hahaha"));


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

        return rootView;
    }

}
