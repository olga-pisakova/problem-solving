package com.gmail.zelenkova94.olya.minvalue;

public class MinValueFinder {
    public int searchMinValue(final int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("The Array must not be null");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
        if (array.length == 1) {
            return array[0];
        }
        int min = array[0];
        for (int j : array) {
            if (j < min) {
                min = j;
            }
        }
        return min;
    }

}
