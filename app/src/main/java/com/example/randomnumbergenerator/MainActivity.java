package com.example.randomnumbergenerator;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    int fabState = 0;
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the four
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        //int fabState = 0;
        //final FloatingActionButton fab;

        fab = findViewById(R.id.fab);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                fabState = position;
                //Snackbar.make(mViewPager.getRootView(), position+"", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });




        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fabState == 0) {
                    EditText edit = (EditText)findViewById(R.id.number_lower_bound_input);
                    int lowerBound = Integer.valueOf(edit.getText().toString());
                    edit = (EditText)findViewById(R.id.number_upper_bound_input);
                    int upperBound = Integer.valueOf(edit.getText().toString());
                    NumberFragment lf = new NumberFragment();
                    lf.display(view, lowerBound, upperBound);

                }
                if(fabState == 1) {
                    Snackbar.make(view, "List - View 2", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                if(fabState == 2) {
                    Snackbar.make(view, "Dice - View 3", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                if(fabState == 3) {
                    Snackbar.make(view, "Lots - View 4", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                else{}
            }
        });
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }





    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
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

            //return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }
    }
}
