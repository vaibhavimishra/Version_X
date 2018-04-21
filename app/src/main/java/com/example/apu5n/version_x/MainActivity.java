package com.example.apu5n.version_x;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static final Integer[] XMEN= {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e};
    private ArrayList<Integer> XMENArray = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init() {
        for(int i=0;i<XMEN.length;i++)
            XMENArray.add(XMEN[i]);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new MyAdapter(MainActivity.this,XMENArray));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == XMEN.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 4500, 4500);
    }

    public void Puja_List(View view){
        Intent Puja_List = new Intent(this,PujaList.class);
        startActivity(Puja_List);
        finish();
    }

    public void Home(View view){
        Intent Home = new Intent(this,MainActivity.class);
        startActivity(Home);
        finish();
    }

    public void Place_An_Order(View view){
        Intent Place_An_Order = new Intent(this,PlaceAnOrder.class);
        startActivity(Place_An_Order);
        finish();
    }

    public void Adhik_Mass(View view){
        Intent Place_An_Order = new Intent(this,Adhik_mass.class);
        startActivity(Place_An_Order);
        finish();
    }


}
