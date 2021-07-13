package com.example.Adapter;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.Domain.FoodDomain;
import com.example.kitchenette.R;
import com.example.kitchenette.ShowDetailActivity;

import java.util.ArrayList;


public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.viewHolder> {
    ArrayList<FoodDomain> FoodDomains;

    public PopularAdapter(ArrayList<FoodDomain> FoodDomains)
    {
        this.FoodDomains = FoodDomains;
    }
    @NonNull

    @Override
    public viewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular,parent,false);
        return new viewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.title.setText(FoodDomains.get(position).getTitle());
        holder.fee.setText(String.valueOf(FoodDomains.get(position).getFee()));

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(FoodDomains.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);

        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
                intent.putExtra("object", FoodDomains.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return FoodDomains.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        TextView title,fee;
        ImageView pic;
        TextView addBtn;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            fee = itemView.findViewById(R.id.fee);
            pic = itemView.findViewById(R.id.pic);
            addBtn = itemView.findViewById(R.id.addBtn);
        }
    }
}
