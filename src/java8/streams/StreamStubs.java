package java8.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamStubs {

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

    public static void mergeAndRemoveDuplicate(List<Integer> listWithDuplicate, List<Integer> listFromOneToTen) {
        List<Integer> list = Stream.concat(listWithDuplicate.stream(), listFromOneToTen.stream()).distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("Merged list "+list);
    }

    public static void productOfNumbers(List<Integer> list) {
        long reduce = list.stream().mapToLong(value -> value).reduce(1L, (x, y) -> x * y);
        System.out.println("Product "+reduce);
    }

    public static void sortStringByLength(List<String> list) {
        List<String> collect = list.stream().sorted(String::compareTo).toList();
        System.out.println("Sorted List "+collect);
    }

    public static void countOfWord(List<String> listOfString) {
        Map<String, Long> collect = listOfString.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        System.out.println("Word with frequency "+collect);
    }

    public static void differenceInMaxAndMin(List<Integer> integers) {
        IntSummaryStatistics intSummaryStatistics = integers.stream().mapToInt(value -> value).summaryStatistics();
        int difference = intSummaryStatistics.getMax() - intSummaryStatistics.getMin();
        System.out.println("Max "+intSummaryStatistics.getMax()
                +" and Min "+intSummaryStatistics.getMin()
                +" difference "+difference);
    }

    public static void removeNullFromList(List<String> stringListWithNull) {
        List<String > collect = stringListWithNull.stream().filter(Objects::nonNull).toList();
        System.out.println(" List without null "+collect);
    }
}
