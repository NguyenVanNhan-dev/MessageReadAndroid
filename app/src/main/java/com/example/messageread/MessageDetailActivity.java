package com.example.messageread;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MessageDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_detail);

        TextView tvSenderDetail = findViewById(R.id.tvSenderDetail);
        TextView tvMessageDetail = findViewById(R.id.tvMessageDetail);

        // Nhận dữ liệu tin nhắn từ Intent
        String sender = getIntent().getStringExtra("sender");
        String message = getIntent().getStringExtra("message");

        // Hiển thị dữ liệu tin nhắn
        tvSenderDetail.setText(sender);
        tvMessageDetail.setText(message);
    }
}
