package java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PracticeMain {
    public static void main(String[] args) {
        List<Integer> integers = createIntegers();

        // Create a List of Strings
        List<String> listOfString = createListOfString();


        // SteamMethodsStubs.findAvg(integers);

        SteamMethodsStubs.findLongestString(listOfString);

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
