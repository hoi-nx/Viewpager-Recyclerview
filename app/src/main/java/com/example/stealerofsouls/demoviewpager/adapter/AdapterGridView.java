package com.example.stealerofsouls.demoviewpager.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.stealerofsouls.demoviewpager.IAdapterGridView;
import com.example.stealerofsouls.demoviewpager.R;
import com.example.stealerofsouls.demoviewpager.models.ItemDataNews;

import java.util.List;


/**
 * Created by honghiep on 29/06/2017.
 */

public class AdapterGridView extends BaseAdapter {
    private List<ItemDataNews>list;

    public AdapterGridView(List<ItemDataNews> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null){
            LayoutInflater inflater= LayoutInflater.from(viewGroup.getContext());
            Log.d("viewGoup: ",""+viewGroup.getContext());
            view=inflater.inflate(R.layout.item_gridview,viewGroup,false);
            ViewHolder holder=new ViewHolder();
            holder.iv_img=view.findViewById(R.id.iv_img);
            holder.tv_name=view.findViewById(R.id.tv_name);
            view.setTag(holder);
        }
        ViewHolder holder= (ViewHolder) view.getTag();
        ItemDataNews news=list.get(i);
        holder.tv_name.setText(news.getName());
        holder.iv_img.setImageResource(news.getIdImage());
        return view;
    }
    private class ViewHolder{
        TextView tv_name;
        ImageView iv_img;
    }
}
