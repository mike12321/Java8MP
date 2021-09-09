package com.epam.cdp.m2.hw2.aggregator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javafx.util.Pair;

public class Java8Aggregator implements Aggregator {

    @Override
    public int sum(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::new)
                .sum();
    }

    @Override
    public List<Pair<String, Long>> getMostFrequentWords(List<String> words, long limit) {
        List<Pair<String, Long>> result = words.stream()
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(w -> w,
                        Collectors.summingLong(w -> 1L)))
                .entrySet().stream()
                .map(es -> new Pair<>(es.getKey(), es.getValue()))
                .sorted(Comparator.comparing(Pair::getValue)) // TODO: Figure out why `Comparator.comparing(Pair::getValue).reversed()` throws error
//                 .sorted(Comparator.reverseOrder())
//                .limit(limit)
                .collect(Collectors.toList());

        Collections.reverse(result);

        return result.stream()
                .limit(limit)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getDuplicates(List<String> words, long limit) {
//        return words.stream()
//                .filter(word -> Collections.frequency(words, word) > 1) // TODO: Is there possible to iterate here on mapped array?
//                .map(String::toUpperCase)
//                .limit(limit)
//                .collect(Collectors.toList());

        return words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .limit(limit)
                .collect(Collectors.toList());
    }
}