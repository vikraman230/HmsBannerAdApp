package com.example.mybanneradlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BannerAdSize;
import com.huawei.hms.ads.HwAds;
import com.huawei.hms.ads.banner.BannerView;

public class CustomBannerView extends LinearLayout {
    private TypedArray typedArray;
    //Attributes
    private String bannerid;
    private BannerView bannerView;

    private LinearLayout containerLayout;
    private LinearLayout lltOrientationLayOut;
    private AdParam adParam;

    public CustomBannerView(Context context) {
        super(context);
    }

    public CustomBannerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.BannerAdControl);
        bannerid = typedArray.getString(R.styleable.BannerAdControl_adid);
        HwAds.init(context);
        adParam = new AdParam.Builder().build();
        initView();
    }

    private void initView() {

        String service = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(service);
        this.containerLayout = (LinearLayout) layoutInflater.inflate(R.layout.activity_custom_bannerview, this, true);
        this.lltOrientationLayOut = (LinearLayout) containerLayout.findViewById(R.id.root_view1);
        this.bannerView = (BannerView) containerLayout.findViewById(R.id.hw_banner_view1);
        setBannerAdId(bannerid);

    }

    private void setBannerAdId(String bannerid) {
//        hwads:adId="testw6vs28auh3"
//        hwads:bannerSize="BANNER_SIZE_360_57"
        bannerView.setAdId(bannerid);
        bannerView.setBannerAdSize(BannerAdSize.BANNER_SIZE_SMART);
        bannerView.loadAd(adParam);
    }


}
