package com.example.messageread;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MessageListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_list);

        ListView listView = findViewById(R.id.listViewMessages);
        SharedPreferences sharedPreferences = getSharedPreferences("sms_prefs", MODE_PRIVATE);

        
        Set<String> smsSet = sharedPreferences.getStringSet("sms_list", new HashSet<>());
        ArrayList<String> smsList = new ArrayList<>(smsSet);

        if (smsList != null) {
            CustomAdapter adapter = new CustomAdapter(this, smsList);
            listView.setAdapter(adapter);
        }
    }
}
