package com.example.society360;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class SocietyDirectoryActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> residentNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_society_directory);

        listView = findViewById(R.id.residentListView);
        residentNames = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, residentNames);
        listView.setAdapter(adapter);

        new FetchResidentsTask(new FetchResidentsTask.FetchResidentsListener() {
            @Override
            public void onResidentsFetched(ArrayList<ResidentModel> residents) {
                if (residents != null && !residents.isEmpty()) {
                    for (ResidentModel resident : residents) {
                        String details = resident.getName() + " (Flat: " + resident.getFlatNo() + ", Phone: " + resident.getPhoneNumber() + ")";
                        residentNames.add(details);
                    }
                    adapter.notifyDataSetChanged();
                } else {
                    residentNames.add("No residents found");
                    adapter.notifyDataSetChanged();
                }
            }
        }).execute();
    }
}