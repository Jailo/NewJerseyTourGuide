package com.example.jaielalondon.newjerseytourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by jaielalondon on 6/2/18.
 */

public class CategoryAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public CategoryAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {


        if (this.mContext instanceof ThingsToDoActivity){
            // Checks if the current activity is ThingsToDoActivity

            if (position == 0) {
                // If on the first tab position,
                // return FunFragment
                return new FunFragment();
            } else if (position == 1) {
                // If on the second tab position,
                // return ToursFragment
                return new ToursFragment();
            } else {
                // If on the third tab position,
                // return SportsOutdoorsFragment
                return new SportsOutdoorsFragment();
            }

        } else if (this.mContext instanceof FoodAndDrinkActivity) {
            // Checks if the current activity is FoodAndDrinkActivity

            if (position == 0) {
                // If on the first tab position,
                // return ResturantFragment
                return new ResturantFragment();
            } else if (position == 1) {
                // If on the second tab position,
                // return CafesAndTreatsFragment
                return new CafesAndTreatsFragment();
            } else {
                // If on the third tab position,
                // return WineriesAndBarsFragment
                return new WineriesAndBarsFragment();
            }

        } else if (this.mContext instanceof ShoppingActivity){
            // Checks if the current activity is ShoppingActivity

            if (position == 0) {
                // If on the first tab position,
                // return MallsFragment
                return new MallsFragment();
            } else if (position == 1) {
                // If on the second tab position,
                // return AntiquingFragment
                return new AntiquingFragment();
            } else {
                // If on the third tab position,
                // return FleaAndFarmersMarketFragment
                return new FleaAndFarmersMarketsFragment();
            }
        } else {
            // Checks if the current activity is PlacesToStayActivity

            if (position == 0) {
                // If on the first tab position,
                // return resturants string.xml resource
                return new HotelsFragment();
            } else if (position == 1) {
                // If on the second tab position,
                // return cafes_and_treats string.xml resource
                return new BedAndBreakfastsFragment();
            } else {
                // If on the third tab position,
                // return wineries_and_bars string.xml resource
                return new ResortsFragment();
            }
        }

    }

    /**
     *
     * @return the {@link Fragment} title string that should be displayed for the given page number
     */
    @Override
    public CharSequence getPageTitle(int position) {

        if (this.mContext instanceof ThingsToDoActivity) {
            // Checks if the current activity is ThingsToDoActivity

            if (position == 0) {
                // If on the first tab position,
                // return fun string.xml resource
                return mContext.getString(R.string.fun);
            } else if (position == 1) {
                // If on the second tab position,
                // return sightseeing_tours string.xml resource
                return mContext.getString(R.string.sightseeing_tours);
            } else {
                // If on the third tab position,
                // return sports_outdoors string.xml resource
                return mContext.getString(R.string.sports_outdoors);

            }

        } else if (this.mContext instanceof FoodAndDrinkActivity) {
            // Checks if the current activity is FoodAndDrinkActivity

            if (position == 0) {
                // If on the first tab position,
                // return resturants string.xml resource
                return mContext.getString(R.string.restaurants);
            } else if (position == 1) {
                // If on the second tab position,
                // return cafes_and_treats string.xml resource
                return mContext.getString(R.string.cafes_and_treats);
            } else {
                // If on the third tab position,
                // return wineries_and_bars string.xml resource
                return mContext.getString(R.string.wineries_and_bars);
            }

        } else if (this.mContext instanceof ShoppingActivity){
            // Checks if the current activity is ShoppingActivity

            if (position == 0) {
                // If on the first tab position,
                // return resturants string.xml resource
                return mContext.getString(R.string.malls);
            } else if (position == 1) {
                // If on the second tab position,
                // return cafes_and_treats string.xml resource
                return mContext.getString(R.string.antiquing);
            } else {
                // If on the third tab position,
                // return wineries_and_bars string.xml resource
                return mContext.getString(R.string.flea_and_farmers_markets);
            }
        } else {
            // Checks if the current activity is PlacesToStayActivity

            if (position == 0) {
                // If on the first tab position,
                // return hotels string.xml resource
                return mContext.getString(R.string.hotels);
            } else if (position == 1) {
                // If on the second tab position,
                // return bed_and_breakfasts string.xml resource
                return mContext.getString(R.string.bed_and_breakfasts);
            } else {
                // If on the third tab position,
                // return resorts string.xml resource
                return mContext.getString(R.string.resorts);
            }
        }
    }

    /**
     *
     * @return number of tabs
     */
    @Override
    public int getCount() {
        return 3;
    }

    public Context getContext() {
        return mContext;
    }
}
