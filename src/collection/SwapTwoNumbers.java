package collection;

public class SwapTwoNumbers {
    public static void main(String[] args) {
        int a=10;
        int b=20;

        a= a+b; //30
        b=a-b; //10
        a=a-b ;//30-b

        System.out.println("a "+a+"b "+b);
    }
}
