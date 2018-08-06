package com.example.randomnumbergenerator;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Arrays;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class DiceFragment extends Fragment {

    public static final String ARG_SECTION_NUMBER = "section_number_3";
    private boolean isChecked;
    private EditText diceOtherInput, otherInput;
    private RadioGroup diceRadioGroup;
    private int numberOfRadioDice, numberOfOtherDice = 5, radioButtonID, idx;
    private String selectedRadioText, selectedOtherText;

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
        View view = inflater.inflate(R.layout.fragment_dice, container, false);
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.dice_other_checkbox);
        diceOtherInput = (EditText) view.findViewById(R.id.dice_other_amount_input);
        diceRadioGroup = (RadioGroup) view.findViewById(R.id.dice_radio_group);
        otherInput = (EditText) view.findViewById(R.id.dice_other_amount_input);

        checkBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    isChecked = true;
                    diceOtherInput.setFocusableInTouchMode(true);
                    for (int i = 0; i < diceRadioGroup.getChildCount(); i++) {
                        diceRadioGroup.getChildAt(i).setEnabled(false);
                    }

                }
                else {
                    isChecked = false;
                    diceOtherInput.setFocusable(false);
                    for (int i = 0; i < diceRadioGroup.getChildCount(); i++) {
                        diceRadioGroup.getChildAt(i).setEnabled(true);
                    }

                }
            }
        });

        // Inflate the layout for this fragment
        return view;
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

    public boolean isOtherChecked() {
        return isChecked;
    }
}
