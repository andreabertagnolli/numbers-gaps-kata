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

        List<String> gaps = new ArrayList<String>();
        for (int i = 0; i < opposites.length; i++) {
            Integer lowerBound = opposites[i];
            Integer upperBound = opposites[i];
            int upperBoundIndex = i;
            for (int j = i + 1; j < opposites.length; j++) {
                if (lowerBound + j - i == opposites[j]) {
                    upperBoundIndex = j;
                    upperBound = opposites[j];
                }
            }
            i = upperBoundIndex;
            gaps.add(rangeWith(lowerBound, upperBound));
        }

        return gaps.toArray(new String[0]);
    }

    public void add(int number) {
        numbers.add(number);
    }

    public void remove(int number) {
        numbers.remove(number);
    }

    private String rangeWith(Integer lowerBound, Integer upperBound) {
        return lowerBound + "-" + upperBound;
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

}
