public class fibonacci {
    public static int fibonacci(int n) {
        // 第 0 項是 0，第 1 項是 1
        if (n == 0) return 0;
        if (n == 1) return 1;

        // 其他項目 = 前兩項相加
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("fibonacci(6): " + fibonacci(6)); // Output: 8
    }
}

