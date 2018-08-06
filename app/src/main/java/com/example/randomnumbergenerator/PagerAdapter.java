package com.example.randomnumbergenerator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        switch (position) {
            case 0:
                Fragment fragment = new NumberFragment();
                Bundle args = new Bundle();
                args.putInt(NumberFragment.ARG_SECTION_NUMBER, position + 1);
                fragment.setArguments(args);
                return fragment;

            case 1:
                Fragment fragment2 = new ListFragment();
                Bundle args2 = new Bundle();
                args2.putInt(ListFragment.ARG_SECTION_NUMBER, position + 2);
                fragment2.setArguments(args2);
                return fragment2;

            case 2:
                Fragment fragment3 = new DiceFragment();
                Bundle args3 = new Bundle();
                args3.putInt(DiceFragment.ARG_SECTION_NUMBER, position + 3);
                fragment3.setArguments(args3);
                return fragment3;

            case 3:

                Fragment fragment4 = new CastLotsFragment();
                Bundle args4 = new Bundle();
                args4.putInt(CastLotsFragment.ARG_SECTION_NUMBER, position + 4);
                fragment4.setArguments(args4);
                return fragment4;


            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
