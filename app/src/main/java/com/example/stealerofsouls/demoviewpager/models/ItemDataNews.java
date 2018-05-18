package com.example.stealerofsouls.demoviewpager.models;

/**
 * Created by honghiep on 29/06/2017.
 */

public class ItemDataNews {
    private int idImage;
    private String name;
    public ItemDataNews(int idImage, String name){
        this.idImage=idImage;
        this.name=name;
    }
    public int getIdImage(){
        return idImage;
    }
    public String getName(){
        return name;
    }
}
