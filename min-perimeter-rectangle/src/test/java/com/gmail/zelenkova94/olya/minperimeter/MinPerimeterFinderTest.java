package com.gmail.zelenkova94.olya.minperimeter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinPerimeterFinderTest {

    @Test
    public void ifAreaLess0ThenIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new MinPerimeterFinder().minPerimeter(0));
    }

    @Test
    public void ifAreaIs1Then4() {
        Assertions.assertEquals(4, new MinPerimeterFinder().minPerimeter(1));
    }

    @Test
    public void ifArea30Then22() {
        Assertions.assertEquals(22, new MinPerimeterFinder().minPerimeter(30));
    }

    @Test
    public void ifArea13Then28() {
        Assertions.assertEquals(28, new MinPerimeterFinder().minPerimeter(13));
    }

}