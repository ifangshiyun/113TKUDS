public class digitSum {
    
    public static int digitSum(int n) {
        // 如果 n 為 0，回傳 0
        if (n == 0) {
            return 0;
        }

        // 拆出個位數 + 其餘位數的總和
        return (n % 10) + digitSum(n / 10);
    }

    public static void main(String[] args) {
        // 測試數字總和
        int result = digitSum(12345);
        System.out.println("Sum of digits in 12345 is: " + result); // Output: 15
    }
}
