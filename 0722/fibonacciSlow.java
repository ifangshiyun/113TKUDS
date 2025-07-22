public class fibonacciSlow {

    // 傳統遞迴版本（效率差，時間複雜度 O(2^n)）
    public static int fibonacciSlow(int n) {
        if (n <= 1) return n;
        return fibonacciSlow(n - 1) + fibonacciSlow(n - 2);
    }

    // 記憶化遞迴版本（效率好，時間複雜度 O(n)）
    public static int fibonacciFast(int n, int[] memo) {
        if (n <= 1) return n;

        if (memo[n] != 0) return memo[n];

        memo[n] = fibonacciFast(n - 1, memo) + fibonacciFast(n - 2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 30; // 可改成任意數字測試

        // 測試傳統遞迴
        long start1 = System.currentTimeMillis();
        int slowResult = fibonacciSlow(n);
        long end1 = System.currentTimeMillis();
        System.out.println("fibonacciSlow(" + n + ") = " + slowResult + "   Time: " + (end1 - start1) + "ms");

        // 測試記憶化遞迴
        int[] memo = new int[n + 1]; // 預設值為 0
        long start2 = System.currentTimeMillis();
        int fastResult = fibonacciFast(n, memo);
        long end2 = System.currentTimeMillis();
        System.out.println("fibonacciFast(" + n + ") = " + fastResult + "   Time: " + (end2 - start2) + "ms");
    }
}

