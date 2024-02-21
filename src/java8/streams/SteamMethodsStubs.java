package java8.streams;

import java.util.*;

public class SteamMethodsStubs {

        public static void findAvg(List<Integer> list) {
        OptionalDouble average = list.stream().mapToInt(value -> value).average();
        if(average.isPresent()){
            System.out.println("Average "+average.getAsDouble());
        }
    }
}
