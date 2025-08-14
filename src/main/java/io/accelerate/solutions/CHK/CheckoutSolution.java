package io.accelerate.solutions.CHK;

import io.accelerate.runner.SolutionNotImplementedException;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        if (skus != null &&(skus.matches("[A-Z]+"))) {

            Map<Character,Integer> skuFrequency = new HashMap<>();
            for (char item : skus.toCharArray()) {
                skuFrequency.put(item,skuFrequency.getOrDefault(item,0) + 1);
            }
            Map<String, Integer> priceList = getPriceList();
            return getPrice(skuFrequency, priceList);
        } else {
            if (skus != null && skus.isEmpty()) return 0;
                else return -1;
        }

    }

    private Map<String, Integer> getPriceList() {
        Map<String, Integer> itemPrice = new HashMap<>();
        itemPrice.put("A",50);
        itemPrice.put("B",30);
        itemPrice.put("C",20);
        itemPrice.put("D",15);
        return itemPrice;
    }

    private int getPrice(Map<Character,Integer> itemsBuying, Map<String, Integer> priceList) {
        int totalPrice = 0;
        for (char item : itemsBuying.keySet()) {

            if (item=='A') {
                totalPrice += getBundleOffer(itemsBuying.get(item),3, 130, 50);
            }
            if (item == 'B') {
                totalPrice += getBundleOffer(itemsBuying.get(item),2, 45, 30);

            }
            if (item == 'C'){
                totalPrice += 20 * itemsBuying.get(item);
            }
            if (item == 'D'){
                totalPrice += 15* itemsBuying.get(item);
            }
        }
        return totalPrice;

    }
    private int getBundleOffer(int itemsBuying ,int offerQuantity, int offerPrice, int unitPrice) {
        int offer = itemsBuying / offerQuantity;
        int remaining = itemsBuying % offerQuantity;
        return (offer * offerPrice) + (remaining * unitPrice);
    }
}
