package com.example.evalint;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ContactActivity.class);
                startActivity(intent);

            }
        });
        ImageView imageView = findViewById(R.id.iVPortada);
        //Uso de Glide
        Glide.with(this).load("https://media-exp1.licdn.com/dms/image" +
                "/C5603AQENf8Tr9DIn4g/profile-displayphoto-shrink_200_200/0/1516266666567?" +
                "e=1615420800&v=beta&t=31C0liZ7qMF4Ym4Q2GHXPsTOux6x8vvQIYmLvzXLQmg")
                .into(imageView);
    }
//TODO 1 Arreglar interface gráfica respecto a lo solicitado
    //TODO 2 Tener una vista landscape para la mainactiviy
    //TODO 3 opcional. utilizar viewBinding en toda la MainActivity

}