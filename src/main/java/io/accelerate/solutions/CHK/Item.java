package io.accelerate.solutions.CHK;

import java.util.HashMap;

public class Item {
    int price;
    HashMap<Integer,Integer> specialOffer;

    public Item(int price, HashMap<Integer, Integer> specialOffer) {
        this.price = price;
        this.specialOffer = specialOffer;
    }

    public int getPrice() {
        return price;
    }

    public HashMap<Integer, Integer> getSpecialOffer() {
        return specialOffer;
    }
}
