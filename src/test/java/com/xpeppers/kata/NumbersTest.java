package com.xpeppers.kata;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class NumbersTest {

    private Numbers numbers;

    @Before
    public void setup() {
        numbers = new Numbers();
    }

    @Test
    public void no_gaps_for_an_empty_set_of_numbers() {
        assertThat(numbers.gaps()).isEmpty();
    }

    @Test
    public void no_gaps_for_just_number_1() throws Exception {
        Numbers numbers = new Numbers();
        numbers.add(1);

        assertThat(numbers.gaps()).isEmpty();
    }

    @Test
    public void gaps_1_1_for_a_set_with_just_number_2() throws Exception {
        numbers.add(2);

        assertThat(numbers.gaps()).isEqualTo(new String[] { "1-1" });
    }

    @Test
    public void no_gaps_for_a_set_with_numbers_1_and_2() throws Exception {
        numbers.add(1);
        numbers.add(2);

        assertThat(numbers.gaps()).isEmpty();
    }

    @Test
    public void gaps_2_3_for_set_with_numbers_4_and_1() throws Exception {
        numbers.add(4);
        numbers.add(1);

        assertThat(numbers.gaps()).isEqualTo(new String[] { "2-3" });
    }

}
