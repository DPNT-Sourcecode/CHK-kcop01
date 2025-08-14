package io.accelerate.solutions.CHK;

import java.util.Map;

public class Item {
    int unitPrice;
    Map<Integer, Integer> bundleOffers;
    List<FreeItem> freeOffer;

    public Item(int price) {
        this.unitPrice = price;
       // this.specialOffer = specialOffer;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

//    public HashMap<Integer, Integer> getSpecialOffer() {
//        return specialOffer;
//    }
}

