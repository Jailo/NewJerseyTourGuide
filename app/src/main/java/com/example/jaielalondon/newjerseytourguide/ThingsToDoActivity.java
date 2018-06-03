package com.example.jaielalondon.newjerseytourguide;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by jaielalondon on 6/2/18.
 */

public class ThingsToDoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_swipe);

        getSupportActionBar().setTitle(R.string.things_to_do);

        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);

        // Create an adapter that knows which fragment should be shown on each page
        CategoryAdapter adapter = new CategoryAdapter(getSupportFragmentManager(),
                ThingsToDoActivity.this);

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Find the TabLayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);

        // Connect the TabLayout to ViewPager
        tabLayout.setupWithViewPager(viewPager);


    }
}
