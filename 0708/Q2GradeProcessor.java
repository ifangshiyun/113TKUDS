public class Q2GradeProcessor {
    public static void main(String[] args) {
        // 1. Create an array of 8 student grades
        int[] grades = {78, 85, 92, 67, 88, 95, 73, 90};

        // 2. Calculate total and average
        int total = 0;
        for (int i = 0; i < grades.length; i++) {
            total += grades[i];
        }

        double average = (double) total / grades.length;
        System.out.printf("Total score: %d\n", total);
        System.out.printf("Average score: %.2f\n", average); // 2 decimal places

        // 3. Find highest and lowest score with their index
        int max = grades[0];
        int min = grades[0];
        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 1; i < grades.length; i++) {
            if (grades[i] > max) {
                max = grades[i];
                maxIndex = i;
            }
            if (grades[i] < min) {
                min = grades[i];
                minIndex = i;
            }
        }

        System.out.println("Highest score: " + max + " at index " + maxIndex);
        System.out.println("Lowest score: " + min + " at index " + minIndex);

        // 4. Count how many students scored above average
        int countAboveAverage = 0;
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] > average) {
                countAboveAverage++;
            }
        }

        System.out.println("Number of students scoring above average: " + countAboveAverage);

        // 5. Print all grades in the format: "Student number: grade"
        for (int i = 0; i < grades.length; i++) {
            System.out.println("Student " + i + ": " + grades[i]);
        }
    }
}

/*output
 * Total score: 668
Average score: 83.50
Highest score: 95 at index 5
Lowest score: 67 at index 3
Number of students scoring above average: 5
Student 0: 78
Student 1: 85
Student 2: 92
Student 3: 67
Student 4: 88
Student 5: 95
Student 6: 73
Student 7: 90
 */