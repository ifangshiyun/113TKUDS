package midterm;

import java.util.Scanner;

public class Q3_NightMarketRanking {
    /*
     * Time Complexity: O(n^2)
     * 說明：使用選擇排序，每輪需在剩餘陣列中尋找最大值並交換位置，總共比較次數為 n(n-1)/2。
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 讀入評分數
        int n = Integer.parseInt(sc.nextLine());
        double[] scores = new double[n];

        for (int i = 0; i < n; i++) {
            scores[i] = Double.parseDouble(sc.nextLine());
        }

        // 選擇排序（從大到小）
        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] > scores[maxIdx]) {
                    maxIdx = j;
                }
            }
            // 交換
            double temp = scores[i];
            scores[i] = scores[maxIdx];
            scores[maxIdx] = temp;
        }

        // 輸出前 5 名（或全部）
        int outputCount = Math.min(5, n);
        for (int i = 0; i < outputCount; i++) {
            System.out.printf("%.1f\n", scores[i]);
        }

        sc.close();
    }
}

