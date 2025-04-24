package com.example.society360;

public class DashboardItem {
    private String title;
    private int imageResId;

    public DashboardItem(String title, int imageResId) {
        this.title = title;
        this.imageResId = imageResId;
    }

    public String getTitle() {
        return title;
    }

    public int getImageResId() {
        return imageResId;
    }
}