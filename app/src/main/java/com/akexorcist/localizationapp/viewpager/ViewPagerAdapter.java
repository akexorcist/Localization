package com.akexorcist.localizationapp.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Akexorcist on 7/22/15 AD.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private static final int PAGE_COUNT = 4;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0) {
            fragment = OneFragment.newInstance();
        } else if (position == 1) {
            fragment = TwoFragment.newInstance();
        } else if (position == 2) {
            fragment = ThreeFragment.newInstance();
        } else if (position == 3) {
            fragment = HelloFragment.newInstance();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
