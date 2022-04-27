package com.sangsolutions.sleep.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.sangsolutions.sleep.FactorSingleton;
import com.sangsolutions.sleep.FactorsActivity;
import com.sangsolutions.sleep.R;

import java.util.ArrayList;
import java.util.List;

public class FactorAdapter extends RecyclerView.Adapter<FactorAdapter.ViewHolder> {

    List<Factor> list;
    Context context;

    public FactorAdapter(Context context, List<Factor> list) {
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.adapter_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.factor.setText(list.get(position).name);
        if(list.get(position).isbSelected()) {
            holder.parentCard.setBackgroundColor(Color.parseColor("#87CF31"));
        }

        holder.parentCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!list.get(position).isbSelected()) {
                    list.get(position).setbSelected(true);
                    holder.parentCard.setBackgroundColor(Color.parseColor("#87CF31"));

                }else {
                    list.get(position).setbSelected(false);
                    holder.parentCard.setBackgroundColor(Color.WHITE);
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView factor;
        CardView parentCard;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            factor=itemView.findViewById(R.id.factor);
            parentCard=itemView.findViewById(R.id.parentCard);
        }
    }
}
