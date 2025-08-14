package io.accelerate.solutions.CHK;

import io.accelerate.runner.SolutionNotImplementedException;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {

    public static final int UNIT_PRICE_C = 20;
    public static final int UNIT_PRICE_D = 15;
    public static final int UNIT_PRICE_E = 40;
    public static final int OFFER_PRICE_A = 130;
    public static final int OFFER_PRICE_B = 45;
    public static final int UNIT_PRICE_A = 50;
    public static final int UNIT_PRICE_B = 30;

    public Integer checkout(String skus) {
        if (skus != null &&(skus.matches("[A-Z]+"))) {

            Map<Character,Integer> skuFrequency = new HashMap<>();
            for (char item : skus.toCharArray()) {
                skuFrequency.put(item,skuFrequency.getOrDefault(item,0) + 1);
            }
            return getPrice(skuFrequency);
        } else {
            if (skus != null && skus.isEmpty()) return 0;
                else return -1;
        }

    }


    private int getPrice(Map<Character,Integer> itemsBuying) {
        int totalPrice = 0;

        int countA = itemsBuying.getOrDefault('A',0);
        int countB = itemsBuying.getOrDefault('B',0);
        int countC = itemsBuying.getOrDefault('C',0);
        int countD = itemsBuying.getOrDefault('D',0);
        int countE = itemsBuying.getOrDefault('E',0);

        int freeB = countE / 2;
        countB = Math.max(0, countB - freeB);

        totalPrice += getBundleOffer(countA,3, OFFER_PRICE_A, UNIT_PRICE_A);
        totalPrice += getBundleOffer(countB,2, OFFER_PRICE_B, UNIT_PRICE_B);
        totalPrice += UNIT_PRICE_C * countC;
        totalPrice += UNIT_PRICE_D * countD;
        totalPrice += UNIT_PRICE_E * countE;

        return totalPrice;

    }

    private int getBundleOffer(int itemsBuying ,int offerQuantity, int offerPrice, int unitPrice) {
        int offer = itemsBuying / offerQuantity;
        int remaining = itemsBuying % offerQuantity;
        return (offer * offerPrice) + (remaining * unitPrice);
    }

}

