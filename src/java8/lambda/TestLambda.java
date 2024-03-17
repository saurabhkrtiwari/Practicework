package java8.lambda;

public class TestLambda {

    public static void main(String[] args) {
        PrintString1 test = () -> System.out.println("Test");

        test.print();

       PrintString2 printString2 = System.out::println;
       printString2.print("TEst String");
    }
}
