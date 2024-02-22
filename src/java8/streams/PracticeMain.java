package java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PracticeMain {
    public static void main(String[] args) {
        List<Integer> integers = createIntegers();

        // Create a List of Strings
        List<String> listOfString = createListOfString();

        List<Integer> listWithDuplicate = Arrays.asList(1, 2, 3, 4, 5, 5, 6, 6, 7, 8, 9, 9, 10);
        List<Integer> listFromOneToTen = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);



        // SteamMethodsStubs.findAvg(integers);

        //SteamMethodsStubs.findLongestString(listOfString);

       // SteamMethodsStubs.removeDuplicates(listWithDuplicate);

       // SteamMethodsStubs.sumOfSquareOfEvenNumbers(listFromOneToTen);
      //  SteamMethodsStubs.findTheStringsBiggerThanGivenLength(listOfString,5);
       // SteamMethodsStubs.findTheStringsBiggerThanGivenLengthCount(listOfString,5);
       // StreamStubs.mergeAndRemoveDuplicate(listWithDuplicate,listFromOneToTen);

       // StreamStubs.productOfNumbers(listFromOneToTen);
   //     StreamStubs.sortStringByLength(listOfString);



    }

    private static List<String> createListOfString() {
        List<String> strings = new ArrayList<>();

        // Add strings to the list
        strings.add("Hello");
        strings.add("World");
        strings.add("Java");
        strings.add("Programming");
        strings.add("Language");

        return strings;
    }

    private static List<Integer> createIntegers() {
        List<Integer> integers = new ArrayList<>(100);
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            integers.add(random.nextInt(1000)); // Change 1000 to the desired upper bound
        }
        return integers;
    }
}
