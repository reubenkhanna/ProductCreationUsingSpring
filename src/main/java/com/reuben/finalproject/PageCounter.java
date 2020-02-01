package com.reuben.finalproject;

public class PageCounter {
    private Integer pageCounter;
    public PageCounter(){
        this.pageCounter =0;
    }
    public  void increamentPageCounter(){
        this.pageCounter +=1;
    }
    public  Integer getPageCount(){
        return this.pageCounter;
    }

}
