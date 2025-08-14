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


        return -1;

    }

    private getPrice(Map<Character, Integer> items) {
        
    }
}



