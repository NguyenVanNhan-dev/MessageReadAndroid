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

        
        String sender = getIntent().getStringExtra("sender");
        String message = getIntent().getStringExtra("message");

        
        tvSenderDetail.setText(sender);
        tvMessageDetail.setText(message);
    }
}
