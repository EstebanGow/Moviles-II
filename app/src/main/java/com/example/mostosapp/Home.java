package com.example.mostosapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
    public Button add, view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        add = (Button)findViewById(R.id.add);
        view = (Button)findViewById(R.id.view);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Add();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View();
            }
        });

    }

    public void Add(){
        Intent sig = new Intent(this,Register.class);
        startActivity(sig);
    }

    public void View(){
        Intent sig = new Intent(this,ViewList.class);
        startActivity(sig);
    }
}