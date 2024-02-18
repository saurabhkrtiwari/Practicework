package java8.basic.lambda;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        // Define a Supplier that generates a random integer between 1 and 100
        Supplier<Integer> randomSupplier = () -> new Random().nextInt(100) + 1;


        //Anonymous implementation
       /* Supplier<Integer> randomAnonymous = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return new Random().nextInt(100) + 1;
            }
        };*/

        // Get a random integer using the Supplier
        int randomNumber = randomSupplier.get();

        System.out.println("Random number: " + randomNumber);
    }
}
