package finalexam;

import java.util.*;

public class F04_TieredIncomeTax {
    static int[] brackets = {540000, 1210000, 2420000, 4530000};
    static double[] rates = {0.05, 0.12, 0.20, 0.30, 0.40};

    public static int computeTax(int income) {
        int tax = 0;
        int prev = 0;

        for (int i = 0; i < brackets.length; i++) {
            if (income <= brackets[i]) {
                tax += (income - prev) * rates[i];
                return tax;
            } else {
                tax += (brackets[i] - prev) * rates[i];
                prev = brackets[i];
            }
        }

        // 超過最高級距
        tax += (income - brackets[brackets.length - 1]) * rates[rates.length - 1];
        return tax;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int totalTax = 0;

        for (int i = 0; i < n; i++) {
            int income = Integer.parseInt(scanner.nextLine());
            int tax = computeTax(income);
            totalTax += tax;
            System.out.println("Tax: $" + tax);
        }

        double average = totalTax / (double) n;
        System.out.printf("Average: $%.2f\n", average);

        scanner.close();
    }
}

/*
 * 個人所得稅級距試算 Time Complexity: O(n)
 * 說明：每筆收入計算稅額時最多遍歷 5 段級距，每段為常數時間操作；
 * 總共處理 n 筆收入，總體時間複雜度為 O(n)。
 */

