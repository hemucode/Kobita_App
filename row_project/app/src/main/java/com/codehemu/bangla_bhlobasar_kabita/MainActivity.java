package com.codehemu.bangla_bhlobasar_kabita;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;


public class MainActivity extends AppCompatActivity {
    private String appsName;
    private Button viewButton;
    private CardView moreButton;
    private CardView shareButton;
    private CardView rateButton;
    private String packageName;
    private InterstitialAd mInterstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
        setAds();
        this.appsName = getApplication().getString(R.string.app_name);
        this.packageName = getApplication().getPackageName();

        // ভালোবাসারকবিতা More Button Create
        this.moreButton = (CardView) findViewById(R.id.more_button);
        this.moreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("https://www.downloadhub.cloud/p/bangla-app.html"));
                MainActivity.this.startActivity(intent);
            }
        });

        // ভালোবাসারকবিতা Share Button Create
        this.shareButton = (CardView) findViewById(R.id.share_button);
        this.shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent share = new Intent("android.intent.action.SEND");
                share.setType("text/plain");
                share.putExtra("android.intent.extra.SUBJECT", MainActivity.this.appsName);
                String APP_Download_URL = "https://play.google.com/store/apps/details?id=" + MainActivity.this.packageName;
                share.putExtra("android.intent.extra.TEXT", MainActivity.this.appsName + " - এপ্সটি ডাউনলোড করতে নিচের লিংকে যান\n\n" + APP_Download_URL);
                MainActivity.this.startActivity(Intent.createChooser(share, "শেয়ার করুন"));
            }
        });
        // ভালোবাসারকবিতা Rate Button Create
        this.rateButton = (CardView) findViewById(R.id.rate_button);
        this.rateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse("market://details?id=" + MainActivity.this.packageName));
                    MainActivity.this.startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    intent2.setData(Uri.parse("https://play.google.com/store/apps/developer?id=" + MainActivity.this.packageName));
                    MainActivity.this.startActivity(intent2);
                }
            }
        });

        // ভালোবাসারকবিতা View Button Create

        this.viewButton = (Button) findViewById(R.id.view_button);
        this.viewButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(MainActivity.this);
                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent();
                            MainActivity.this.startActivity(new Intent(MainActivity.this, FullscreenActivity.class));
                            mInterstitialAd = null;
                            setAds();
                        }
                    });

                }else {
                    MainActivity.this.startActivity(new Intent(MainActivity.this, FullscreenActivity.class));
                }
            }
        });

    }
    public void setAds(){
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,getString(R.string.Inter_adUnitId), adRequest,
            new InterstitialAdLoadCallback() {
                @Override
                public void onAdLoaded(InterstitialAd interstitialAd) {
                    // The mInterstitialAd reference will be null until
                    // an ad is loaded.
                    mInterstitialAd = interstitialAd;
                }

                @Override
                public void onAdFailedToLoad(LoadAdError loadAdError) {
                    // Handle the error
                    mInterstitialAd = null;
                }
            });
    }

}