package finalexam;

import java.util.*;

public class F08_ClimbStairsMemo {
    public static int climb(int n, int[] memo) {
        if (n == 0) return 1;
        if (n < 0) return 0;

        if (memo[n] != -1) return memo[n];

        memo[n] = climb(n - 1, memo) + climb(n - 2, memo) + climb(n - 3, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);

        int ways = climb(n, memo);
        System.out.println("Ways: " + ways);

        scanner.close();
    }
}



