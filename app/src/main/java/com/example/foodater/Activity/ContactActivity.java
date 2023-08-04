package com.example.foodater.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.foodater.R;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
    }
    public void callashhad(View view){
        // Create an Intent with the appropriate action and data
        String phoneNumber = "8197172781"; // Replace with the desired phone number
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
startActivity(intent);
        // Check if there's an app that can handle the Intent
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            // Start the activity
//            startActivity(intent);
//        }
    }
    public void mailashhad(View view){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // Use "mailto:" to specify sending an email

        // Set the recipient email address
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"ashhad733@gmail.com"});

        // Set the email subject
        intent.putExtra(Intent.EXTRA_SUBJECT, "Hello");

        // Set the email body
        intent.putExtra(Intent.EXTRA_TEXT, "Wanted to know About Application");
startActivity(intent);
        // Check if there's an app that can handle the Intent
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            // Start the activity
//            startActivity(intent);
//        }

    }
    public void callafreed(View view){

        // Create an Intent with the appropriate action and data
        String phoneNumber = "9380116126"; // Replace with the desired phone number
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(intent);
//        // Check if there's an app that can handle the Intent
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            // Start the activity
//            startActivity(intent);
//        }
    }
    public void mailafreed(View view){

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // Use "mailto:" to specify sending an email

        // Set the recipient email address
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"afreedshahid07@gmail.com"});

        // Set the email subject
        intent.putExtra(Intent.EXTRA_SUBJECT, "Hello");

        // Set the email body
        intent.putExtra(Intent.EXTRA_TEXT, "Wanted to know About Application");
         startActivity(intent);
//        // Check if there's an app that can handle the Intent
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            // Start the activity
//            startActivity(intent);
//        }
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