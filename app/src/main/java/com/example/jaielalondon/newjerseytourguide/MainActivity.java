package com.example.jaielalondon.newjerseytourguide;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find things to do view container
        View thingsToDo = (View) findViewById(R.id.things_to_do_container);

        // Find food and drink view container
        View foodAndDrink = (View) findViewById(R.id.food_and_drink_container);

        // Find shopping view container
        View shopping = (View) findViewById(R.id.shopping_container);

        // Find places to stay view container
        View placesToStay = (View) findViewById(R.id.places_to_stay_container);

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
                        FoodAndDrinkActivity.class);
                startActivity(intent);
            }
        });

        shopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When shopping view is clicked, set intent to go to ShoppingActivity
                Intent intent = new Intent(MainActivity.this,
                        ShoppingActivity.class);
                startActivity(intent);
            }
        });

        placesToStay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When placesToStay View is clicked, set intent to go to PlacesToStayActivity
                Intent intent = new Intent(MainActivity.this,
                        PlacesToStayActivity.class);
                startActivity(intent);
            }
        });

    }
}
