package com.lonshine.idoctor.ui.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lonshine.idoctor.ui.setting.SettingsFragment;

/**
 * Created by lonshine on 15/11/10 上午12:16.
 */
public class TabPagerAdapter extends FragmentPagerAdapter {

    public static final int TAB_HOME = 0;
    public static final int TAB_ME = 1;
    public static final int TAB_COUNT = 2;

    int mDiscoverInitTab = 0;
    HomeFragment mHomeFragment;
    InfoFragment mInfoFragment;
    SettingsFragment mSettingsFragment;

    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setDiscoverInitTab(int discoverInitTab) {
        mDiscoverInitTab = discoverInitTab;
    }

    public InfoFragment getInfoFragment() {
        return mInfoFragment;
    }

    @Override
    public int getCount() {
        return TAB_COUNT;
    }


    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case TAB_HOME:
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                }
                fragment = mHomeFragment;
                break;
            case TAB_ME:
//                if (mInfoFragment == null) {
//                    mInfoFragment = new InfoFragment();
//                }
//                fragment = mInfoFragment;
                if (mSettingsFragment == null) {
                    mSettingsFragment = new SettingsFragment();
                }
                fragment = mSettingsFragment;
                break;
        }
        return fragment;
    }

}