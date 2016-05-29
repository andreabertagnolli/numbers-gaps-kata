package com.xpeppers.kata;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Numbers {

    private final Set<Integer> numbers;

    public Numbers() {
        numbers = new HashSet<Integer>();
    }

    public String[] gaps() {
        Optional<Integer> max = numbers.stream().max(Integer::max);

        Set<Integer> opposites = new HashSet<Integer>();
        for (int number = 1; number <= max.orElse(0); number++) {
            if (!numbers.contains(number)) {
                opposites.add(number);
            }
        }

        HashSet<String> gaps = new HashSet<String>();
        for (Integer number : opposites) {
            gaps.add(number + "-" + number);
        }

        return gaps.toArray(new String[0]);
    }

    public void add(int number) {
        numbers.add(number);
    }

}
