package com.ahmetyilmaz.signipays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView1);

        //DATA

        final ArrayList<String> landmarkNames=new ArrayList<>();
        landmarkNames.add("Pisa");
        landmarkNames.add("Eiffel");
        landmarkNames.add("Collesseo");
        landmarkNames.add("London Bridge");

        final ArrayList<String> countryNames=new ArrayList<>();
        countryNames.add("Italy");
        countryNames.add("France");
        countryNames.add("Italy");
        countryNames.add("United Kingdom");

        Bitmap pisa = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.pisa);
        Bitmap eiffel = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.eiffel);
        Bitmap colesseo = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.colesseo);
        Bitmap londonBridge = BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.londonbridge);

        final ArrayList<Bitmap> landmarkImages = new ArrayList<>();
        landmarkImages.add(pisa);
        landmarkImages.add(eiffel);
        landmarkImages.add(colesseo);
        landmarkImages.add(londonBridge);

        //LISTVIEW

        ArrayAdapter arrayAdapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,landmarkNames);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //System.out.println(landmarkNames.get(position));
                //System.out.println(countryNames.get(position));


                Intent intent1=new Intent(getApplicationContext(),DetailActivity.class);
                //Bilgi Aktarmak Transfer Donnees
                intent1.putExtra("name",landmarkNames.get(position));
                intent1.putExtra("countryText",countryNames.get(position));
                //selected image charging
                Singleton singleton=Singleton.getInstance();
                singleton.setChosenImage(landmarkImages.get(position));

                startActivity(intent1);
            }
        });
    }
}
