package com.example.society360;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DashboardAdapter dashboardAdapter;
    private List<DashboardItem> dashboardItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        recyclerView = findViewById(R.id.recyclerViewDashboard);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2)); // 2 columns grid

        dashboardItemList = new ArrayList<>();

        dashboardItemList.add(new DashboardItem("Society Directory", R.drawable.directory));
        dashboardItemList.add(new DashboardItem("Security Guard Info", R.drawable.security_guard));
        dashboardItemList.add(new DashboardItem("Member Requests", R.drawable.member_requests));
        dashboardItemList.add(new DashboardItem("Visitor Management", R.drawable.visitor));
        dashboardItemList.add(new DashboardItem("Society Accounts", R.drawable.society_account));
        dashboardItemList.add(new DashboardItem("Reports", R.drawable.reports));
        dashboardItemList.add(new DashboardItem("Polls", R.drawable.polls));
        dashboardItemList.add(new DashboardItem("Online Hall Booking", R.drawable.hall_booking));
        dashboardItemList.add(new DashboardItem("Maintenance & Rent", R.drawable.maintenance_rent));


        dashboardAdapter = new DashboardAdapter(this, dashboardItemList);
        recyclerView.setAdapter(dashboardAdapter);
    }
}