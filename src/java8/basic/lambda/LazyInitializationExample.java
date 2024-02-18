package java8.basic.lambda;

import java.util.function.Supplier;

public class LazyInitializationExample {
    private final Supplier<ExpensiveObject> expensiveObjectSupplier = () -> createExpensiveObject();

    public ExpensiveObject getExpensiveObject() {
        return expensiveObjectSupplier.get();
    }

    private ExpensiveObject createExpensiveObject() {
        // Perform expensive initialization
        return new ExpensiveObject();
    }

    public static void main(String[] args) {
        LazyInitializationExample example = new LazyInitializationExample();

        // At this point, the ExpensiveObject is not yet created
        // It will be created only when requested via getExpensiveObject() method
        ExpensiveObject expensiveObject = example.getExpensiveObject();

        // Use the expensive object
        expensiveObject.doSomething();
    }
}

class ExpensiveObject {
    public void doSomething() {
        System.out.println("ExpensiveObject is doing something.");
    }
}
