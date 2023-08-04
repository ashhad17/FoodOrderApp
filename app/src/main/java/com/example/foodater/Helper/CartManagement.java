package com.example.foodater.Helper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.foodater.Activity.CartListActivity;
import com.example.foodater.Activity.MainActivity;
import com.example.foodater.Domain.FoodDomain;

import java.util.ArrayList;
import java.util.List;

public class CartManagement {

    private  Context context;

    public CartManagement(Context context){
        this.context=context;
    }
    public int plusButton(ArrayList<FoodDomain> foodDomains,int position){
        MyDbHandler db=new MyDbHandler(context);

        foodDomains.get(position).setNumberInCart(foodDomains.get(position).getNumberInCart()+1);
        db.updateCart(foodDomains,position);
        db.close();
//        Toast.makeText(context,"Cart"+foodDomains.get(position).getNumberInCart(),Toast.LENGTH_LONG).show();
         return foodDomains.get(position).getNumberInCart();
    }
    public int minusButton(ArrayList<FoodDomain> foodDomains,int position){
        MyDbHandler db=new MyDbHandler(context);

        if(foodDomains.get(position).getNumberInCart()==1)
        {
//            Toast.makeText(context,"Empty"+foodDomains.get(position).getNumberInCart(),Toast.LENGTH_LONG).show();
            db.deleteInCartById(foodDomains.get(position).getId());
            MainActivity m=new MainActivity();
//            context.stopService(new Intent(context,CartListActivity.class));
            context.startActivity(new Intent(context,CartListActivity.class));
            //            context.startActivity(new Intent(context, CartListActivity.class));
        } else if (foodDomains.get(position).getNumberInCart()>1) {
            foodDomains.get(position).setNumberInCart(foodDomains.get(position).getNumberInCart()-1);
            db.updateCart(foodDomains,position);
            db.close();
        }
//        db.updateCart(food);
//        Toast.makeText(context,"Cart"+foodDomains.get(position).getNumberInCart(),Toast.LENGTH_LONG).show();
        return foodDomains.get(position).getNumberInCart();
    }
    public List<FoodDomain> getListCart()
    {
        MyDbHandler db=new MyDbHandler(context);
//        List<FoodDomain> foodList=;
        return db.getAllCart();
    }
    public double getTotalFee(){
        MyDbHandler db=new MyDbHandler(context);
        List<FoodDomain> listFood=db.getAllCart();
        double fee=0;
        for(int i=0;i<listFood.size();i++)
        {
//            System.out.println("Sout"+listFood.get(0).getFee()*listFood.get(0).getNumberInCart());
            fee=fee+(listFood.get(i).getFee() *listFood.get(i).getNumberInCart());
        }
        return fee;
    }


}
