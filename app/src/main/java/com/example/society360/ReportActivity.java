package com.example.society360;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ReportActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);

        TextView textView = findViewById(R.id.textViewReports);
        textView.setText("Dummy Reports:\n\n- Water Leakage Report\n- Parking Issue Report\n- Lighting Issue Report");
    }
}