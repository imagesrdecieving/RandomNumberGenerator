package com.example.randomnumbergenerator;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class NumberFragment extends Fragment {

    public static final String ARG_SECTION_NUMBER = "section_number_1";
    public NumberFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_number, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void display(View view, int lowerBound, int upperBound){
        int number = generateRandomNumber(lowerBound, upperBound);

        Snackbar.make(view, number+"", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    private int generateRandomNumber(int lowerBound, int upperBound) {
        Random rand = new Random();

        int  n = rand.nextInt(upperBound) + lowerBound;

        return n;
    }
}
