package com.example.dronecs420;

public class ItemsClass {
    private int price;
    private String name;
    private double Lx;
    private double Ly;
    private int length;
    private int width;
    private int height;

    public ItemsClass(String iname, int iprice, double ix, double iy, int ilength, int iwidth, int iheight){
        this.name = iname;
        this.price = iprice;
        this.Lx = ix;
        this.Ly = iy;
        this.length = ilength;
        this.width = iwidth;
        this.height = iheight;
    }


    public void deleteItem(ItemsClass self){
        self = null;

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
}
