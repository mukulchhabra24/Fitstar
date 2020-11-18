package com.example.fitstar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class itemsAdapter extends RecyclerView.Adapter<itemsAdapter.ViewHolder> {
    List<String> items;
    String item;
    Context context;
    public itemsAdapter(Context context, List<String> items) {
        this.items=items;
        this.context=context;
    }

    public String getItem() {
        return item;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View chooseView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1,parent,false);
        return new ViewHolder(chooseView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        item= items.get(position);
        holder.bind(item);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( context, thirdActivity.class);
                i.putExtra("item",items.get(position));
                context.startActivity(i);

            }
        });


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem= itemView.findViewById(android.R.id.text1);
        }

        public void bind(String item) {
            tvItem.setText(item);



        }
    }
}
