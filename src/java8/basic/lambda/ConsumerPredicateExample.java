package java8.basic.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerPredicateExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Sarah");
        names.add("Mark");
        names.add("Tina");

        // Using Consumer to print each name in the list
        Consumer<String> printName = name -> System.out.println("Hello, " + name);
        names.forEach(printName);
    }
}
