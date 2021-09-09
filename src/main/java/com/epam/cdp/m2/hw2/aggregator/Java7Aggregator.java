package com.epam.cdp.m2.hw2.aggregator;

import java.util.*;

import javafx.util.Pair;

public class Java7Aggregator implements Aggregator {

    @Override
    public int sum(List<Integer> numbers) {
        int sum = 0;

        for (int num : numbers) {
            sum += num;
        }

        return sum;
    }

    @Override
    public List<Pair<String, Long>> getMostFrequentWords(List<String> words, long limit) {
        List<Pair<String, Long>> result = new ArrayList<>();

        for (String word : words) {
            Pair<String, Long> pair = findPairByKey(result, word);
            long frequency = 1L;

            if (pair != null) {
                frequency = pair.getValue() + 1;
                result.remove(pair);
            }

            result.add(new Pair<>(word, frequency));
        }

        Collections.sort(result, (p1, p2) -> p2.getValue().compareTo(p1.getValue()));

        if (result.size() > limit) {
            List<Pair<String, Long>> limitedResult = new ArrayList<>();

            for (int i = 0; i < limit; i++) {
                limitedResult.add(result.get(i));
            }

            return limitedResult;
        }

        return result;
    }

    private Pair findPairByKey(List<Pair<String, Long>> pairs, String key) {
        for (Pair<String, Long> pair : pairs) {
            if (pair.getKey().equalsIgnoreCase(key)) {
                return pair;
            }
        }

        return null;
    }

    @Override
    public List<String> getDuplicates(List<String> words, long limit) {
        Set<String> uniqueWords = new HashSet<>();
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (!uniqueWords.add(word.toLowerCase()) && !result.contains(word)) {
                result.add(word.toUpperCase());
            }
        }

        if (result.size() > limit) {
            List<String> limitedResult = new ArrayList<>();

            for (int i = 0; i < limit; i++) {
                limitedResult.add(result.get(i));
            }

            return  limitedResult;
        }

        return result;
    }
}
