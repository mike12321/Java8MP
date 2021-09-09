import com.epam.cdp.m2.hw2.aggregator.Java7Aggregator;
import com.epam.cdp.m2.hw2.aggregator.Java8Aggregator;

import java.util.Arrays;
public class App {
    public static void main(String[] args) {
        Java7Aggregator java7Aggregator = new Java7Aggregator();
        Java8Aggregator java8Aggregator = new Java8Aggregator();

        System.out.println((java8Aggregator.getMostFrequentWords(Arrays.asList("apple", "banana", "orange", "peer", "Banana", "banana", "peer"), 5)));

        System.out.println(java8Aggregator.getDuplicates(Arrays.asList("wwwoooo", "a", "BA", "wwwoOoo", "ba"), 3));
//        System.out.println(java8Aggregator.getDuplicates(Arrays.asList("apple", "banana", "orange", "peer", "banana", "banana", "peer"), 1));
    }
}
