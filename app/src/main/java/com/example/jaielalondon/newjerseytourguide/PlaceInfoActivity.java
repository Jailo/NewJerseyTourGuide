package com.example.jaielalondon.newjerseytourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.Objects;

public class PlaceInfoActivity extends AppCompatActivity{

    /* Place Name */
    private String mName;

    /* Long Description for place */
    private String mLongDescription;

    /* Place Image resource ID */
    private int mImageId;

    /* Place's address */
    private String mAddress;

    /* Place's Website Url */
    private String mWebsiteUrl;


    /**
     * An item in your options menu is selected.
     * @param item is the Up Button
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Respond to the action bar's Up/Home button by finishing the activity,
                // thus going back to whichever activity came before this one
                finish();
                return false;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_info);

        // Enable Up button in action bar
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        //Get the intent that brought user to this activity
        Intent intent = getIntent();

        // From the {@Place} the user clicked on
        // Get the image Id, place name, long description, address, and website url ...
        mImageId = intent.getIntExtra("imageId", R.drawable.ic_launcher_background);
        mName = intent.getStringExtra("name");
        mLongDescription = intent.getStringExtra("longDescription");
        mAddress = intent.getStringExtra("address");
        mWebsiteUrl = intent.getStringExtra("websiteUrl");


        //Find the place's ImageView in the place_info.xml layout with the ID info_image
        ImageView imageView = findViewById(R.id.info_image);
        //set this image on the ImageView
        imageView.setImageResource(mImageId);

        // Find the TextView in the place_info.xml layout with the ID place_name
        TextView placeNameTextView = findViewById(R.id.place_name);
        // Get the place's name from the current Place object and
        // set this text on the placeNameTextView
        placeNameTextView.setText(mName);

        // Find the TextView in the place_info.xml layout with the ID description
        TextView descriptionTextView = findViewById(R.id.description);
        // Get the place's long description from the current Place object and
        // set this text on the descriptionTextView
        descriptionTextView.setText(mLongDescription);

        // Find the TextView in the place_info.xml layout with the ID address
        TextView addressTextView = findViewById(R.id.address);
        // Get the place's address from the current Place object and
        // set this text on the addressTextView
        addressTextView.setText(mAddress);

        // Find the View in the place_info.xml layout with the ID address
        View websiteUrlTextView = findViewById(R.id.website);
        // Get the place's website url from the current Place object

        websiteUrlTextView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // do a null check on the website url to avoid null exception
                if (mWebsiteUrl != null) {

                    //Set intent to go to the current place's website
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(mWebsiteUrl));
                    startActivity(i);

                }

            }

        });

    }


}
