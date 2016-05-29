package com.xpeppers.kata;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class NumbersTest {

    @Test
    public void no_gaps_for_an_empty_set_of_numbers() {
        Numbers numbers = new Numbers();
        assertThat(numbers.gaps()).isEmpty();
    }

    @Test
    public void no_gaps_for_just_number_1() throws Exception {
        Numbers numbers = new Numbers();
        numbers.add(1);

        assertThat(numbers.gaps()).isEmpty();
    }

}
