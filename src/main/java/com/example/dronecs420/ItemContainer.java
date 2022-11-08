package com.example.dronecs420;

import java.util.ArrayList;
public class ItemContainer extends ItemsClass {

    ArrayList<ItemsClass> containerList = new ArrayList<ItemsClass>();
    // name field
    private String name;
    // price field
    private int price;

    //  x Location field
    private double Lx;

    // y location field
    private double Ly;

    // length field
    private int length;

    // width field
    private int width;

    // height field
    private int height;
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        ItemContainer other = (ItemContainer) obj;
        if (name == other.name)
            return true;
        return false;
    }

    private final boolean container = true;

    // ItemContainer constructor
    public ItemContainer(String containername, int containerprice, double containerx, double containery, int containerlength, int containerwidth, int containerheight) {
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
    
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getLy() {
        return Ly;
    }

    public void setLy(double ly) {
        Ly = ly;
    }

    public double getLx() {
        return Lx;
    }

    public void setLx(double lx) {
        Lx = lx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    

    // this function deletes the container
    public void deleteContainer(ItemContainer icontainer) {
        //remove icontainer from containerlist
        if (!icontainer.equals(this)){
            this.containerList.remove(icontainer);
        }
        //hopefully delete self
        else if (icontainer.equals(this)){
            this.containerList = null;
        }
        else{
            //do nothing
        }
    }

    public ItemsClass searchItems(String searchname, ItemContainer container){
        //create string buffer
        String buffer = "";
        this.containerList = container.containerList;
        //iterate through containerList
        for (int i = 0; i < containerList.size(); i++){
            //checks if item is itemContainer type, then iterates into it
            if (containerList.get(i).checkType()){
                searchItems(searchname, (ItemContainer) containerList.get(i));
            }
            else{
                buffer = containerList.get(i).getName();
                if (buffer.contains(searchname)){
                    return containerList.get(i);
                }
            }
        }
        if (this.checkType()){
            System.out.println("Item not found in ItemContainer");
        }
        else{
            System.out.println("Item not found");
        }
        return null;
    }
    public void addItemContainer(ItemContainer icontainer){
        this.containerList.add(icontainer);
    }
    public void addItem(ItemsClass item){
        this.containerList.add(item);
    }

}
