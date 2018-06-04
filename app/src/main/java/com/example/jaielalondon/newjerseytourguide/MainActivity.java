package com.example.jaielalondon.newjerseytourguide;

import android.app.ActionBar;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find things to do view container
        View thingsToDo = (View) findViewById(R.id.things_to_do_container);

        // Find food and drink view container
        View foodAndDrink = (View) findViewById(R.id.food_and_drink_container);

        thingsToDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // When thingsToDo View is clicked, set intent to go to ThingsToDoActivity
                Intent intent = new Intent(MainActivity.this,
                        ThingsToDoActivity.class);
                startActivity(intent);
            }
        });

        foodAndDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // When foodAndDrink View is clicked, set intent to go to FoodAndDrinkActivity
                Intent intent = new Intent(MainActivity.this,
                        FoodAndDrink.class);
                startActivity(intent);
            }
        });

    }
}
