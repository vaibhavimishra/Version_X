package com.example.apu5n.version_x;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PujaList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puja_list);
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
