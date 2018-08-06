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
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    //private ViewPager mViewPager;

    int fabState = 0, numberOfDice, radioDice, otherDice;
    FloatingActionButton fab;
    //DiceFragment df = new DiceFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("Number"));
        tabLayout.addTab(tabLayout.newTab().setText("List"));
        tabLayout.addTab(tabLayout.newTab().setText("Dice"));
        tabLayout.addTab(tabLayout.newTab().setText("Cast Lots"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager mViewPager = (ViewPager) findViewById(R.id.container);
        final PagerAdapter mPagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        mViewPager.setAdapter(mPagerAdapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
                fabState = tab.getPosition();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        fab = findViewById(R.id.fab);

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
                    DiceFragment df = new DiceFragment();
                    EditText e;
                    String selectedOtherText, selectedRadioText;
                    int radioButtonID, idx;
                    RadioGroup radioGroup;
                    RadioButton r;
                    View radioButton;
                    CheckBox otherCheckBox = (CheckBox) findViewById(R.id.dice_other_checkbox);

                   if(otherCheckBox.isChecked()) {
                        e = (EditText) findViewById(R.id.dice_other_amount_input);
                        selectedOtherText = e.getText().toString();
                        df.display(view, Integer.valueOf(selectedOtherText));

                    } else {
                        radioGroup = findViewById(R.id.dice_radio_group);
                        radioButtonID = radioGroup.getCheckedRadioButtonId();
                        radioButton = radioGroup.findViewById(radioButtonID);
                        idx = radioGroup.indexOfChild(radioButton);
                        r = (RadioButton)  radioGroup.getChildAt(idx);
                        selectedRadioText = r.getText().toString();
                        df.display(view, Integer.valueOf(selectedRadioText));
                    }
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
}
