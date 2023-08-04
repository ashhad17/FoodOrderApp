package com.example.foodater.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodater.Activity.FoodActivity;
import com.example.foodater.Domain.FoodDomain;
import com.example.foodater.R;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {

    ArrayList<FoodDomain> popularFood;

    public PopularAdapter(ArrayList<FoodDomain> categoryDomains) {
        this.popularFood = categoryDomains;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_popular,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
holder.titile.setText(popularFood.get(position).getTitle());
String picUrl="";
//switch (position){
//    case 0:{
//        picUrl="cat_1";
//        holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.light_orange));
//        break;
//    }
//    case 1:{
//        picUrl="cat_2";
//        holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.light_purple));
//
//    break;}
//
//    case 2:{
//        picUrl="cat_3";
//        holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.light_blue));
//    break;}
//    case 3:{
//        picUrl="cat_4";
//        holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.light_green));
//    break;}
//    case 4:{
//        picUrl="cat_5";
//        holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.light_pink));
//    break;}
//}
        holder.fee.setText(String.valueOf(popularFood.get(position).getFee()));
        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(holder.itemView.getContext(), FoodActivity.class);
//                intent.putExtra("titleShow",popularFood.get(position).getTitle());
//                intent.putExtra("feeShow",holder.fee.getText());
//                intent.putExtra("picShow",popularFood.get(position).getPic());
//                intent.putExtra("descShow",popularFood.get(position).getDescription());
                intent.putExtra("object",popularFood.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(popularFood.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return popularFood.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView titile,fee;
        ImageView pic;
        TextView addBtn;
        ConstraintLayout mainLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titile=itemView.findViewById(R.id.titlePopular);
            fee=itemView.findViewById(R.id.feePopular);
            pic=itemView.findViewById(R.id.picPopular);
            addBtn=itemView.findViewById(R.id.addBtn);
        }
    }

}
