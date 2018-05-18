package com.example.stealerofsouls.demoviewpager.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import com.example.stealerofsouls.demoviewpager.IAdapterViewPager;
import com.example.stealerofsouls.demoviewpager.OnLoadMorePageListener;
import com.example.stealerofsouls.demoviewpager.R;
import com.example.stealerofsouls.demoviewpager.models.ItemDataTypeNews;

/**
 * Created by honghiep on 29/06/2017.
 */

public class AdapterViewPager extends PagerAdapter {
    private IAdapterViewPager mInterf;
    private int totalCameraCount;
    private int lastVisibleItem;
    private int visibleThrehold = 5;
    private OnLoadMorePageListener pageListener;

    public AdapterViewPager(IAdapterViewPager mInterf, OnLoadMorePageListener pageListener) {
        this.mInterf = mInterf;
        this.pageListener = pageListener;
    }



    @Override
    public int getCount() {
        return mInterf.countViewPager();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public View instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View itemview = inflater.inflate(R.layout.item_view_pager, container, false);
        RecyclerView gridView = (RecyclerView) itemview.findViewById(R.id.gridview);

        ItemDataTypeNews typeNews = mInterf.getItemDataViewPager(position);
        AdapterRe adapterRe = new AdapterRe(typeNews.getListItemDataNews());
        gridView.setLayoutManager(new GridLayoutManager(container.getContext(), 2));
        gridView.setAdapter(adapterRe);
        GridLayoutManager gridLayoutManager = (GridLayoutManager) gridView.getLayoutManager();
        totalCameraCount = gridLayoutManager.getItemCount();
        lastVisibleItem=gridLayoutManager.findLastVisibleItemPosition();

        Log.d("", "instantiateItem: " + totalCameraCount + "=====" + typeNews.getListItemDataNews().size());
        Toast.makeText(container.getContext(), "instantiateItem: " + totalCameraCount + "====="+lastVisibleItem,Toast.LENGTH_LONG).show();
        if(totalCameraCount<=12){

        }else {
            pageListener.loadMorePage();

        }

        container.addView(itemview);
        return itemview;
    }
}
