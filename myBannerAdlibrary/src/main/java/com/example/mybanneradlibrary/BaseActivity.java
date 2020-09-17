package com.example.mybanneradlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

    }
    public void setBannerAdid(String id){
        Intent intent=new Intent(getApplicationContext(),BannerAdActivity.class);
        intent.putExtra("bannerid",id);
        startActivity(intent);

    }
}