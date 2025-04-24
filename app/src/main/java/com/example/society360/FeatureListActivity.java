package com.example.society360;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FeatureListActivity extends AppCompatActivity {

    private TextView titleTextView;
    private ListView listView;
    private ArrayList<String> dummyList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feature_list);

        titleTextView = findViewById(R.id.featureTitle);
        listView = findViewById(R.id.featureListView);

        // Get feature type
        String featureType = getIntent().getStringExtra("featureType");

        dummyList = new ArrayList<>();

        if (featureType != null) {
            if (featureType.equals("hall_booking")) {
                titleTextView.setText("Online Hall Booking");
                dummyList.add("Community Hall A - Available");
                dummyList.add("Community Hall B - Booked");
                dummyList.add("Banquet Hall C - Available");
            } else if (featureType.equals("maintenance_rent")) {
                titleTextView.setText("Maintenance & Rent");
                dummyList.add("Flat 101 - Maintenance Due: ₹2000");
                dummyList.add("Flat 102 - Rent Paid");
                dummyList.add("Flat 103 - Maintenance Paid");
            }
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dummyList);
        listView.setAdapter(adapter);
    }
}