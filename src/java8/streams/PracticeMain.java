package java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PracticeMain {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(100);
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            integers.add(random.nextInt(1000)); // Change 1000 to the desired upper bound
        }


        SteamMethodsStubs.findAvg(integers);
    }
}
