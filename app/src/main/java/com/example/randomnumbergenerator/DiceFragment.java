package com.example.randomnumbergenerator;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class DiceFragment extends Fragment {

    public static final String ARG_SECTION_NUMBER = "section_number_3";
    public DiceFragment() {
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
        return inflater.inflate(R.layout.fragment_dice, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void display(View view, int numberOfDice){
        //int i = 0;
        int[] n = new int[numberOfDice];
        for(int i = 0; i < numberOfDice; i++) {
            n[i] = generateRandomNumber();
        }
        Snackbar.make(view, Arrays.toString(n), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

    }

    private int generateRandomNumber() {
        Random rand = new Random();

        return rand.nextInt(6) + 1;
    }
}
