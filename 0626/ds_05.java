public class ds_05 {
    public static void main(String[] args) {
        int[] numbers = {2, 4, 6, 8, 10, 1, 3, 5, 7, 9};
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        System.out.println("The sum of all elements is: " + sum);
    }
}
