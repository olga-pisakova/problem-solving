package com.gmail.zelenkova94.olya.minperimeter;

public class MinPerimeterFinder {
    public int minPerimeter(int N) {
        if(N <= 0)
            throw new IllegalArgumentException("The area of the rectangle must be positive.");

        int result = 0;
        for(int i = (int) Math.sqrt(N); i > 0 && result == 0; i--) {
            if(N % i == 0)
                result = 2 * (N / i + i);
        }

        return result;
    }

}
