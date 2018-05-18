package com.example.stealerofsouls.demoviewpager.animation;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by honghiep on 29/06/2017.
 */

public class DepthAnimationViewPager implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View page, float position) {
        int pageWidth=page.getWidth();
        if(position<-1){
            page.setAlpha(0);
            return;
        }
        if(position<=0){
            page.setAlpha(1);
            page.setTranslationX(0);
            page.setScaleX(1);
            page.setScaleY(1);
            return;
        }
        if(position<=1){
            page.setAlpha((float) (1- Math.sqrt(position)));
            page.setTranslationX(pageWidth*-position);
            float scale=1-position*position*position*position;
            page.setScaleX(scale);
            page.setScaleY(scale);
            return;
        }
        page.setAlpha(0);
    }
}
