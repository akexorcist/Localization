package com.akexorcist.localizationapp.viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akexorcist.localizationapp.R;

/**
 * Created by Akexorcist on 7/22/15 AD.
 */
public class OneFragment extends Fragment {

    public static Fragment newInstance() {
        return new OneFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container, false);
    }
}
