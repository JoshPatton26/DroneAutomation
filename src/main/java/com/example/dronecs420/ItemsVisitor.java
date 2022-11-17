package com.example.dronecs420;

class ItemsVisitor implements Visitor {

    public ItemsVisitor(){}
    @Override
    public int visit1(ItemsClass iclass) {
        //implement method for calculating market val of iclass
        return iclass.getPrice();
    }

    @Override
    public int visit2(ItemsClass iclass) {
        //implement method for calculating market val of iclass
        return iclass.getCur_price();
    }

    @Override
    public int visit1(ItemContainer icontainer) {
        //implement method for calculating market val of icontainer
        return icontainer.getPrice();
    }

    @Override
    public int visit2(ItemContainer icontainer) {
        //implement method for calculating market val of icontainer
        return icontainer.getCur_price();
    }
}
