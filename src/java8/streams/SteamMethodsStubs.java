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

    public static void sumOfSquareOfEvenNumbers(List<Integer> listFromOneToTen) {
        int sum = listFromOneToTen.stream().filter(integer -> integer % 2 == 0).map(integer -> integer * integer).mapToInt(s -> s).sum();
        System.out.println("Sum of even numbers "+sum);
    }

    public static void findTheStringsBiggerThanGivenLength(List<String> listOfString, int i) {
        List<String> collect = listOfString.stream().filter(s -> s.length() > 5).toList();
        System.out.println("Strings "+collect);
    }

    public static void findTheStringsBiggerThanGivenLengthCount(List<String> listOfString, int i) {
        long collect = listOfString.stream().filter(s -> s.length() > 5).count();
        System.out.println("Strings Count "+collect);
    }
}
