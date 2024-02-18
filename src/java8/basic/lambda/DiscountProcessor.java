package java8.basic.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void applyDiscount(double discount) {
        this.price -= discount;
    }
}

public class DiscountProcessor {
    public static void main(String[] args) {
        // Create a list of products
        List<Product> products = new ArrayList<>();
        products.add(new Product("Phone", 500.0));
        products.add(new Product("Laptop", 1000.0));
        products.add(new Product("Tablet", 300.0));

        // Define a Consumer to apply a discount to each product
        Consumer<Product> discountApplier = product -> {
            double discount = product.getPrice() * 0.1; // 10% discount
            product.applyDiscount(discount);
            System.out.println("Applied discount of " + discount + " to " + product.getName());
        };

        // Apply the discount to each product in the list
        products.forEach(discountApplier);

        // Print the updated prices
        System.out.println("Updated prices after discount:");
        products.forEach(product -> System.out.println(product.getName() + ": $" + product.getPrice()));
    }
}
