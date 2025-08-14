package io.accelerate.solutions.CHK;

import io.accelerate.runner.SolutionNotImplementedException;

import java.util.HashMap;
import java.util.Map;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        Map<Character,Integer> skuFrequency = new HashMap<>();
        for (char item : skus.toCharArray()) {
            skuFrequency.put(item,skuFrequency.getOrDefault(item,0) + 1);
        }
        Map<String, Integer> priceList = getPriceList();


        return -1;

    }

    private Map<String, Integer> getPriceList() {
        Map<String, Integer> itemPrice = new HashMap<>();
        itemPrice.put("A",50);
        itemPrice.put("B",30);
        itemPrice.put("C",20);
        itemPrice.put("D",15);
        return itemPrice;

    }
}

