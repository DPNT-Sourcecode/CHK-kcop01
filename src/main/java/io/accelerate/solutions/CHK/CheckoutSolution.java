package io.accelerate.solutions.CHK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckoutSolution {

    public static final int UNIT_PRICE_A = 50;
    public static final int UNIT_PRICE_B = 30;
    public static final int UNIT_PRICE_C = 20;
    public static final int UNIT_PRICE_D = 15;
    public static final int UNIT_PRICE_E = 40;
    public static final int UNIT_PRICE_F = 10;
    public static final int UNIT_PRICE_G = 20;
    public static final int UNIT_PRICE_H = 10;
    public static final int UNIT_PRICE_I = 35;
    public static final int UNIT_PRICE_J = 60;
    public static final int UNIT_PRICE_K = 80;
    public static final int UNIT_PRICE_L = 90;
    public static final int UNIT_PRICE_M = 15;
    public static final int UNIT_PRICE_N = 40;
    public static final int UNIT_PRICE_O = 10;
    public static final int UNIT_PRICE_P = 50;
    public static final int UNIT_PRICE_Q = 30;
    public static final int UNIT_PRICE_R = 50;
    public static final int UNIT_PRICE_S = 30;
    public static final int UNIT_PRICE_T = 20;
    public static final int UNIT_PRICE_U = 40;
    public static final int UNIT_PRICE_V = 50;
    public static final int UNIT_PRICE_W = 20;
    public static final int UNIT_PRICE_X = 90;
    public static final int UNIT_PRICE_Y = 10;
    public static final int UNIT_PRICE_Z = 50;
    public static final int BUNDLE_PRICE_2B = 45;
    public static final int BUNDLE_PRICE_5A = 200;
    public static final int BUNDLE_PRICE_3A = 130;
    public static final int BUNDLE_OFFER_3F = 20;

    public Integer checkout(String skus) {
        if (skus != null &&(skus.matches("[A-Z]+"))) {

            Map<Character, Item> items = new HashMap<>();
            Map<Character, List<>>
            Map<Character,Integer> unitPrices = new HashMap<>();
            List<FreeItem> freeItemsOffer = new ArrayList<>();

            storeItems(items, unitPrices, freeItemsOffer);
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

    private void applyFreeItemOffer() {

    }

    private int getPrice(Map<Character,Integer> itemsBuying) {
        int totalPrice = 0;

        int countA = itemsBuying.getOrDefault('A',0);
        int countB = itemsBuying.getOrDefault('B',0);
        int countC = itemsBuying.getOrDefault('C',0);
        int countD = itemsBuying.getOrDefault('D',0);
        int countE = itemsBuying.getOrDefault('E',0);
        int countF = itemsBuying.getOrDefault('F',0);

        int freeB = countE / 2;
        countB = Math.max(0, countB - freeB);

        totalPrice += priceForA(countA);
        totalPrice += priceForB(countB);
        totalPrice += UNIT_PRICE_C * countC;
        totalPrice += UNIT_PRICE_D * countD;
        totalPrice += UNIT_PRICE_E * countE;
        totalPrice += priceForF(countF);

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

    private int priceForF(int countF) {
        int total = 0;
         total += (countF / 3) * BUNDLE_OFFER_3F;
         countF = countF % 3;
         total += countF * UNIT_PRICE_F;
         return total;
    }

    private void storeItems(Map<Character, Item> items, List<FreeItem> freeItems) {
        Item a = new Item(UNIT_PRICE_A);
        Item b = new Item(UNIT_PRICE_B);
        Item c = new Item(UNIT_PRICE_C);
        Item d = new Item(UNIT_PRICE_D);
        Item e = new Item(UNIT_PRICE_E);
        Item f = new Item(UNIT_PRICE_F);
        Item g = new Item(UNIT_PRICE_G);
        Item h = new Item(UNIT_PRICE_H);
        Item i = new Item(UNIT_PRICE_I);
        Item j = new Item(UNIT_PRICE_J);
        Item k = new Item(UNIT_PRICE_K);
        Item l = new Item(UNIT_PRICE_L);
        Item m = new Item(UNIT_PRICE_M);
        Item n = new Item(UNIT_PRICE_N);
        Item o = new Item(UNIT_PRICE_O);
        Item p = new Item(UNIT_PRICE_P);
        Item q = new Item(UNIT_PRICE_Q);
        Item r = new Item(UNIT_PRICE_R);
        Item s = new Item(UNIT_PRICE_S);
        Item t = new Item(UNIT_PRICE_T);
        Item u = new Item(UNIT_PRICE_U);
        Item v = new Item(UNIT_PRICE_V);
        Item w = new Item(UNIT_PRICE_W);
        Item x = new Item(UNIT_PRICE_Z);
        Item y = new Item(UNIT_PRICE_Y);
        Item z = new Item(UNIT_PRICE_X);

        a.bundleOffers.put(3, BUNDLE_PRICE_3A);
        a.bundleOffers.put(5, BUNDLE_PRICE_5A);
        b.bundleOffers.put(2, BUNDLE_PRICE_2B);

        e.freeOffer.add(new FreeItem(2,'B'));
        freeItems.add(new FreeItem())

        items.put('A', a);
        items.put('B', b);
        items.put('C', c);
        items.put('D', d);
        items.put('E', e);


    }

}
