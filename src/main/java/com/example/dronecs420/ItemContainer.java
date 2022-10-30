package com.example.dronecs420;

public abstract class ItemContainer {

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



    // name field
    private String name;

    // price field
    private int price;

    //  x Location field
    private int Lx;

    // y location field
    private int Ly;

    // length field
    private int length;

    // width field
    private int width;

    // height field
    private int height;

    // this function deletes the container
    public void deleteContainer(ItemContainer self) {
        self = null;

    }

    // ItemContainer constructor
    public ItemContainer(String containername, int containerprice, int containerx, int containery, int containerlength, int containerwidth, int containerheight){   // arguments

        // sets name field to containername
        this.name = containername;

        // sets price field to containerprice
        this.price = containerprice;

        // sets x location to containerx
        this.Lx = containerx;

        // sets y location to containery
        this.Ly = containery;

        // sets length to containerlength
        this.length = containerlength;

        // sets width to containerwidth
        this.width = containerwidth;

        // sets height to containerheight
        this.height = containerheight;
    }


    class ItemContainer extends ItemsClass {}



}
