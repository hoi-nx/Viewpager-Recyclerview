package com.example.stealerofsouls.demoviewpager.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stealerofsouls.demoviewpager.R;
import com.example.stealerofsouls.demoviewpager.models.ItemDataNews;

import java.util.List;

public class AdapterRe extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ItemDataNews> list;

    public AdapterRe(List<ItemDataNews> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gridview,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        ItemDataNews news=list.get(position);
        viewHolder.tv_name.setText(news.getName());
        viewHolder.iv_img.setImageResource(news.getIdImage());

    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
            TextView tv_name;
            ImageView iv_img;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_name=itemView.findViewById(R.id.tv_name);
            iv_img=itemView.findViewById(R.id.iv_img);
        }
    }
}
