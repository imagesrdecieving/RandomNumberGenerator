package com.example.randomnumbergenerator;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    public static final String ARG_SECTION_NUMBER = "section_number_2";
    private String input;
    private EditText editInput;
    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

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

    public int getRandomItemFromList(int numberOfItems) {
        Random rand = new Random();

        return rand.nextInt(numberOfItems);
    }
}
