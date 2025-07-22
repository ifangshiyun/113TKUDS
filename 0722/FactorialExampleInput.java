import java.util.Scanner;

public class FactorialExampleInput {

    public static int factorial(int n) {
        if (n <= 1) {
            System.out.print("1");
            return 1;
        }
        System.out.print(n + " * ");
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number：");

        if (scanner.hasNextInt()) {
            int input = scanner.nextInt();

            if (input < 0) {
                System.out.println("Error");
            } else {
                System.out.print(input + "! = ");
                int result = factorial(input);
                System.out.println(" = " + result);
            }

        } else {
            System.out.println("please enter the correct number");
        }

        scanner.close();
    }
}
