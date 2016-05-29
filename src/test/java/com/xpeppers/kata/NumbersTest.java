package com.xpeppers.kata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NumbersTest {

    @Test
    public void no_gaps_for_an_empty_set_of_numbers() {
        Numbers numbers = new Numbers();
        assertEquals(0, numbers.gaps().length);
    }

}
