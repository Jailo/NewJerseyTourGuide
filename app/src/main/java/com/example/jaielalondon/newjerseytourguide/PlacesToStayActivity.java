package com.example.jaielalondon.newjerseytourguide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by jaielalondon on 6/4/18.
 */

public class PlacesToStayActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content view to tab_swipe layout
        setContentView(R.layout.tab_swipe);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        // Create an adapter that knows which fragment should be shown on each page
        CategoryAdapter adapter = new CategoryAdapter(getSupportFragmentManager(),
                PlacesToStayActivity.this);

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Find the TabLayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);

        // Connect the TabLayout to ViewPager
        tabLayout.setupWithViewPager(viewPager);

    }
}
