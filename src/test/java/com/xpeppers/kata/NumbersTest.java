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

    @Test
    public void gaps_3_3_for_set_with_numbers_4_1_and_2() throws Exception {
        numbers.add(4);
        numbers.add(1);
        numbers.add(2);

        assertThat(numbers.gaps()).isEqualTo(new String[] { "3-3" });
    }

    @Test
    public void gaps_2_2_for_set_with_numbers_1_4_and_3() throws Exception {
        numbers.add(1);
        numbers.add(4);
        numbers.add(3);

        assertThat(numbers.gaps()).isEqualTo(new String[] { "2-2" });
    }

    @Test
    public void gaps_2_3_and_5_6_for_set_with_numbers_1_7_and_4() throws Exception {
        numbers.add(1);
        numbers.add(7);
        numbers.add(4);

        assertThat(numbers.gaps()).isEqualTo(new String[] { "2-3", "5-6" });
    }

    @Test
    public void no_gaps_for_set_with_numbers_1_3_and_2() throws Exception {
        numbers.add(1);
        numbers.add(3);
        numbers.add(2);

        assertThat(numbers.gaps()).isEmpty();
    }

    @Test
    public void no_gaps_when_adding_then_removing_1() throws Exception {
        numbers.add(1);
        numbers.remove(1);

        assertThat(numbers.gaps()).isEmpty();
    }

    @Test
    public void no_gaps_when_adding_then_removing_5() throws Exception {
        numbers.add(5);
        numbers.remove(5);

        assertThat(numbers.gaps()).isEmpty();
    }

    @Test
    public void gaps_1_4_and_6_6_when_adding_5_6_7_then_removing_6() throws Exception {
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.remove(6);

        assertThat(numbers.gaps()).isEqualTo(new String[] { "1-4", "6-6" });
    }

}
