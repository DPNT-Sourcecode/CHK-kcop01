package io.accelerate.solutions.CHK;

import java.util.List;
import java.util.Map;

public class Item {
    int unitPrice;
    Map<Integer, Integer> bundleOffers;
    List<FreeItem> freeOffer;

    public Item(int unitPrice, Map<Integer, Integer> bundleOffers, List<FreeItem> freeOffer) {
        this.unitPrice = unitPrice;
        this.bundleOffers = bundleOffers;
        this.freeOffer = freeOffer;
    }

    public Item(int price) {
        this.unitPrice = price;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

}

