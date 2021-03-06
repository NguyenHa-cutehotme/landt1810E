package com.phongbm.buoi10.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.phongbm.buoi10.fragments.BaseFragment;

public class PageAdapter extends FragmentPagerAdapter {
    private BaseFragment[] arrFragment;

    public PageAdapter(FragmentManager fm, BaseFragment... arrFragment) {
        super(fm);
        this.arrFragment = arrFragment;
    }

    @Override
    public Fragment getItem(int i) {
        return arrFragment[i];
    }

    @Override
    public int getCount() {
        return arrFragment.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return arrFragment[position].getTitle();
    }
}
