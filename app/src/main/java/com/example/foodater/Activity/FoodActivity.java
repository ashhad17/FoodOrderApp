package com.example.foodater.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.foodater.Domain.FoodDomain;
import com.example.foodater.Helper.MyDbHandler;
import com.example.foodater.R;
//
//import com.bumptech.glide.Glide;
//import com.example.foodapplication.R;

public class FoodActivity extends AppCompatActivity {
TextView title,fee,desc;
    private TextView addToCartBtn;
    private TextView descriptionTxt,titleTxt,feeTxt,numOrderTxt;
    private ImageView picfood,plusbtn,minusbtn;
    private FoodDomain object;
    private int numberOrder=1;
//    private ManagementCart managementCart;
ImageView img;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        initView();
        Intent intent=getIntent();
//        FoodDomain food=intent.getStringExtra()
        object=(FoodDomain)intent.getSerializableExtra("object");

        title.setText(object.getTitle());
        fee.setText("Rs. "+object.getFee());
        desc.setText(object.getDescription());
        int drawableResourceId=this.getResources().getIdentifier(object.getPic(),"drawable",this.getPackageName());
        Glide.with(this)
                .load(drawableResourceId)
                .into(img);
        numOrderTxt.setText(String.valueOf(numberOrder));
        plusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOrder=numberOrder+1;
                numOrderTxt.setText(String.valueOf(numberOrder));
            }
        });
        minusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numberOrder>1)
                {
                    numberOrder=numberOrder-1;
                    numOrderTxt.setText(String.valueOf(numberOrder));
                }
            }
        });
        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                object.setNumberInCart(numberOrder);
                MyDbHandler db=new MyDbHandler(FoodActivity.this);
//                object.setTitle(object.);
                db.addToCart(object);
                db.close();
                Toast.makeText(getBaseContext(),"Added to Cart",Toast.LENGTH_LONG).show();
//                managementCart.insertFood(object);
            }
        });
    }
//    private void getBundle() {
//        object=(FoodDomain) getIntent().getSerializableExtra("object");
//        int drawableResourceId=this.getResources().getIdentifier(object.getPic(),"drawable",this.getPackageName());
//        Glide.with(this)
//                .load(drawableResourceId)
//                .into(picfood);
//        titleTxt.setText(object.getTitle());
//        feeTxt.setText("$"+object.getFee());
//        descriptionTxt.setText(object.getDescription());
//        numOrderTxt.setText(String.valueOf(numberOrder));
//        plusbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                numberOrder=numberOrder+1;
//                numOrderTxt.setText(String.valueOf(numberOrder));
//            }
//        });
//        minusbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(numberOrder>1)
//                {
//                    numberOrder=numberOrder-1;
//                    numOrderTxt.setText(String.valueOf(numberOrder));
//                }
//            }
//        });
//        addToCartBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                object.setNumberInCart(numberOrder);
//                managementCart.insertFood(object);
//            }
//        });
//    }

    private void initView() {
        addToCartBtn=findViewById(R.id.addToCartBtn);
//        descriptionTxt=findViewById(R.id.descriptionText);
//        titleTxt=findViewById(R.id.titleText);
//        feeTxt=findViewById(R.id.feePrice);
        numOrderTxt=findViewById(R.id.numOrderTxt);
//        picfood=findViewById(R.id.picFood);
        plusbtn=findViewById(R.id.plus);
        minusbtn=findViewById(R.id.minus);
        title=findViewById(R.id.titleShow);
//        System.out.println("FeesShow"+f);
        img=findViewById(R.id.img);
        fee=findViewById(R.id.feePopular);
        desc=findViewById(R.id.descShow);

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