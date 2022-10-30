package com.example.dronecs420;

import java.util.ArrayList;
public class ItemContainer extends ItemsClass {
    // name field
//    ItemContainer(){
//        name = "test";
//        price = 69;
//        Lx = 420;
//        Ly = -420;
//        length = 8;
//        width = 8;
//        height = 8;
//    }
    ArrayList<ItemsClass> containerList = new ArrayList<ItemsClass>();

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

    // ItemContainer constructor
    public ItemContainer(String containername, int containerprice, int containerx, int containery, int containerlength, int containerwidth, int containerheight) {
        // arguments

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



    // this function deletes the container
    public void deleteContainer(ItemContainer self) {
        self = null;

    }

    public void addItemContainer(ItemContainer icontainer){
        this.containerList.add(icontainer);
    }
    public void addItem(ItemsClass item){
        this.containerList.add(item);
    }



}

    // test comment

