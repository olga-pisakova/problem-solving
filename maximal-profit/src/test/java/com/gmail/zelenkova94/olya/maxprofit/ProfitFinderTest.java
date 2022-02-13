package com.gmail.zelenkova94.olya.maxprofit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class ProfitFinderTest {

    @Test
    public void ifArrayNullThenIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new ProfitFinder().findMaxProfit(null));
    }

    @Test
    public void ifArrayEmptyThenReturn0() {
        Assertions.assertEquals(0, new ProfitFinder().findMaxProfit(new int[0]));
    }

    @Test
    public void ifArrayFromTR6Then0() {
        Assertions.assertEquals(0, new ProfitFinder().findMaxProfit(new int[]{130, 120, 110, 100}));
    }

    @Test
    public void ifArrayFromTR7Then40() {
        Assertions.assertEquals(40,
                new ProfitFinder().findMaxProfit(new int[]{85, 80, 90, 120, 100}));
    }

    @Test
    public void ifArrayFromTR8Then50() {
        Assertions.assertEquals(50,
                new ProfitFinder().findMaxProfit(new int[]{90, 120, 60, 65, 70, 110, 100}));
    }
}