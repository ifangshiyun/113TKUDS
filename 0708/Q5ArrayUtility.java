public class Q5ArrayUtility {

    // Method to print array contents in format: [1, 2, 3, ...]
    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Method to reverse array in place
    public static void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            // Swap elements
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            left++;
            right--;
        }
    }

    // Method to make a copy of the array
    public static int[] copyArray(int[] array) {
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }

    // Method to find the second largest value in the array
    public static int findSecondLargest(int[] array) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : array) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num != max) {
                secondMax = num;
            }
        }
        return secondMax;
    }

    public static void main(String[] args) {
        // 1. Create the array
        int[] numbers = {3, 7, 1, 9, 4, 6, 8, 2, 5};

        // 2. Test printArray
        System.out.println("Original array:");
        printArray(numbers);

        // 3. Test reverseArray
        reverseArray(numbers);
        System.out.println("Reversed array:");
        printArray(numbers);

        // 4. Test copyArray
        int[] copied = copyArray(numbers);
        System.out.println("Copied array:");
        printArray(copied);

        // 5. Test findSecondLargest
        int secondLargest = findSecondLargest(numbers);
        System.out.println("Second largest number: " + secondLargest);
    }
}

/*output
 * Original array:
[3, 7, 1, 9, 4, 6, 8, 2, 5]
Reversed array:
[5, 2, 8, 6, 4, 9, 1, 7, 3]
Copied array:
[5, 2, 8, 6, 4, 9, 1, 7, 3]
Second largest number: 8
 */
