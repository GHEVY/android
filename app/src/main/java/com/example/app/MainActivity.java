package com.example.app;
import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements MyAdapter.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.rec_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        ArrayList<String> items = new ArrayList<>();
        items.add("America");
        items.add("Asia");
        items.add("Europe");
        items.add("Africa");
        MyAdapter adapter = new MyAdapter(items, this,this);
        recyclerView.setAdapter(new MyAdapter(items,this,this));
    }

    @Override
    public void onItemClick(int position) {
        Fragment selectedFragment = null;
        switch (position) {
            case 0:
                selectedFragment = new FragmentFirst();
                break;
            case 1:
                selectedFragment = new FragmentTwo();
                break;
            case 2:
                selectedFragment = new FragmentTree();
                break;
            case 3:
                selectedFragment = new FragmentFour();
                break;
            case  4:
                selectedFragment = new FavFragment();
                break;
        }
        if (selectedFragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, selectedFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }
}