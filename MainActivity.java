package com.example.myapplicationsfd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private String appsTitle;
    private Button mFullView;
    private CardView more_apps;
    private CardView share_app;
    private CardView rating_app;
    private String packageName;
    private Object v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.appsTitle = getApplication().getString(R.string.app_name);
        this.packageName = getApplication().getPackageName();
        this.mFullView = (Button) findViewById(R.id.fullViewBtn);
        this.more_apps = (CardView) findViewById(R.id.more_apps);
        this.share_app = (CardView) findViewById(R.id.share_app);
        this.rating_app = (CardView) findViewById(R.id.rating_app);
        this.more_apps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("https://play.google.com/store/apps/developer?id=GetAppBD"));
                MainActivity.this.startActivity(intent);
            }
        });
        this.share_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent share = new Intent("android.intent.action.SEND");
                share.setType("text/plain");
                share.putExtra("android.intent.extra.SUBJECT", MainActivity.this.appsTitle);
                String applink = "https://play.google.com/store/apps/details?id=" + MainActivity.this.packageName;
                share.putExtra("android.intent.extra.TEXT", MainActivity.this.appsTitle + " - এপ্সটি ডাউনলোড করতে নিচের লিংকে যান\n\n" + applink);
                MainActivity.this.startActivity(Intent.createChooser(share, "শেয়ার করুন"));
            }
        });
        this.rating_app.setOnClickListener(new View.OnClickListener() {
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
       this.mFullView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               MainActivity.this.startActivity(new Intent(MainActivity.this, FullscreenActivity.class));
           }
       });
    }
}