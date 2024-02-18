package java8.basic.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

class Transaction {
    private String product;
    private double price;
    private int quantity;

    public Transaction(String product, double price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return price * quantity;
    }
}

public class SalesAnalytics {
    public static void main(String[] args) {
        // Create a list of sales transactions
        List<Transaction> transactions = Arrays.asList(
                new Transaction("Product A", 10.0, 2),
                new Transaction("Product B", 15.0, 3),
                new Transaction("Product C", 20.0, 1)
        );

        // Define a Function to extract the total revenue from each transaction
        Function<Transaction, Double> revenueExtractor = Transaction::getTotal;

        // Calculate the total revenue using the Function
        double totalRevenue = calculateTotalRevenue(transactions, revenueExtractor);

        // Print the total revenue
        System.out.println("Total Revenue: $" + totalRevenue);
    }

    public static double calculateTotalRevenue(List<Transaction> transactions, Function<Transaction, Double> revenueExtractor) {
        double totalRevenue = 0.0;
        for (Transaction transaction : transactions) {
            totalRevenue += revenueExtractor.apply(transaction);
        }
        return totalRevenue;
    }
}
