package com.example.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.recyclerview);
        int images[] = {R.drawable.a,R.drawable.b,R.drawable.c,
        R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,
        R.drawable.h,R.drawable.i,R.drawable.j};

        String names[] = {"AA","Bahubali","Chirutha","Dookudu",
        "EEga","fidha","GabbarSingh","Happy","I manoharudu","Jayam"};

        rv.setLayoutManager(new LinearLayoutManager(this));
        MoviesAdapter adapter = new MoviesAdapter(this,images,names);
        rv.setAdapter(adapter);

    }
}