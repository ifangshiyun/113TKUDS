public class Q1BasicArrayOperations {
    public static void main(String[] args) {
        // 1. Declare an array with 10 integers
        int[] numbers = {15, 28, 7, 42, 91, 33, 66, 58, 24, 81};

        // 2. Print the length of the array
        System.out.println("Array length: " + numbers.length);

        // 3. Change the value at index 2 (third position) to 99
        numbers[2] = 99;

        // 4. Change the value at the last index to 100
        numbers[numbers.length - 1] = 100;

        // 5. Use a for loop to print all elements with their index
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Index " + i + ": " + numbers[i]);
        }
    }
}

/*output
 * Array length: 10
Index 0: 15
Index 1: 28
Index 2: 99
Index 3: 42
Index 4: 91
Index 5: 33
Index 6: 66
Index 7: 58
Index 8: 24
Index 9: 100
 */