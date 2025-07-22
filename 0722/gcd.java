public class gcd {
    
    public static int gcd(int a, int b) {
        // 如果 b 是 0，代表 a 就是最大公因數
        if (b == 0) {
            return a;
        }
        // 否則遞迴呼叫，直到 b 為 0
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        // 測試範例
        int result = gcd(48, 18);
        System.out.println("GCD of 48 and 18 is: " + result); // Output: 6
    }
}

