package java8.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestStream {


    public static Map<String, Long> getMapWithCount(List<String> list){
        return list.stream().filter(s->Collections.frequency(list,s)>1). collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("A","B","C","D","A","A","D","B","C","E");
        List<Integer> integers = Arrays.asList(10,15,8,49,25,98,32);

        System.out.println(getMapWithCount(list));
        //System.out.println("Even Number "+getEvenOddNumbers(true,integers));
       // System.out.println("Odd Number "+getEvenOddNumbers(false,integers));
        System.out.println("All Number starting with given digit 2 "+ getNumberListStartingWithAGivenDigit(2,integers));
        System.out.println("All Number starting with given digit 1 "+ getNumberListStartingWithAGivenDigit(1,integers));
        System.out.println("Add Prefix 'H_' and Suffix '_T' "+ getListWithPrefixSuffix("H_","_T",list));
        System.out.println("get Minimum "+ getMinimumOfList(integers));
        System.out.println("get Minimum "+ getMaximumOfList(integers));


    }

    private static Integer getMaximumOfList(List<Integer> integers) {
        return integers.stream().max(Comparator.comparing(Integer::valueOf)).get();
    }

    private static Integer getMinimumOfList(List<Integer> integers) {
        return integers.stream().min(Comparator.comparing(Integer::valueOf)).get();
    }

    private static List<String> getListWithPrefixSuffix(String prefix, String suffix, List<String> list) {
        return list.stream().map(s->prefix.concat(s).concat(suffix)).collect(Collectors.toList());
    }

    private static List<String> getNumberListStartingWithAGivenDigit(int i, List<Integer> integers) {
        return integers.stream().map(String::valueOf).filter(s->s.startsWith(String.valueOf(i))).collect(Collectors.toList());
    }

    private static List<Integer> getEvenOddNumbers(boolean b, List<Integer> list) {
        if(b){
            return list.stream().filter(i->(i%2==0)).collect(Collectors.toList());
        }else {
            return list.stream().filter(i->(i%2!=0)).collect(Collectors.toList());
        }


    }
}
