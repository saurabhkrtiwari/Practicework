package java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeFinder {
    // Sieve of Eratosthenes algorithm
    public static List<Integer> sieveOfEratosthenes(int n) {
        boolean[] prime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            prime[i] = true;
        }

        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

    // Stream-based approach
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        return IntStream.range(2, number)
                        .noneMatch(i -> number % i == 0);
    }

    public static void main(String[] args) {
        int limit = 100000; // Adjust the limit as needed
        long startTime, endTime;
        
        // Benchmark Sieve of Eratosthenes
        startTime = System.currentTimeMillis();
        List<Integer> sievePrimes = sieveOfEratosthenes(limit);
        endTime = System.currentTimeMillis();
        System.out.println("Sieve of Eratosthenes took " + (endTime - startTime) + " milliseconds.");
        
        // Benchmark Stream-based approach
        startTime = System.currentTimeMillis();
        List<Integer> streamPrimes = IntStream.rangeClosed(2, limit)
                                              .parallel().filter(PrimeFinder::isPrime)
                                              .boxed()
                                              .toList();
        endTime = System.currentTimeMillis();
        System.out.println("Stream-based approach took " + (endTime - startTime) + " milliseconds.");

        // Verify both approaches produce the same result
        if (sievePrimes.equals(streamPrimes)) {
            System.out.println("Both approaches produce the same result.");
        } else {
            System.out.println("Results differ between approaches!");
        }
    }
}
