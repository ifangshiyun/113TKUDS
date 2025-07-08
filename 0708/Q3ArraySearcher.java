public class Q3ArraySearcher {

    // 2. Method to find the index of a target value in the array
    public static int findElement(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; // Found, return index
            }
        }
        return -1; // Not found
    }

    // 4. Method to count how many times a target value appears in the array
    public static int countOccurrences(int[] array, int target) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // 1. Create the array
        int[] numbers = {12, 45, 23, 67, 34, 89, 56, 78, 91, 25};

        // 5. Test searching for 67
        int target1 = 67;
        int index1 = findElement(numbers, target1);
        int count1 = countOccurrences(numbers, target1);

        System.out.println("Search for " + target1 + ":");
        if (index1 != -1) {
            System.out.println("Found at index: " + index1);
        } else {
            System.out.println("Not found.");
        }
        System.out.println("Occurrences: " + count1);

        // Test searching for 100
        int target2 = 100;
        int index2 = findElement(numbers, target2);
        int count2 = countOccurrences(numbers, target2);

        System.out.println("\nSearch for " + target2 + ":");
        if (index2 != -1) {
            System.out.println("Found at index: " + index2);
        } else {
            System.out.println("Not found.");
        }
        System.out.println("Occurrences: " + count2);
    }
}

/*output
 * Search for 67:
Found at index: 3
Occurrences: 1

Search for 100:
Not found.
Occurrences: 0
 */