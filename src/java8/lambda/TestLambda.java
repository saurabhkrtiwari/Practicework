package java8.lambda;

public class TestLambda {

    public static void main(String[] args) {
        PrintString1 test = () -> System.out.println("Test");

        test.print();

        PrintString2 printString2 = System.out::println;
        printString2.print("TEst String");

        Arithmetic add = (a, b) -> {
            System.out.println(a + b);
        };

        Arithmetic multiply = (a, b) -> {
            System.out.println(a * b);
        };


        Arithmetic calculate = (a, b) -> {
            System.out.println(2 * a * b + a * a + b * b);
        };

        add.operation(2, 4);
        multiply.operation(3, 4);
        calculate.operation(2, 4);


        ArithmeticWithReturn addWithReturn = (a, b) -> a + b;

        ArithmeticWithReturn multiplyWithReturn = (a, b) -> a * b;


        ArithmeticWithReturn calculateWithReturn = (a, b) -> {
            return (2 * a * b + a * a + b * b);
        };

        System.out.println(" add return " + addWithReturn.operation(4,6));
        System.out.println(" Multiply return " + multiplyWithReturn.operation(4,6));
        System.out.println(" Calculate return " + calculateWithReturn.operation(4,6));

    }

}
