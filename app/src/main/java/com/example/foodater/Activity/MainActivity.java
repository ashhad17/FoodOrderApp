package com.example.foodater.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.foodapplication.Adapter.CategoryAdapter;
//import com.example.foodapplication.Adapter.PopularAdapter;
//import com.example.foodapplication.Domain.CategoryDomain;
//import com.example.foodapplication.Domain.FoodDomain;
import com.example.foodater.Adapter.CategoryAdapter;
import com.example.foodater.Adapter.CategoryListAdapter;
import com.example.foodater.Adapter.PopularAdapter;
import com.example.foodater.Domain.CategoryDomain;
import com.example.foodater.Domain.FoodDomain;
import com.example.foodater.Helper.CartManagement;
import com.example.foodater.Helper.Help;
import com.example.foodater.Helper.MyDbHandler;
import com.example.foodater.Helper.Params;
import com.example.foodater.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CategoryListAdapter categoryListAdapter;
    private ArrayList<FoodDomain> foodArrayList;
    private ArrayList<String>  arrayAdapter;

private CartManagement cartManagement;
    private RecyclerView.Adapter adapter,adapter2;
    private RecyclerView recyclerViewCategoryList,recyclerViewPopularList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        add();
//        addBurger();
//        addPopulr();
//        addDonut();
//        MyDbHandler db=new MyDbHandler(this);
//        db.deleteById();
//        addDrink();
//        addHotDog();

        recyclerViewCategory();
        recyclerViewPopular();
//        bottomNavigation();
//        System.out.println("cartmanagement"+cartManagement.getTotalFee());
    }
    private void add(){
        FoodDomain foodDomain=new FoodDomain();

        foodDomain.setTitle("title11");
        foodDomain.setFee(Double.valueOf("price11"));
        foodDomain.setPic("popular11");
//        System.out.println(foodDomain.getPic());
        foodDomain.setDescription("desc11");
        MyDbHandler db=new MyDbHandler(this);
//        db.addPizza(foodDomain);
        db.addPizza(foodDomain);
        db.close();
    }
    private void addDonut(){
        FoodDomain foodDomain=new FoodDomain();
        foodDomain.setTitle("Butterscotch Mousse Cake");
        foodDomain.setFee(109.0);
        foodDomain.setPic("dessert4");
//        System.out.println(foodDomain.getPic());
        foodDomain.setDescription("Sweet temptation! Butterscotch flavored mousse");
        MyDbHandler db=new MyDbHandler(this);
        db.addDonut(foodDomain);
//        List<FoodDomain> foodList=db.getAllPizza();
//        Log.d();
        db.close();
    }
    private void addDrink(){
        FoodDomain foodDomain=new FoodDomain();
        foodDomain.setTitle("Coacola");
        foodDomain.setFee(70.0);
        foodDomain.setPic("drink1");
//        System.out.println(foodDomain.getPic());
        foodDomain.setDescription("Coca Cola Diet Coke Soft Drink, 2x300 ml Multipack");
        MyDbHandler db=new MyDbHandler(this);
        db.addDrink(foodDomain);
//        List<FoodDomain> foodList=db.getAllPizza();
//        Log.d();
        db.close();
    }
//    private void addHotDog(){
//        FoodDomain foodDomain=new FoodDomain();
//        foodDomain.setTitle("Main pizza");
//        foodDomain.setFee(12.0);
//        foodDomain.setPic("hotdogcat1");
////        System.out.println(foodDomain.getPic());
//        foodDomain.setDescription("Discription of Pizza");
//        MyDbHandler db=new MyDbHandler(this);
//        db.addHotDog(foodDomain);
////        List<FoodDomain> foodList=db.getAllPizza();
////        Log.d();
//        db.close();
//    }
//    private void addcart(){
//        FoodDomain foodDomain=new FoodDomain();
//        foodDomain.setTitle("Main pizza");
//        foodDomain.setFee(12.0);
//        foodDomain.setPic("pizza");
////        System.out.println(foodDomain.getPic());
//        foodDomain.setDescription("Discription of Pizza");
//        MyDbHandler db=new MyDbHandler(this);
//        db.addToCart(foodDomain);
////        List<FoodDomain> foodList=db.getAllPizza();
////        Log.d();
//        db.close();
//    }
    private void addBurger(){
        FoodDomain foodDomain=new FoodDomain();

        foodDomain.setTitle("title5");
        foodDomain.setFee(Double.valueOf("price5"));
        foodDomain.setPic("burger5");
//        System.out.println(foodDomain.getPic());
        foodDomain.setDescription("desc5");
        MyDbHandler db=new MyDbHandler(this);
//        db.addPizza(foodDomain);
        db.addBurger(foodDomain);
        db.close();
    }

    private void addPopulr(){
        Help h=new Help();
        FoodDomain foodDomain=new FoodDomain();
//        for(int i=1;i<11;i++){
        foodDomain.setTitle("title4");
        foodDomain.setFee(Double.valueOf("price4"));
        foodDomain.setPic("burger4");
//        System.out.println(foodDomain.getPic());
        foodDomain.setDescription("desc4");
        MyDbHandler db=new MyDbHandler(this);
//        db.addPizza(foodDomain);
            db.addPopular(foodDomain);
            db.close();
//        }
//        List<FoodDomain> foodList=db.getAllPizza();
//        Log.d();
    }
    private void bottomNavigation(){
        FloatingActionButton floatingActionButton=findViewById(R.id.cartbtn);
        LinearLayout homebtn=findViewById(R.id.homeBtn);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                MyDbHandler db=new MyDbHandler(getBaseContext());
//                int l1,l2;
//                l1=db.getSizeCart();
//                System.out.println("l1"+l1);
//                CartManagement cm=new CartManagement(getBaseContext());
                startActivity(new Intent(MainActivity.this,CartListActivity.class));
//                l2=db.getSizeCart();
//                System.out.println("l1"+l2);
//                if (l1!=l2){
//                    finish();
//                    startActivity(new Intent(MainActivity.this,CartListActivity.class));
//                }
            }
        });
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });

    }

    public double getTotalFee(){
        MyDbHandler db=new MyDbHandler(this);
        List<FoodDomain> listFood=db.getAllCart();
        double fee=0;
        for(int i=0;i<listFood.size();i++)
        {
//        System.out.println("Sout"+listFood.get(0).getFee()*listFood.get(0).getNumberInCart());
            fee=fee+(listFood.get(i).getFee() *listFood.get(i).getNumberInCart());
        }
        return fee;
    }
//
//


    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList=findViewById(R.id.recyclerViewCategory);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);
        ArrayList<CategoryDomain> category=new ArrayList<>();
        category.add(new CategoryDomain("Pizza","pizza1"));
        category.add(new CategoryDomain("Burger","burger1"));
        category.add(new CategoryDomain("Dessert","donut1"));
        category.add(new CategoryDomain("Drink","drinks1"));
//        category.add(new CategoryDomain("Donut","donut1"));
//        category.add(new CategoryDomain("Pizza","pop_1"));
        adapter=new CategoryAdapter(category);
        recyclerViewCategoryList.setAdapter(adapter);

    }
    private void recyclerViewPopular(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList=findViewById(R.id.recycleViewPopular);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);
        ArrayList<FoodDomain> foodListPopular=new ArrayList<>();
//        MyDbHandler db=new MyDbHandler(this);
//        db.getAllPizza();
//        foodList.add(new FoodDomain("Pepperoni Pizaa","pop_1","slices_pepperomo,mozerella_chese,fresh_oregano,ground_black_pepporani",9.76));
//        foodList.add(new FoodDomain("Burgar","pop_2","slices_pepperomo,mozerella_chese,fresh_oregano,ground_black_pepporani",6.47));
//        foodList.add(new FoodDomain("Mexican pizza","pop_3","slices_pepperomo,mozerella_chese,fresh_oregano,ground_black_pepporani",10.55));
////        foodList.add(new FoodDomain("Pepperoni Pizaa","pizza4","slices_pepperomo,mozerella_chese,fresh_oregano,ground_black_pepporani",9.76));
////        foodList.add(new FoodDomain("Pepperoni Pizaa","pizza5","slices_pepperomo,mozerella_chese,fresh_oregano,ground_black_pepporani",9.76));
//        adapter2=new PopularAdapter(foodList);
//        recyclerViewPopularList.setAdapter(adapter2);
        MyDbHandler db = new MyDbHandler(this);
        foodListPopular=new ArrayList<>();
        List<FoodDomain> foodList1=db.getAllPopular();
        for(FoodDomain food: foodList1){
            Log.d("dbharry", "\nId: " + food.getId() + "\n" +
                    "Name: " + food.getTitle() + "\n"+
                    "Phone Number: " + food.getDescription() + "\n" );
//            sb.append("\nID: "+food.getId()).append("\nName: "+contact.getName()).append("\nNumber"+contact.getPhoneNumber());

            foodListPopular.add(food);
        }

//        System.out.println("ArrayList"+foodList.get(0).getTitle());
        adapter2=new PopularAdapter(foodListPopular);
        recyclerViewPopularList.setAdapter(adapter2);
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