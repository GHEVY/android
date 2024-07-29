package com.example.app;

import static com.example.app.R.*;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

public class FragmentTwo extends Fragment {
    public FragmentTwo() {
        // Required empty public constructor
    }
    Button add;
    Bundle args;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayList<ImageItem> list = new ArrayList<>();
        list.add(new ImageItem(R.drawable.japan, "JAPAN","ASIA"));
        list.add(new ImageItem(drawable.china, "CHINA","ASIA"));
        list.add(new ImageItem(drawable.india, "INDIA","ASIA"));
        View view1 = inflater.inflate(R.layout.fragment_two, container, false);
        RecyclerView recyclerView2 = view1.findViewById(R.id.rec_view3);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView2.setLayoutManager(layoutManager);
        SecAdapter adapter = new SecAdapter(requireContext(), list);
        recyclerView2.setAdapter(adapter);
        add  = view1.findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, new addFragment());
                args = new Bundle();
                transaction.commit();
            }
        });

        return view1;
    }
}