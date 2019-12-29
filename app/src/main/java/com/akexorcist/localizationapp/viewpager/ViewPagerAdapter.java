package com.akexorcist.localizationapp.viewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * Created by Akexorcist on 7/22/15 AD.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private static final int PAGE_COUNT = 4;

    ViewPagerAdapter(FragmentManager fm) {
        super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return OneFragment.newInstance();
        } else if (position == 1) {
            return TwoFragment.newInstance();
        } else if (position == 2) {
            return ThreeFragment.newInstance();
        } else if (position == 3) {
            return HelloFragment.newInstance();
        } else {
            return HelloFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
