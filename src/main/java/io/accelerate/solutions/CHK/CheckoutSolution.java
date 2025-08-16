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
    public static final int UNIT_PRICE_K = 70;
    public static final int UNIT_PRICE_L = 90;
    public static final int UNIT_PRICE_M = 15;
    public static final int UNIT_PRICE_N = 40;
    public static final int UNIT_PRICE_O = 10;
    public static final int UNIT_PRICE_P = 50;
    public static final int UNIT_PRICE_Q = 30;
    public static final int UNIT_PRICE_R = 50;
    public static final int UNIT_PRICE_S = 20;
    public static final int UNIT_PRICE_T = 20;
    public static final int UNIT_PRICE_U = 40;
    public static final int UNIT_PRICE_V = 50;
    public static final int UNIT_PRICE_W = 20;
    public static final int UNIT_PRICE_X = 17;
    public static final int UNIT_PRICE_Y = 20;
    public static final int UNIT_PRICE_Z = 21;


    public Integer checkout(String skus) {
        int total = 0;
        if (skus != null &&(skus.matches("[A-Z]+"))) {

            Map<Character, List<BundleOffer>> bundleOffers = new HashMap<>();
            Map<Character,Integer> unitPrices = new HashMap<>();
            List<FreeItem> freeItemsOffer = new ArrayList<>();

            storeItems(unitPrices, freeItemsOffer, bundleOffers);

            Map<Character,Integer> skuFrequency = new HashMap<>();
            for (char item : skus.toCharArray()) {
                skuFrequency.put(item,skuFrequency.getOrDefault(item,0) + 1);
            }
            total += applyGroupOffer(skuFrequency, unitPrices);
            applyFreeItemOffer(skuFrequency, freeItemsOffer);

            return calculate(skuFrequency, bundleOffers, unitPrices, total);
        } else {
            if (skus != null && skus.isEmpty()) return 0;
                else return -1;
        }
    }

    private int applyGroupOffer(Map<Character, Integer> itemsBought, Map<Character,Integer> unitPrices) {
        List<Character> groupItemsOffer = List.of('S', 'T', 'X', 'Y', 'Z');
        int groupSize = 3;
        int groupPrice = 45;
        int total = 0;

        List<Integer> prices = new ArrayList<>();
        for (char c: groupItemsOffer) {
            int quantity = itemsBought.getOrDefault(c,0);
            for (int i = 0; i < quantity; i++) {
                prices.add(unitPrices.get(c));
            }
        }
        if (prices.isEmpty()) return 0;

        // sort highest price first
        prices.sort((a, b) -> b - a);
        int i = 0;
        while (i + groupSize - 1 < prices.size()) {
            total += groupPrice;
            i += groupSize;
        }
        // calculate leftover items
        while (i < prices.size()) {
            total += prices.get(i++);
        }

        // remove items from bought basket
        for (char c : groupItemsOffer) {
            itemsBought.put(c, 0);
        }
        return total;
    }

    private void applyFreeItemOffer(Map<Character,Integer>  itemsBought, List<FreeItem> freeItemList ) {

        for ( FreeItem freeItem : freeItemList) {
            int quantity = itemsBought.getOrDefault(freeItem.buyItem, 0);
            if (freeItem.buyItem == freeItem.freeItem){
                int group = freeItem.buyQuantity + 1;
                int fullGroup = quantity / group;
                int paidQuanity = quantity - fullGroup;
                itemsBought.put(freeItem.freeItem, paidQuanity);

            } else {
                int bought = itemsBought.getOrDefault(freeItem.buyItem,0);
                int freeItems = (bought / freeItem.buyQuantity) * freeItem.freeQuantity;
                itemsBought.put(freeItem.freeItem, max(0, itemsBought.getOrDefault(freeItem.freeItem, 0) - freeItems));
            }
        }

    }

    private int calculate(Map<Character,Integer> itemsBuying, Map<Character, List<BundleOffer>> bundleOffers, Map<Character,Integer> unitPrices, int totalPrice) {
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
        unitItems.put('K', UNIT_PRICE_K);
        unitItems.put('L', UNIT_PRICE_L);
        unitItems.put('M', UNIT_PRICE_M);
        unitItems.put('N', UNIT_PRICE_N);
        unitItems.put('O', UNIT_PRICE_O);
        unitItems.put('P', UNIT_PRICE_P);
        unitItems.put('Q', UNIT_PRICE_Q);
        unitItems.put('R', UNIT_PRICE_R);
        unitItems.put('S', UNIT_PRICE_S);
        unitItems.put('T', UNIT_PRICE_T);
        unitItems.put('U', UNIT_PRICE_U);
        unitItems.put('V', UNIT_PRICE_V);
        unitItems.put('W', UNIT_PRICE_W);
        unitItems.put('X', UNIT_PRICE_X);
        unitItems.put('Y', UNIT_PRICE_Y);
        unitItems.put('Z', UNIT_PRICE_Z);


        bundleOffers.put('A', List.of(
                new BundleOffer(5,200),
                new BundleOffer(3, 130))
        );
        bundleOffers.put('B', List.of(
                new BundleOffer(2, 45)
        ));
        bundleOffers.put('H', List.of(
                new BundleOffer(10,80),
                new BundleOffer(5, 45)
        ));
        bundleOffers.put('K', List.of(
                new BundleOffer(2, 120)
        ));
        bundleOffers.put('P', List.of(
                new BundleOffer(5, 200)
        ));
        bundleOffers.put('Q', List.of(
                new BundleOffer(3, 80)
        ));
        bundleOffers.put('V', List.of(
                new BundleOffer(3, 130),
                new BundleOffer(2, 90)
        ));

        freeItems.add(new FreeItem('E', 2, 'B', 1));
        freeItems.add(new FreeItem('F', 2, 'F', 1));
        freeItems.add(new FreeItem('N', 3, 'M', 1));
        freeItems.add(new FreeItem('R', 3, 'Q', 1));
        freeItems.add(new FreeItem('U', 3, 'U', 1));

    }

}
