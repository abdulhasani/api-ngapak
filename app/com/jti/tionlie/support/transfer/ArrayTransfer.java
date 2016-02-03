package com.jti.tionlie.support.transfer;

import com.google.common.base.CaseFormat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 1/19/2016.
 */
public class ArrayTransfer<T>  {
    private String resource;
    private List<T> items=new ArrayList<>();

    public ArrayTransfer(Class<T> entityClass) {
        this.resource = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE,entityClass.toString());
    }

    public ArrayTransfer(Class<T> entityClass, Integer totalServerItems, List<T> items) {
        this.resource = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, entityClass.toString());
        this.items = items;
    }

    public String getResource() {
        return resource;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public List<T> getItems() {
        return items;
    }

    public void addItem(T item){
        this.items.add(item);
    }
}
