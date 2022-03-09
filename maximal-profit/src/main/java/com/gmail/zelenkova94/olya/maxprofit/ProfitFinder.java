package com.gmail.zelenkova94.olya.maxprofit;

/**
 * JavaDoc.
 */
public class ProfitFinder {
    public int findMaxProfit(final int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Given array must not be null");
        }
        int maxProfit = 0;
        int currentProfit;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                currentProfit = array[i] - array[j];
                if (currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                }
            }
        }
        return maxProfit;
    }
}
