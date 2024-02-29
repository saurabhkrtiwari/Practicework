package collection.davoxx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,7);
        List<Integer> list2 = Arrays.asList(1,2,3,8);

        List<Integer> integerList = Stream.concat(list2.stream(), list.stream()).distinct().sorted().toList();
        System.out.println(integerList);

    }






}
