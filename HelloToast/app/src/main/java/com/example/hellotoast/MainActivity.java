package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int count = 0;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textview);

    }


    public void displayToastMessage(View view) {
        //Toast.makeaText(context,"displayed Message",time duration)
        //Context==>Application environment or class environment
        Toast.makeText(this,"Hello STEN",Toast.LENGTH_LONG).show();
    }


    public void incrementCount(View view) {
        count++;
        tv.setText(String.valueOf(count));
    }
}