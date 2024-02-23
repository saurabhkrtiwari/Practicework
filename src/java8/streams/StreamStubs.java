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

    public static void countOfCharacterInListOfStrings(List<String> listOfString, char a) {
        Map<String, Long> collect = listOfString.stream()
                .collect(Collectors.toMap(s -> s, s -> s.chars().filter(c -> c == a).count())
                );
        System.out.println("Count of character "+ a +" in String wise "+collect);
    }

    public static void smallestNumberByIndex(List<Integer> listFromOneToTen, int i) {
        Integer number = listFromOneToTen.stream().sorted().skip(1).findFirst().orElse(0);
        System.out.println("Smallest number at '"+i + "' position "+number);

    }

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void longestPalindrome(List<String> list) {
        String s = list.stream().filter(StreamStubs::isPalindrome).max(Comparator.comparingInt(String::length)).orElse(null);
        System.out.println("longest "+s);
    }

    public static void nthFibonacci(int i) {
        int i1 = Stream.iterate(new int[]{0, 1}, fib -> new int[]{fib[1], fib[0] + fib[1]})
                .limit(i)
                .mapToInt(fib -> fib[0])
                .reduce((first, second) -> second)
                .orElse(0);
        System.out.println("nth bubonic number "+i1);
    }

    public static void concatAllList(List<String> listOfString) {
        String concatString = String.join("", listOfString);
        System.out.println("concatenated String "+concatString);
    }

    public static void findMaxAndMinList(List<String> listOfString) {
        IntSummaryStatistics intSummaryStatistics = listOfString.stream().mapToInt(String::length).summaryStatistics();
        System.out.println("Max Length "+intSummaryStatistics.getMax()+" Min Length "+intSummaryStatistics.getMin());
    }

    public static void findAllPrimes(List<Integer> integers) {

    }
}
