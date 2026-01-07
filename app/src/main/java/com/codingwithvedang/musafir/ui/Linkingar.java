package com.codingwithvedang.musafir.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.codingwithvedang.musafir.R;
import com.codingwithvedang.musafir.places.PlaceLevel1;
import com.codingwithvedang.musafir.places.PlacesLectureTheatres;
import com.codingwithvedang.musafir.places.PlacesToGo;

public class Linkingar extends AppCompatActivity {
    ImageView mimageview,mimageview2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linkingar);
        mimageview = findViewById(R.id.imageView);
        mimageview2 = findViewById(R.id.imageView2);
    }
    public void  Clicked1(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
    public void  Clicked2(View view){
        Intent i = new Intent(this, PlacesToGo.class);
        startActivity(i);
    }
}