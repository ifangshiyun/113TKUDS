public class Q6StudentGradeSystem {

    // Method to determine grade based on score
    public static String getGrade(int score) {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else {
            return "D";
        }
    }

    // Method to print full report
    public static void printReport(int[] scores) {
        int sum = 0;
        int max = scores[0];
        int min = scores[0];
        int maxIndex = 0;
        int minIndex = 0;

        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;

        for (int i = 0; i < scores.length; i++) {
            int score = scores[i];
            sum += score;

            if (score > max) {
                max = score;
                maxIndex = i;
            }
            if (score < min) {
                min = score;
                minIndex = i;
            }

            String grade = getGrade(score);
            switch (grade) {
                case "A": countA++; break;
                case "B": countB++; break;
                case "C": countC++; break;
                case "D": countD++; break;
            }
        }

        double average = (double) sum / scores.length;

        // Calculate percentage of students above average
        int countAboveAverage = 0;
        for (int score : scores) {
            if (score > average) {
                countAboveAverage++;
            }
        }
        double aboveAvgPercentage = ((double) countAboveAverage / scores.length) * 100;

        // Output report
        System.out.println("======= Student Grade Report =======");
        System.out.println("------------------------------------");
        System.out.printf("Total Students        : %d\n", scores.length);
        System.out.printf("Class Average         : %.2f\n", average);
        System.out.printf("Highest Score         : %d (Student %d)\n", max, maxIndex);
        System.out.printf("Lowest Score          : %d (Student %d)\n", min, minIndex);
        System.out.printf("Grade A (90-100)      : %d\n", countA);
        System.out.printf("Grade B (80-89)       : %d\n", countB);
        System.out.printf("Grade C (70-79)       : %d\n", countC);
        System.out.printf("Grade D (Below 70)    : %d\n", countD);
        System.out.printf("Above Average Students: %.2f%%\n", aboveAvgPercentage);
        System.out.println("------------------------------------");
        System.out.println("Student No. | Score | Grade");
        System.out.println("------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("    %2d      |  %3d  |   %s\n", i, scores[i], getGrade(scores[i]));
        }

        System.out.println("====================================");
    }

    public static void main(String[] args) {
        // 1. Student score array
        int[] scores = {85, 92, 78, 96, 87, 73, 89, 94, 81, 88};

        // 2. Print the report
        printReport(scores);
    }
}


/*output
 * ======= Student Grade Report =======
------------------------------------
Total Students        : 10
Class Average         : 86.30
Highest Score         : 96 (Student 3)
Lowest Score          : 73 (Student 5)
Grade A (90-100)      : 3
Grade B (80-89)       : 5
Grade C (70-79)       : 2
Grade D (Below 70)    : 0
Above Average Students: 60.00%
------------------------------------
Student No. | Score | Grade
------------------------------------
     0      |   85  |   B
     1      |   92  |   A
     2      |   78  |   C
     3      |   96  |   A
     4      |   87  |   B
     5      |   73  |   C
     6      |   89  |   B
     7      |   94  |   A
     8      |   81  |   B
     9      |   88  |   B
====================================
 */