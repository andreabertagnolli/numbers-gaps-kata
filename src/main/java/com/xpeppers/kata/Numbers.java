package com.xpeppers.kata;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Numbers {

    private final Set<Integer> numbers;

    public Numbers() {
        numbers = new HashSet<Integer>();
    }

    public String[] gaps() {
        Integer[] opposites = oppositeOf(numbers);
        if (opposites.length == 1) {
            return new String[] { opposites[0] + "-" + opposites[0] };
        }

        List<String> gaps = new ArrayList<String>();
        for (int i = 0, j = 1; j < opposites.length; i++, j++) {
            Integer lowerBound = opposites[i];
            Integer upperBound = opposites[i];
            if (lowerBound + 1 == opposites[j]) {
                upperBound = opposites[j];
            }
            gaps.add(lowerBound + "-" + upperBound);
        }

        return gaps.toArray(new String[0]);
    }

    private Integer[] oppositeOf(Set<Integer> numbers) {
        Optional<Integer> max = maxValueOf(numbers);

        Set<Integer> opposites = new HashSet<Integer>();
        for (int number = 1; number <= max.orElse(0); number++) {
            if (!numbers.contains(number)) {
                opposites.add(number);
            }
        }

        return opposites.toArray(new Integer[0]);
    }

    private Optional<Integer> maxValueOf(Set<Integer> collection) {
        return collection.stream().max(Integer::compare);
    }

    public void add(int number) {
        numbers.add(number);
    }

}
