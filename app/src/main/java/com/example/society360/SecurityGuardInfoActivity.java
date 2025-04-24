package com.example.society360;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecurityGuardInfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_guard_info);

        TextView textView = findViewById(R.id.textViewGuardInfo);
        textView.setText("Dummy Security Guards:\n\n1. Ramesh Kumar (Gate 1)\n2. Suresh Verma (Gate 2)");
    }
}