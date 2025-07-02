import java.util.Random;

public class ds_06 {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        Random rand = new Random();

        System.out.print("Generated numbers: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100); // generate numbers from 0 to 99
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        int max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        System.out.println("The maximum value is: " + max);
    }
}
