package com.example.mybanneradlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BannerAdSize;
import com.huawei.hms.ads.HwAds;
import com.huawei.hms.ads.banner.BannerView;

public class BannerAdActivity extends AppCompatActivity {

    private AdParam adParam;
    private BannerView bottomBannerView;
    private String bannerAdid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bannerad);
        Intent intent = getIntent();
        bannerAdid = intent.getStringExtra("bannerid");


        HwAds.init(this);
        // Obtain BannerView based on the configuration in layout/ad_fragment.xml.
        bottomBannerView = findViewById(R.id.hw_banner_view);

        adParam = new AdParam.Builder().build();


        bottomBannerView.loadAd(adParam);
        // Call new BannerView(Context context) to create a BannerView class.

        BannerView topBannerView = new BannerView(this);

        topBannerView.setAdId(bannerAdid);

        topBannerView.setBannerAdSize(BannerAdSize.BANNER_SIZE_SMART);

        topBannerView.loadAd(adParam);


        RelativeLayout rootView = findViewById(R.id.root_view);

        rootView.addView(topBannerView);

    }
}