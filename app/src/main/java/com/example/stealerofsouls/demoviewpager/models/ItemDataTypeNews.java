package com.example.stealerofsouls.demoviewpager.models;

import com.example.stealerofsouls.demoviewpager.IAdapterGridView;

import java.util.ArrayList;
import java.util.List;


public class ItemDataTypeNews {
    private List<ItemDataNews> listItemDataNews;
    private int nameTypeNews;

    public ItemDataTypeNews(int nameTypeNews) {
        this.nameTypeNews = nameTypeNews;
        listItemDataNews = new ArrayList<>();
    }

    public ItemDataTypeNews() {
    }

    public ItemDataTypeNews(List<ItemDataNews> listItemDataNews, int nameTypeNews) {
        this.listItemDataNews = listItemDataNews;
        this.nameTypeNews = nameTypeNews;
    }

    public void setListItemDataNews(List<ItemDataNews> listItemDataNews) {
        this.listItemDataNews = listItemDataNews;
    }

    public void setNameTypeNews(int nameTypeNews) {
        this.nameTypeNews = nameTypeNews;
    }

    public List<ItemDataNews> getListItemDataNews() {
        return listItemDataNews;
    }

    public int getNameTypeNews() {
        return nameTypeNews;
    }

    public void addData(ItemDataNews itemDataNews) {
        listItemDataNews.add(itemDataNews);
    }


}
