package java8.basic.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

class ProductOfInventory {
    private String name;
    private int stockLevel;

    public ProductOfInventory(String name, int stockLevel) {
        this.name = name;
        this.stockLevel = stockLevel;
    }

    public String getName() {
        return name;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void increaseStockLevel(int amount) {
        stockLevel += amount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", stockLevel=" + stockLevel +
                '}';
    }
}

public class InventoryManager {
    public static void main(String[] args) {
        // Create a list of products
        List<ProductOfInventory> productOfInventories = new ArrayList<>();
        productOfInventories.add(new ProductOfInventory("Laptop", 10));
        productOfInventories.add(new ProductOfInventory("Phone", 20));
        productOfInventories.add(new ProductOfInventory("Tablet", 15));

        // Define a UnaryOperator to increase the stock level of each product by a certain amount
        UnaryOperator<ProductOfInventory> increaseStockLevel = productOfInventory -> {
            productOfInventory.increaseStockLevel(5); // Increase stock level by 5 units
            return productOfInventory;
        };

        // Increase the stock level of each product using the UnaryOperator
        productOfInventories.replaceAll(increaseStockLevel);

        // Print the updated stock levels of the products
        productOfInventories.forEach(System.out::println);
    }
}
