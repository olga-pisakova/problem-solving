package com.gmail.zelenkova94.olya.minvalue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinValueFinderTest {

    @Test
    public void ifArrayNullThenIllegalArgumentException() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new MinValueFinder().searchMinValue(null)
        );
    }

    @Test
    public void ifArrayEmptyThenIllegalArgumentException() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new MinValueFinder().searchMinValue(new int[0])
        );
    }

    @Test
    public void ifArrayHas1Then1() {
        Assertions.assertEquals(1, new MinValueFinder().searchMinValue(new int[]{1}));
    }

    @Test
    public void ifArrayFromTR6ThenMinus4() {
        Assertions.assertEquals(-4, new MinValueFinder().searchMinValue(new int[]{4, 5, -4, -3}));
    }
}