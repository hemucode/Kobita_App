package com.codehemu.bangla_bhlobasar_kabita;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;


public class FullscreenActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private ArrayList<ListItem> listItems;
    private RecyclerView recyclerView;
    private AdView mAdView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        // TODO: Add adView to your view hierarchy.

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        this.recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.recyclerView.setHasFixedSize(true);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.listItems = new ArrayList<ListItem>();
        this.listItems.add(new ListItem(getString(R.string.poem_1)));
        this.listItems.add(new ListItem(getString(R.string.poem_2)));
        this.listItems.add(new ListItem(getString(R.string.poem_3)));
        this.listItems.add(new ListItem(getString(R.string.poem_4)));
        this.listItems.add(new ListItem(getString(R.string.poem_5)));
        this.listItems.add(new ListItem(getString(R.string.poem_6)));
        this.listItems.add(new ListItem(getString(R.string.poem_7)));
        this.listItems.add(new ListItem(getString(R.string.poem_8)));
        this.listItems.add(new ListItem(getString(R.string.poem_9)));
        this.listItems.add(new ListItem(getString(R.string.poem_10)));
        this.listItems.add(new ListItem(getString(R.string.poem_11)));
        this.listItems.add(new ListItem(getString(R.string.poem_12)));
        this.listItems.add(new ListItem(getString(R.string.poem_13)));
        this.listItems.add(new ListItem(getString(R.string.poem_14)));
        this.listItems.add(new ListItem(getString(R.string.poem_15)));
        this.listItems.add(new ListItem(getString(R.string.poem_16)));
        this.listItems.add(new ListItem(getString(R.string.poem_17)));
        this.listItems.add(new ListItem(getString(R.string.poem_18)));
        this.listItems.add(new ListItem(getString(R.string.poem_19)));
        this.listItems.add(new ListItem(getString(R.string.poem_20)));
        this.listItems.add(new ListItem(getString(R.string.poem_21)));
        this.listItems.add(new ListItem(getString(R.string.poem_22)));
        this.listItems.add(new ListItem(getString(R.string.poem_23)));
        this.listItems.add(new ListItem(getString(R.string.poem_24)));
        this.listItems.add(new ListItem(getString(R.string.poem_25)));
        this.listItems.add(new ListItem(getString(R.string.poem_26)));
        this.listItems.add(new ListItem(getString(R.string.poem_27)));
        this.listItems.add(new ListItem(getString(R.string.poem_28)));
        this.listItems.add(new ListItem(getString(R.string.poem_29)));
        this.listItems.add(new ListItem(getString(R.string.poem_30)));
        this.listItems.add(new ListItem(getString(R.string.poem_31)));
        this.listItems.add(new ListItem(getString(R.string.poem_32)));
        this.listItems.add(new ListItem(getString(R.string.poem_33)));
        this.listItems.add(new ListItem(getString(R.string.poem_34)));
        this.listItems.add(new ListItem(getString(R.string.poem_35)));
        this.listItems.add(new ListItem(getString(R.string.poem_36)));
        this.listItems.add(new ListItem(getString(R.string.poem_37)));
        this.listItems.add(new ListItem(getString(R.string.poem_38)));
        this.listItems.add(new ListItem(getString(R.string.poem_39)));
        this.listItems.add(new ListItem(getString(R.string.poem_40)));
        this.listItems.add(new ListItem(getString(R.string.poem_41)));
        this.listItems.add(new ListItem(getString(R.string.poem_42)));
        this.listItems.add(new ListItem(getString(R.string.poem_43)));
        this.listItems.add(new ListItem(getString(R.string.poem_44)));
        this.listItems.add(new ListItem(getString(R.string.poem_45)));
        this.listItems.add(new ListItem(getString(R.string.poem_46)));
        this.listItems.add(new ListItem(getString(R.string.poem_47)));
        this.listItems.add(new ListItem(getString(R.string.poem_48)));
        this.listItems.add(new ListItem(getString(R.string.poem_49)));
        this.listItems.add(new ListItem(getString(R.string.poem_50)));

        this.adapter = new Adapts(this.listItems, this);
        this.recyclerView.setAdapter(this.adapter);
    }

}