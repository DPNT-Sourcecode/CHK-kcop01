package io.accelerate.solutions.CHK;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {

    public static final int UNIT_PRICE_C = 20;
    public static final int UNIT_PRICE_D = 15;
    public static final int UNIT_PRICE_E = 40;
    public static final int BUNDLE_PRICE_2B = 45;
    public static final int UNIT_PRICE_A = 50;
    public static final int UNIT_PRICE_B = 30;
    public static final int BUNDLE_PRICE_5A = 200;
    public static final int BUNDLE_PRICE_3A = 130;

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

        totalPrice += priceForA(countA);
        totalPrice += priceForB(countB);
        totalPrice += UNIT_PRICE_C * countC;
        totalPrice += UNIT_PRICE_D * countD;
        totalPrice += UNIT_PRICE_E * countE;

        return totalPrice;

    }

    private int priceForA(int countA) {
        int total = 0;
        total += (countA / 5) * BUNDLE_PRICE_5A;
        countA = countA % 5;

        total += (countA / 3) * BUNDLE_PRICE_3A;
        countA = countA % 3;

        total += countA * UNIT_PRICE_A;
        return total;
    }

    private int priceForB(int countB) {
        int total = 0;
        total += (countB / 2) * BUNDLE_PRICE_2B;
        countB = countB % 2;

        total += countB * UNIT_PRICE_B;
        return total;

    }

}


