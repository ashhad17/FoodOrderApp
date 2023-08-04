package com.example.foodater.Adapter;

import android.content.Context;
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

import java.util.List;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder> {

    private Context context;
    private List<FoodDomain> foodList;



    public CategoryListAdapter(Context context, List<FoodDomain> foodList) {
        this.context = context;
        this.foodList = foodList;
    }
     @Override
    public CategoryListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
         return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryListAdapter.ViewHolder holder, int position) {
        FoodDomain food=foodList.get(position);

        holder.title.setText(food.getTitle());
        holder.fee.setText(String.valueOf(food.getFee()));
        int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(food.getPic(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.pic);
        holder.cardLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(holder.itemView.getContext(), FoodActivity.class);
                intent.putExtra("object",foodList.get(position));
                holder.itemView.getContext().startActivity(intent);
//                intent.putExtra("titleShow",food.getTitle());
//                intent.putExtra("picShow",food.getPic());
//                intent.putExtra("descShow",food.getDescription());
//                intent.putExtra("feeShow",String.valueOf(food.getFee()));
//                  intent.putExtra("pic",categoryDomains.get(position).getPic());
//                  intent.putExtra("title",categoryDomains.get(position).);

            }
        });

//        int drawableResourceId=this.get.getIdentifier(position,"drawable",this.getPackageName());
//        Glide.with(this)
//                .load(drawableResourceId)
//                .into(img);


    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView fee;
        TextView  title;
        ImageView pic;
        ConstraintLayout cardLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title=itemView.findViewById(R.id.titleList);
            fee=itemView.findViewById(R.id.feeList);
            pic=itemView.findViewById(R.id.picList);
            cardLayout=itemView.findViewById(R.id.cardLayout);

//            pic.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                }
//            });
        }

        @Override
        public void onClick(View view) {
//            int pos =this.getAdapterPosition();
//            FoodDomain food=foodList.get(pos);
//            Toast.makeText(view.getContext(),"Clicked "+String.valueOf(food.getTitle()),Toast.LENGTH_LONG).show();
//
//            Intent intent=new Intent(context, CategoryListAdapter.class);
//            intent.putExtra("pic",food.getPic());
//            intent.putExtra("title",food.getTitle());
//            intent.putExtra("fee",food.getFee());
//            context.startActivity(intent);

        }
    }
}
