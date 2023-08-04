package com.example.foodater.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodater.Activity.CartListActivity;
import com.example.foodater.Domain.FoodDomain;
//import com.example.foodapplication.Helper.ManagementCart;
//import com.example.foodapplication.Interface.ChangeNumberItemListener;
import com.example.foodater.Helper.CartManagement;
import com.example.foodater.Helper.MyDbHandler;
import com.example.foodater.R;

import java.util.ArrayList;
import java.util.List;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder> {
    private ArrayList<FoodDomain> foodDomains;
    private Context context;

//    private ManagementCart managementCart;
//    private ChangeNumberItemListener changeNumberItemListener;

    public CartListAdapter(ArrayList<FoodDomain> foodDomains, Context context) {
        this.foodDomains = foodDomains;
        this.context=context;
//        this.managementCart = new ManagementCart(context);
//        this.changeNumberItemListener = changeNumberItemListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        holder.title.setText(foodDomains.get(position).getTitle());
        holder.feeEachItem.setText(String.valueOf(foodDomains.get(position).getFee()));
        holder.totalEachItem.setText(String.valueOf(Math.round((foodDomains.get(position).getNumberInCart() * foodDomains.get(position).getFee()) * 100) / 100));
        holder.num.setText(String.valueOf(foodDomains.get(position).getNumberInCart()));
        int drawableResourseId = holder.itemView.getContext().getResources().getIdentifier(foodDomains.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourseId).into(holder.pic);
//        int p=position;
        holder.plusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CartManagement cartManagement=new CartManagement(context);
                int cartNum=cartManagement.plusButton(foodDomains,position);
                holder.num.setText(String.valueOf(cartNum));
                context.startActivity(new Intent(context, CartListActivity.class));
            }
        });
        holder.minusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CartManagement cartManagement=new CartManagement(context);
                 int cartNum=cartManagement.minusButton(foodDomains,position);
//                finish();
                 holder.num.setText(String.valueOf(cartNum));

                context.startActivity(new Intent(context, CartListActivity.class));
            }
        });


//        holder.checkout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return foodDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, feeEachItem,checkout;
        ImageView pic, plusItem, minusItem;
        TextView totalEachItem, num;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.cartTitle);
            feeEachItem = itemView.findViewById(R.id.feeEachItem);
            pic = itemView.findViewById(R.id.piccart);
            plusItem = itemView.findViewById(R.id.pluscartbtn);
            minusItem = itemView.findViewById(R.id.minuscartbtn);
            totalEachItem = itemView.findViewById(R.id.totalEachItem);
            num = itemView.findViewById(R.id.numItemTxt);
            checkout=itemView.findViewById(R.id.checkout);
        }
    }
}
