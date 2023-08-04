package com.example.foodater.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodater.Adapter.CategoryListAdapter;
import com.example.foodater.Domain.FoodDomain;
import com.example.foodater.Helper.MyDbHandler;
import com.example.foodater.R;

import java.util.ArrayList;
import java.util.List;

public class FoodListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CategoryListAdapter categoryListAdapter;
    private ArrayList<FoodDomain> foodArrayList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);
        Intent intent=getIntent();
        String title=intent.getStringExtra("title");

        recyclerView=findViewById(R.id.foodListRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        StringBuilder sb=new StringBuilder();
        MyDbHandler db = new MyDbHandler(FoodListActivity.this);
        foodArrayList=new ArrayList<>();
        switch (title){
            case "Pizza":{
                List<FoodDomain> foodList=db.getAllPizza();
                for(FoodDomain food: foodList){
                    Log.d("dbharry", "\nId: " + food.getId() + "\n" +
                            "Name: " + food.getTitle() + "\n"+
                            "Phone Number: " + food.getDescription() + "\n" );
//            sb.append("\nID: "+food.getId()).append("\nName: "+contact.getName()).append("\nNumber"+contact.getPhoneNumber());

                    foodArrayList.add(food);
                }

                break;
            }
            case "Burger":{
                List<FoodDomain> foodList=db.getAllBurgur();
                for(FoodDomain food: foodList){
                    Log.d("dbharry", "\nId: " + food.getId() + "\n" +
                            "Name: " + food.getTitle() + "\n"+
                            "Phone Number: " + food.getDescription() + "\n" );
//            sb.append("\nID: "+food.getId()).append("\nName: "+contact.getName()).append("\nNumber"+contact.getPhoneNumber());

                    foodArrayList.add(food);
                }

                break;
            }
            case "Dessert":{
                List<FoodDomain> foodList=db.getAllDonut();
                for(FoodDomain food: foodList){
                    Log.d("dbharry", "\nId: " + food.getId() + "\n" +
                            "Name: " + food.getTitle() + "\n"+
                            "Phone Number: " + food.getDescription() + "\n" );
//            sb.append("\nID: "+food.getId()).append("\nName: "+contact.getName()).append("\nNumber"+contact.getPhoneNumber());

                    foodArrayList.add(food);
                }

                break;
            }
//            case "HotDog":{
//                List<FoodDomain> foodList=db.getAllHotdog();
//                for(FoodDomain food: foodList){
//                    Log.d("dbharry", "\nId: " + food.getId() + "\n" +
//                            "Name: " + food.getTitle() + "\n"+
//                            "Phone Number: " + food.getDescription() + "\n" );
////            sb.append("\nID: "+food.getId()).append("\nName: "+contact.getName()).append("\nNumber"+contact.getPhoneNumber());
//
//                    foodArrayList.add(food);
//                }
//
//                break;
//            }
            case "Drink":{
                List<FoodDomain> foodList=db.getAllDrink();
                for(FoodDomain food: foodList){
                    Log.d("dbharry", "\nId: " + food.getId() + "\n" +
                            "Name: " + food.getTitle() + "\n"+
                            "Phone Number: " + food.getDescription() + "\n" );
//            sb.append("\nID: "+food.getId()).append("\nName: "+contact.getName()).append("\nNumber"+contact.getPhoneNumber());

                    foodArrayList.add(food);
                }

                break;
            }
        }


//        System.out.println("ArrayList"+foodList.get(0).getTitle());
        categoryListAdapter=new CategoryListAdapter(FoodListActivity.this,foodArrayList);
        recyclerView.setAdapter(categoryListAdapter);
        db.close();

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
    public void home(View v){

        startActivity(new Intent(v.getContext(),MainActivity.class));

    }

    public void cart(View v){

        startActivity(new Intent(v.getContext(),CartListActivity.class));

    }
}