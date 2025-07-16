package midterm;

import java.util.Scanner;

public class Q4_TieredElectricBill {
/*
 * 分段電價帳單試算 Time Complexity: O(n)
 * 說明：每一位住戶皆需計算一次電費，電費計算為固定最多 6 段的 if 條件，與輸出操作皆為 O(1)，
 * 處理 n 筆資料，總時間複雜度為 O(n)。
 */


    // 計算單一使用量的電費
    public static int calc(int kWh) {
        double total = 0;

        if (kWh > 1000) {
            total += (kWh - 1000) * 8.46;
            kWh = 1000;
        }
        if (kWh > 700) {
            total += (kWh - 700) * 6.24;
            kWh = 700;
        }
        if (kWh > 500) {
            total += (kWh - 500) * 5.04;
            kWh = 500;
        }
        if (kWh > 330) {
            total += (kWh - 330) * 3.70;
            kWh = 330;
        }
        if (kWh > 120) {
            total += (kWh - 120) * 2.45;
            kWh = 120;
        }
        total += kWh * 1.68;

        return (int) Math.round(total); // 四捨五入到整數
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] bills = new int[n];
        int total = 0;

        for (int i = 0; i < n; i++) {
            int kWh = Integer.parseInt(sc.nextLine());
            bills[i] = calc(kWh);
            total += bills[i];
        }

        // 輸出所有 Bill
        for (int i = 0; i < n; i++) {
            System.out.println("Bill: $" + bills[i]);
        }

        // 輸出總金額與平均金額
        int avg = Math.round((float) total / n);
        System.out.println("Total: $" + total);
        System.out.println("Average: $" + avg);

        sc.close();
    }
}
