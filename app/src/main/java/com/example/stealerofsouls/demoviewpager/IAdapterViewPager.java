package com.example.stealerofsouls.demoviewpager;


import com.example.stealerofsouls.demoviewpager.models.ItemDataTypeNews;

/**
 * Created by honghiep on 29/06/2017.
 */

public interface IAdapterViewPager {
    int countViewPager();
    ItemDataTypeNews getItemDataViewPager(int position);
}

