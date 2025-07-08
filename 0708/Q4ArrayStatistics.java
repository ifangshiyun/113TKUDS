public class Q4ArrayStatistics {

    public static void main(String[] args) {
        // 1. Create the array
        int[] numbers = {5, 12, 8, 15, 7, 23, 18, 9, 14, 6};

        // 2. Calculate sum and average
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        double average = (double) sum / numbers.length;

        // Find max and min with their index
        int max = numbers[0];
        int min = numbers[0];
        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
                maxIndex = i;
            }
            if (numbers[i] < min) {
                min = numbers[i];
                minIndex = i;
            }
        }

        // Count numbers greater than average
        int countAboveAverage = 0;
        for (int num : numbers) {
            if (num > average) {
                countAboveAverage++;
            }
        }

        // Count even and odd numbers
        int evenCount = 0;
        int oddCount = 0;
        for (int num : numbers) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        // 3. Output all results in table format
        System.out.println("====== Array Statistics ======");
        System.out.printf("%-30s: %d\n", "Total sum", sum);
        System.out.printf("%-30s: %.2f\n", "Average value", average);
        System.out.printf("%-30s: %d (index %d)\n", "Maximum value", max, maxIndex);
        System.out.printf("%-30s: %d (index %d)\n", "Minimum value", min, minIndex);
        System.out.printf("%-30s: %d\n", "Count > average", countAboveAverage);
        System.out.printf("%-30s: %d\n", "Even numbers", evenCount);
        System.out.printf("%-30s: %d\n", "Odd numbers", oddCount);
        System.out.println("================================");
    }
}

/*output
 * ====== Array Statistics ======
Total sum                     : 117
Average value                 : 11.70
Maximum value                 : 23 (index 5)
Minimum value                 : 5 (index 0)
Count > average               : 5
Even numbers                  : 5
Odd numbers                   : 5
================================
 */