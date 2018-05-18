package com.example.stealerofsouls.demoviewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


import com.example.stealerofsouls.demoviewpager.adapter.AdapterViewPager;
import com.example.stealerofsouls.demoviewpager.animation.DepthAnimationViewPager;
import com.example.stealerofsouls.demoviewpager.models.ItemDataNews;
import com.example.stealerofsouls.demoviewpager.models.ItemDataTypeNews;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements IAdapterViewPager, OnLoadMorePageListener {
    private List<ItemDataTypeNews> typeNewsList;
    private ViewPager viewPager;
    private List<ItemDataNews> list;
    private int numberPage;
    AdapterViewPager adapterViewPager;
    private List<List<ItemDataNews>> parentList;
    boolean check;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatas();
        initViews();

    }

    private void initDatas() {
        parentList = new ArrayList<>();


        typeNewsList = new ArrayList<>();
        list = new ArrayList<>();
        list.add(new ItemDataNews(R.drawable.a5giay, "a5giay"));
        list.add(new ItemDataNews(R.drawable.a24h, "a24h"));
        list.add(new ItemDataNews(R.drawable.abay, "abay"));
        list.add(new ItemDataNews(R.drawable.a5giay, "x1"));
        list.add(new ItemDataNews(R.drawable.a5giay, "x2"));
        list.add(new ItemDataNews(R.drawable.a5giay, "x3"));
        list.add(new ItemDataNews(R.drawable.a5giay, "x4"));
        list.add(new ItemDataNews(R.drawable.a5giay, "x5"));
        list.add(new ItemDataNews(R.drawable.a5giay, "x6"));
        list.add(new ItemDataNews(R.drawable.a5giay, "x7"));
        list.add(new ItemDataNews(R.drawable.a5giay, "x8"));
        list.add(new ItemDataNews(R.drawable.a5giay, "x9"));
        list.add(new ItemDataNews(R.drawable.a5giay, "x10"));
        list.add(new ItemDataNews(R.drawable.a5giay, "x11"));
        list.add(new ItemDataNews(R.drawable.a5giay, "x12"));
        list.add(new ItemDataNews(R.drawable.a5giay, "x13"));
        list.add(new ItemDataNews(R.drawable.a5giay, "x14"));
        list.add(new ItemDataNews(R.drawable.a5giay, "x15"));
        list.add(new ItemDataNews(R.drawable.a5giay, "x16"));
        list.add(new ItemDataNews(R.drawable.a5giay, "x17"));
        list.add(new ItemDataNews(R.drawable.a5giay, "x18"));
        list.add(new ItemDataNews(R.drawable.a5giay, "x19"));
        list.add(new ItemDataNews(R.drawable.a5giay, "x20"));
        list.add(new ItemDataNews(R.drawable.a5giay, "x21"));
        list.add(new ItemDataNews(R.drawable.a5giay, "x22"));
        list.add(new ItemDataNews(R.drawable.a5giay, "x23"));
        list.add(new ItemDataNews(R.drawable.a5giay, "x24"));
        list.add(new ItemDataNews(R.drawable.a5giay, "x25"));
        list.add(new ItemDataNews(R.drawable.a5giay, "x26"));
        list.add(new ItemDataNews(R.drawable.a5giay, "x27"));
        list.add(new ItemDataNews(R.drawable.a5giay, "x28"));
        list.add(new ItemDataNews(R.drawable.a5giay, "x29"));

        list.add(new ItemDataNews(R.drawable.a5giay, "x30"));
        list.add(new ItemDataNews(R.drawable.a5giay, "x31"));
        list.add(new ItemDataNews(R.drawable.a5giay, "x32"));
        list.add(new ItemDataNews(R.drawable.a5giay, "x33"));
        list.add(new ItemDataNews(R.drawable.a5giay, "x33"));


        //list.add(new ItemDataNews(R.drawable.a5giay, "xxxxxxx"));
        //list.add(new ItemDataNews(R.drawable.a5giay, "xxxxxxx"));
        //list.add(new ItemDataNews(R.drawable.a5giay, "xxxxxxx"));


        if (list.size() < 12) {
            typeNewsList.add(new ItemDataTypeNews(list, 1));
        } else {
            while (list.isEmpty() == false) {
                List<ItemDataNews> smallList = new ArrayList<>();
                while (true) {
                    if (list.size() == 0) {
                        break;
                    }
                    ItemDataNews item = list.remove(0);
                    smallList.add(item);
                    if (smallList.size() > 11) {
                        break;
                    }

                }

                typeNewsList.add(new ItemDataTypeNews(smallList, 1));
            }
        }


      //  loadMultiPage2();
    }

    private void initViews() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        adapterViewPager = new AdapterViewPager(this, this);
        viewPager.setAdapter(adapterViewPager);
        viewPager.setPageTransformer(true, new DepthAnimationViewPager());


    }

    @Override
    public int countViewPager() {
        return typeNewsList.size();
    }

    @Override
    public ItemDataTypeNews getItemDataViewPager(int position) {
        return typeNewsList.get(position);
    }


    @Override
    public void loadMorePage() {


    }

    public void loadMultiPage2() {
        int numOfSubList = list.size() / 12 + 1;

        while (numOfSubList > 0) {
            parentList.add(new ArrayList<ItemDataNews>());
            numOfSubList--;
        }

        for (int i = 0; i < list.size() - 1; i++) {
            List<ItemDataNews> smallList = parentList.get(list.size() / 12);

            smallList.add(list.get(i));

        }

        for (List<ItemDataNews> smallList : parentList) {
            typeNewsList.add(new ItemDataTypeNews(smallList, 0));
        }

    }

}
