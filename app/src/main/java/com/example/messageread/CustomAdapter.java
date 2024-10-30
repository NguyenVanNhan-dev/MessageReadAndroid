package com.example.messageread;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> messages;

    public CustomAdapter(Context context, ArrayList<String> messages) {
        this.context = context;
        this.messages = messages;
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int position) {
        return messages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        TextView tvSender = convertView.findViewById(R.id.tvSender);
        TextView tvMessage = convertView.findViewById(R.id.tvMessage);

        String message = messages.get(position);
        String[] parts = message.split("\n", 3);
        long smsId = Long.parseLong(parts[0].replace("ID: ", ""));
        String sender = parts[1];
        String msgContent = parts[2];

        tvSender.setText(sender);
        tvMessage.setText(msgContent);

        // Xử lý sự kiện nhấp vào mỗi mục danh sách
        convertView.setOnClickListener(v -> {
            new AlertDialog.Builder(context)
                    .setTitle("Thông tin tin nhắn")
                    .setMessage("ID: " + smsId + "\nNgười gửi: " + sender + "\nNội dung: " + msgContent)
                    .setPositiveButton("OK", (dialog, which) -> {
                        dialog.dismiss();
                    })
                    .show();
        });

        return convertView;
    }



}
