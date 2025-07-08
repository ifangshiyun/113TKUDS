public class ScoreStatistics {
    public static void main(String[] args) {
        int[] scores = {85, 92, 77, 60, 88, 95, 73, 68, 89, 91};
        
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        
        double average = (double) sum / scores.length;
        int studentCount = scores.length;
        
        System.out.println("=== Score Statistic Report ===");
        System.out.printf("Number of Students: %d people\n", studentCount);
        System.out.printf("Total score: %d points\n", sum);
        System.out.printf("Average score: %.2f points\n", average);
        
        // 顯示所有成績 Show all grades
        System.out.println("\n Individual result: ");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("the %2d student：%d points\n", i + 1, scores[i]);
        }
    }
}
