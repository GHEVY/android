package com.example.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.app.database.CountriesBaseHelper;

import java.util.ArrayList;

public class FragmentFirst extends Fragment {
    public FragmentFirst() {
    }

    ArrayList<ImageItem> list;
    RecyclerView recyclerView1;
    CheckBox checkBox;
    Button add;
    Bundle args;
    private static final String result = "res";
    private Context mContext;
    private SQLiteDatabase mDatabase;
    private static final String continent = "con";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if(list == null){
            list = new ArrayList<>();
            list.add(new ImageItem(R.drawable.usa, "USA","AMERICA"));
            list.add(new ImageItem(R.drawable.bra, "BRAZIL","AMERICA"));
            list.add(new ImageItem(R.drawable.canada, "CANADA","AMERICA"));
        }








        View view = inflater.inflate(R.layout.fragment_first, container, false);
        add  = view.findViewById(R.id.add);
        add.setOnClickListener(v -> {
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, new addFragment());
            transaction.addToBackStack("first");
            args = new Bundle();
            args.putParcelable(continent,list.get(0));
            list.add(args.getParcelable(result));
            updateAdapter();
            transaction.commit();
        });

        recyclerView1 = view.findViewById(R.id.rec_view2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView1.setLayoutManager(layoutManager);
        SecAdapter adapter = new SecAdapter(requireContext(), list);
        recyclerView1.setAdapter(adapter);
        mContext = getContext().getApplicationContext();
        mDatabase = new CountriesBaseHelper(mContext)
                .getWritableDatabase();
        return view;
    }

    public void Add(ImageItem a){
        list.add(a);
    }

    public void updateAdapter(){
        list.add(args.getParcelable(result));
        updateAdapter();
        SecAdapter adapter = new SecAdapter(requireContext(), list);
        recyclerView1.setAdapter(adapter);
    }

}
