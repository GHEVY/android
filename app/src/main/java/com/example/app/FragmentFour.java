package com.example.app;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FragmentFour extends Fragment {
    public FragmentFour() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayList<ImageItem> list = new ArrayList<>();
        list.add(new ImageItem(R.drawable.nigeria, "NIGERIA","AFRICA"));
        list.add(new ImageItem(R.drawable.kenya, "KENIA","AFRICA"));
        list.add(new ImageItem(R.drawable.south, "South Africa","AFRICA"));

        View view = inflater.inflate(R.layout.fragment_four, container, false);
        RecyclerView recyclerView1 = view.findViewById(R.id.rec_view5);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView1.setLayoutManager(layoutManager);
        SecAdapter adapter = new SecAdapter(requireContext(), list);
        recyclerView1.setAdapter(adapter);

        return view;
    }
}