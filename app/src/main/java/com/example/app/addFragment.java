package com.example.app;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class addFragment extends Fragment {


    Button button;
    EditText text;
    ImageItem imageItem;

    private static final String result = "res";
    private static final String continent = "con";
    Bundle args = new Bundle();


    public addFragment() {


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add, container,false);
        text = view.findViewById(R.id.edittext);
        button = view.findViewById(R.id.but);
        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                imageItem = new ImageItem(R.drawable.south,s.toString(),args.get(continent).toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        button.setOnClickListener(v -> {
            args.putParcelable(result,imageItem);


        });
        return inflater.inflate(R.layout.fragment_add, container, false);
    }
}