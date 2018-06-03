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

        if (position == 0) {
            return new FunFragment();
        } else if (position == 1) {
            return new ToursFragment();
        } else {
            return new SportsOutdoorsFragment();
        }
    }

    /**
     *
     * @return the {@link Fragment} title string that should be displayed for the given page number
     */
    @Override
    public CharSequence getPageTitle(int position) {

        if (position == 0) {
            return mContext.getString(R.string.fun);
        } else if (position == 1) {
            return mContext.getString(R.string.sightseeing_tours);
        } else {
            return mContext.getString(R.string.sports_outdoors);
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    public Context getContext() {
        return mContext;
    }
}
