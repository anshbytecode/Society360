package com.example.society360;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.ViewHolder> {

    private List<DashboardItem> dashboardItems;
    private Context context;

    public DashboardAdapter(Context context, List<DashboardItem> dashboardItems) {
        this.context = context;
        this.dashboardItems = dashboardItems;
    }

    @Override
    public DashboardAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dashboard, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DashboardAdapter.ViewHolder holder, int position) {
        DashboardItem item = dashboardItems.get(position);
        holder.textView.setText(item.getTitle());
        holder.imageView.setImageResource(item.getImageResId());

        // Set OnClickListener here:
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (holder.getAdapterPosition()) {
                    case 0:
                        context.startActivity(new Intent(context, SocietyDirectoryActivity.class));
                        break;
                    case 1:
                        context.startActivity(new Intent(context, SecurityGuardInfoActivity.class));
                        break;
                    case 2:
                        context.startActivity(new Intent(context, MemberRequestsActivity.class));
                        break;
                    case 3:
                        context.startActivity(new Intent(context, VisitorManagementActivity.class));
                        break;
                    case 4:
                        context.startActivity(new Intent(context, SocietyAccountsActivity.class));
                        break;
                    case 5:
                        context.startActivity(new Intent(context, ReportActivity.class));
                        break;
                    case 6:
                        context.startActivity(new Intent(context, PollsActivity.class));
                        break;
                    case 7:
                        context.startActivity(new Intent(context, OnlineHallBookingActivity.class));
                        break;
                    case 8:
                        context.startActivity(new Intent(context, MaintenanceRentActivity.class));
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dashboardItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.dashboardItemTitle);
            imageView = itemView.findViewById(R.id.dashboardItemImage);
        }
    }
}