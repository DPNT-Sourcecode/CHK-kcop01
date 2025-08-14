package io.accelerate.solutions.CHK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Math.max;

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

            Map<Character, List<BundleOffer>> bundleOffers = new HashMap<>();
            Map<Character,Integer> unitPrices = new HashMap<>();
            List<FreeItem> freeItemsOffer = new ArrayList<>();

            storeItems(unitPrices, freeItemsOffer, bundleOffers);

            Map<Character,Integer> skuFrequency = new HashMap<>();
            for (char item : skus.toCharArray()) {
                skuFrequency.put(item,skuFrequency.getOrDefault(item,0) + 1);
            }
            applyFreeItemOffer(skuFrequency, freeItemsOffer);

            return calculate(skuFrequency, bundleOffers, unitPrices);
            //return getPrice(skuFrequency);
        } else {
            if (skus != null && skus.isEmpty()) return 0;
                else return -1;
        }
    }

    private void applyFreeItemOffer(Map<Character,Integer>  itemsBought, List<FreeItem> freeItemList) {
        for ( FreeItem freeItem : freeItemList) {
            int bought = itemsBought.getOrDefault(freeItem.buyItem,0);
            int freeItems = (bought / freeItem.buyQuantity);
            itemsBought.put(freeItem.freeItem, max(0, itemsBought.getOrDefault(freeItem.freeItem, 0) - freeItems));
        }

    }

    private int calculate(Map<Character,Integer> itemsBuying, Map<Character, List<BundleOffer>> bundleOffers, Map<Character,Integer> unitPrices) {
        int totalPrice = 0;
        for (Map.Entry<Character, Integer> entry: itemsBuying.entrySet()) {
            char product = entry.getKey();
            int quantity = entry.getValue();

            List<BundleOffer> bundles = bundleOffers.getOrDefault(product,List.of());

            for (BundleOffer offer : bundles) {
                totalPrice += (quantity / offer.bundleSize) * offer.price;
                quantity %= offer.bundleSize;

            }
             totalPrice += quantity * unitPrices.getOrDefault(product,0);
        }
        return totalPrice;

    }



    private void storeItems(Map<Character,Integer> unitItems, List<FreeItem> freeItems, Map<Character, List<BundleOffer>> bundleOffers) {

        unitItems.put('A', UNIT_PRICE_A);
        unitItems.put('B', UNIT_PRICE_B);
        unitItems.put('C', UNIT_PRICE_C);
        unitItems.put('D', UNIT_PRICE_D);
        unitItems.put('E', UNIT_PRICE_E);
        unitItems.put('F', UNIT_PRICE_F);
        unitItems.put('G', UNIT_PRICE_G);
        unitItems.put('H', UNIT_PRICE_H);
        unitItems.put('I', UNIT_PRICE_I);
        unitItems.put('J', UNIT_PRICE_J);

        bundleOffers.put('A', List.of(
                new BundleOffer(5,200),
                new BundleOffer(3, 130))
        );
        bundleOffers.put('B', List.of(
                new BundleOffer(2, 45)
        ));

        freeItems.add(new FreeItem('E', 2, 'B'));
        freeItems.add(new FreeItem('F', 2, 'F'));

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




    }

}
