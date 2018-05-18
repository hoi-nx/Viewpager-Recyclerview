package com.example.stealerofsouls.demoviewpager;


import com.example.stealerofsouls.demoviewpager.models.ItemDataNews;

/**
 * Created by honghiep on 29/06/2017.
 */

public interface IAdapterGridView {
    int countGridView();
    ItemDataNews getDataGridView(int position);
}
