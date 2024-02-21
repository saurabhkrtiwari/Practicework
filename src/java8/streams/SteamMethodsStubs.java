package java8.streams;

import java.util.*;
import java.util.stream.Collectors;

public class SteamMethodsStubs {

    public static void findAvg(List<Integer> list) {
        OptionalDouble average = list.stream().mapToInt(value -> value).average();
        if(average.isPresent()){
            System.out.println("Average "+average.getAsDouble());
        }
    }

    public static void findLongestString(List<String> listOfString) {
        String s = listOfString.stream().max(Comparator.comparingInt(String::length)).orElse(null);
        assert s != null;
        System.out.println("Longest String "+s + " for length "+s.length());
    }

    public static void removeDuplicates(List<Integer> integers) {
        List<Integer> collect = integers.stream().distinct().toList();
        System.out.println("Duplicate list is "+ integers);
        System.out.println("Unique list is "+ collect);
    }
}
