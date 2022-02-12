package com.gmail.zelenkova94.olya.minvalue;

public class MinValueFinder {
    public int searchMinValue(int[] array) {
        if(array == null)
            throw new IllegalArgumentException("The Array must not be null");
        if(array.length == 0)
            throw new IllegalArgumentException("Array cannot be empty");
        if(array.length == 1)
            return array[0];
        int min = array[0];
        for(int i = 0; i < array.length; i++) {
            if(array[i] < min)
                min = array[i];
        }
        return min;
    }

}
