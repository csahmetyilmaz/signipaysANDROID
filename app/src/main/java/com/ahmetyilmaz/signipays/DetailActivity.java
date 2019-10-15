package com.ahmetyilmaz.signipays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView=findViewById(R.id.imageView1);
        TextView landmarkNameText=findViewById(R.id.landmarkNameText);
        TextView countryNameText=findViewById(R.id.countryNameText);

        Intent intentD=getIntent();
        String landmarkNameD=intentD.getStringExtra("name");
        String countryNameD =intentD.getStringExtra("countryText");

        //Singleton object retrieving
        Singleton singleton=Singleton.getInstance();
        imageView.setImageBitmap(singleton.getChosenImage());

        landmarkNameText.setText(landmarkNameD);
        countryNameText.setText(countryNameD);

    }
}
