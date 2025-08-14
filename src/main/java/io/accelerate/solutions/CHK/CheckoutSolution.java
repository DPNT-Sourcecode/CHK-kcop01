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

        int countA = itemsBuying.getOrDefault('A',0);
        int countB = itemsBuying.getOrDefault('B',0);
        int countC = itemsBuying.getOrDefault('C',0);
        int countD = itemsBuying.getOrDefault('D',0);
        int countE = itemsBuying.getOrDefault('E',0);

        int freeB = countE / 2;
        countB = Math.max(0, countB - freeB);

        totalPrice += getBundleOffer(countA,3,130,50);
        totalPrice += getBundleOffer(countB,2,45,30);
        totalPrice += 20 * countC;
        totalPrice += 15 * countD;
        totalPrice += 40 * countE;

        return totalPrice;

    }

    private int getBundleOffer(int itemsBuying ,int offerQuantity, int offerPrice, int unitPrice) {
        int offer = itemsBuying / offerQuantity;
        int remaining = itemsBuying % offerQuantity;
        return (offer * offerPrice) + (remaining * unitPrice);
    }

}
