package com.android.todo_18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<Sport> mSportData;
    private SportsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        mRecyclerView = findViewById(R.id.recyclerView);

        // set layout manager
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));

        // to contain data
        mSportData = new ArrayList<>();

        // initialize adapter to set it to Recyclerview
        mAdapter = new SportsAdapter(this, mSportData);

        mRecyclerView.setAdapter(mAdapter);

        initializeData();

    }

    private void initializeData() {

        // get resources from XML
        TypedArray sportsImageResources = getResources().obtainTypedArray(R.array.sports_images);
        String[] sportsList = getResources().getStringArray(R.array.sports_titles);
        String[] sportsInfo = getResources().getStringArray(R.array.sports_info);

        // clear the existing data
        mSportData.clear();

        // Create the arraylist of sports object with titles and information
        for(int i = 0; i < sportsList.length; i++){
            mSportData.add(new Sport(sportsList[i], sportsInfo[i], sportsImageResources.getResourceId(i, 0)));
        }

        mAdapter.notifyDataSetChanged();
        sportsImageResources.recycle();

    }
}