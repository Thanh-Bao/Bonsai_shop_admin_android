package com.nonglam.baobaoshopadmin.model;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GroupProduct {

    private  int totalItem;
    private int pageSize;
    private Product[] list;

    public GroupProduct(int totalItem, int pageSize, Product[] list) {
        this.totalItem = totalItem;
        this.pageSize = pageSize;
        this.list = list;
    }

    public int getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(int totalItem) {
        this.totalItem = totalItem;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Product[] getList() {
        return list;
    }

    public String getListToString(){
        StringBuilder str = new StringBuilder();
        for (Product p: list) {
            str.append(p);
            str.append("/n");
        }
        return str.toString();
    }

    public void setList(Product[] list) {
        this.list = list;
    }
}
