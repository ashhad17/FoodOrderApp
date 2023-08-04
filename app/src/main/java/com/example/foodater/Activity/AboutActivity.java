package com.example.foodater.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.foodater.R;

public class AboutActivity extends AppCompatActivity {
private TextView about;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        about=findViewById(R.id.aboutApp);
//        about.setText("");
    }
    public void orders(View v){
        startActivity(new Intent(v.getContext(),OrdersActivity.class));
//       startActivity(new Intent(getBaseContext(),OrdersActivity.class));
    }
    public void about(View v){
//        startActivity(new Intent(MainActivity.this,AboutActivity.class));
        startActivity(new Intent(v.getContext(),AboutActivity.class));
    }
    public void contact(View v){

//        startActivity(new Intent(MainActivity.this,ContactActivity.class));
        startActivity(new Intent(v.getContext(),ContactActivity.class));
    }

    public void cart(View v){

        startActivity(new Intent(v.getContext(),CartListActivity.class));

    }
    public void home(View v){

        startActivity(new Intent(v.getContext(),MainActivity.class));

    }
}