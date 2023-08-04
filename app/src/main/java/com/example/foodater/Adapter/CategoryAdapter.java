package com.example.foodater.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodater.Activity.FoodListActivity;
import com.example.foodater.Domain.CategoryDomain;
import com.example.foodater.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    ArrayList<CategoryDomain>categoryDomains;

    public CategoryAdapter(ArrayList<CategoryDomain> categoryDomains) {
        this.categoryDomains = categoryDomains;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_category,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
holder.categoryName.setText(categoryDomains.get(position).getTitle());

String picUrl="";
switch (position){
    case 0:{
        picUrl="pizza1";
        holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.light_orange));
        break;
    }
    case 1:{
        picUrl="burger1";
        holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.light_purple));

    break;}

    case 2:{
        picUrl="donut1";
        holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.light_pink));
    break;}
    case 3:{
        picUrl="drinks1";
        holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.light_green));
    break;}
//    case 4:{
//        picUrl="donut1";
//        holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.light_pink));
//    break;}
}

int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(picUrl,"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.categoryImage);
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String ch=categoryDomains.get(position).getTitle();
//                switch (ch){
//                    case "Pizza": {
//                        Intent intent=new Intent(holder.itemView.getContext(), PizzaListActivity.class);
//                        intent.putExtra("object",categoryDomains.get(position));
//                        holder.itemView.getContext().startActivity(intent);
//                        break;}
//                    case "Burger":{
//                        Intent intent=new Intent(holder.itemView.getContext(), BurgerListActivity.class);
//                        intent.putExtra("object",categoryDomains.get(position));
//                        holder.itemView.getContext().startActivity(intent);
//                        break;}
//                    case "Donut":{
//                        Intent intent=new Intent(holder.itemView.getContext(), DonutListActivity.class);
//                        intent.putExtra("object",foodList.get(position));
//                        holder.itemView.getContext().startActivity(intent);
//                        break;}
//                    case "HotDog":{
//                        Intent intent=new Intent(holder.itemView.getContext(), HotDogListActivity.class);
//                        intent.putExtra("object",foodList.get(position));
//                        holder.itemView.getContext().startActivity(intent);
//                        break;}
//                    case "Drink":{
//                        Intent intent=new Intent(holder.itemView.getContext(), DrinkListActivity.class);
//                        intent.putExtra("object",foodList.get(position));
//                        holder.itemView.getContext().startActivity(intent);
//                        break;}
//
//                }
                  Intent intent=new Intent(holder.itemView.getContext(), FoodListActivity.class);
                intent.putExtra("title",categoryDomains.get(position).getTitle());
//                  intent.putExtra("pic",categoryDomains.get(position).getPic());
//                  intent.putExtra("pic",categoryDomains.get(position).getPic());
//                  intent.putExtra("title",categoryDomains.get(position).);
                  holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView categoryName;
        ImageView categoryImage;
        ConstraintLayout mainLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName=itemView.findViewById(R.id.categoryName);
            categoryImage=itemView.findViewById(R.id.categoryPic);
            mainLayout=itemView.findViewById(R.id.mainLayout);
        }



    }

}
