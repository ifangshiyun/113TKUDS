package finalexam;

import java.util.*;

public class F05_LCMRecursive {
    // 輾轉相減法求 GCD（遞迴）
    public static int gcd(int a, int b) {
        if (a == b) return a;
        if (a > b) return gcd(a - b, b);
        return gcd(a, b - a);
    }

    // LCM(a, b) = a * b / GCD(a, b)
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int result = lcm(a, b);
        System.out.println("LCM: " + result);

        scanner.close();
    }
}

/*
 * 最小公倍數（遞迴） Time Complexity: O(max(a, b))
 * 說明：輾轉相減法每次減少其中一個數值，最壞情況下一次只減 1，
 * 因此時間複雜度最差為 O(max(a, b))。
 * 計算 LCM 時為常數時間，整體仍為 O(max(a, b))。
 */

