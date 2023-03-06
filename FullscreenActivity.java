package com.example.myapplicationsfd;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;

import java.util.ArrayList;

public class FullscreenActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private ArrayList<ListItem> listItems;
    private RecyclerView recyclerView;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        this.recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.listItems = new ArrayList<ListItem>();

        this.listItems.add(new ListItem("হাজার তারা চাইনা আমি, একটা চাঁদ চাই,\nহাজার ফুল চাইনা আমি একটা গোলাপ চাই.\nহাজার জনম চাইনা আমি একটা জনম চাই,\nসেই জনমে যেন শুধু তোমায় আমি পাই "));
        this.listItems.add(new ListItem("তুমি আমার রঙিন স্বপ্ন, শিল্পীর রঙে ছবি,\nতুমি আমার চাঁদের আলো, সকাল বেলার রবি,\nতুমি আমার নদীর মাঝে একটি মাত্র কুল,\nতুমি আমার ভালোবাসার শিউলি বকুল ফুল "));
        this.adapter = new MyAdapter(this.listItems, this);
        this.recyclerView.setAdapter(this.adapter);
    }

}