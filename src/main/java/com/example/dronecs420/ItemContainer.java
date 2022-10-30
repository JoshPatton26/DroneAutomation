package com.example.dronecs420;

import java.util.ArrayList;

public abstract class ItemContainer {

    ArrayList ItemContainer = new ArrayList();

    /*public void add(ItemContainer, newItemContainer){
        throw new UnsupportedOperationException();
    } */

    /*public void remove(ItemContainer, newItemContainer){
        throw new UnsupportedOperationException();
    }*/

    public ItemContainer getComponent(int componentIndex){
        throw new UnsupportedOperationException();
    }

    public String getNewItem(){
        throw new UnsupportedOperationException();
    }

    public String getNewItemContainer(){
        throw new UnsupportedOperationException();
    }

    public void diplsayItemContainerInfo(){
        throw new UnsupportedOperationException();
    }
}
