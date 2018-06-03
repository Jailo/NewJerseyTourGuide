package com.example.jaielalondon.newjerseytourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaielalondon on 6/2/18.
 */

public class PlaceAdapter extends ArrayAdapter<Place> {

    private Context mContext;

    /* Creates a new list of Places*/
    private List<Place> placeList = new ArrayList<>();

    /**
     *
     * @param context is the current context; used to infalte the layout xml file.
     * @param places a list of places objects to display in a list
     */
    public PlaceAdapter(@NonNull Context context, ArrayList<Place> places) {
        super(context, 0, places);
        mContext = context;
        placeList = places;
    }


    /**
     *
     * @param position the position of view in array
     * @param convertView
     * @param parent
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Place} object located at this position in the list
        Place currentPlace = placeList.get(position);

        //Find the place's ImageView in the list_item.xml layout with the ID image
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        //set this image on the ImageView
        imageView.setImageResource(currentPlace.getPlaceImageResourceId());

        // Find the TextView in the list_item.xml layout with the ID place_name
        TextView placeNameTextView = (TextView) listItemView.findViewById(R.id.place_name);
        // Get the place's name from the current Place object and
        // set this text on the placeNameTextView
        placeNameTextView.setText(currentPlace.getPlaceName());

        // Find the TextView in the list_item.xml layout with the ID short_description
        TextView shortDescriptTextView = (TextView) listItemView.findViewById(R.id.short_description);
        // Get the place's short description from the current Place object and
        // set this text on the shortDescriptTextView
        shortDescriptTextView.setText(currentPlace.getPlaceShortDescription());

        // Find the TextView in the list_item.xml layout with the ID place_city
        TextView placeCityTextView = (TextView) listItemView.findViewById(R.id.place_city);
        // Get the place's city from the current Place object and
        // set this text on the placeCityTextView
        placeCityTextView.setText(currentPlace.getCity());


        return listItemView;
    }

}
