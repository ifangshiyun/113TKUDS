package midterm;

import java.util.Scanner;

public class Q3_NightMarketRanking {
/*
 * 夜市攤位人氣排名（選擇排序）Time Complexity: O(n²)
 * 說明：使用選擇排序，由外層迴圈控制選取位置，內層找出最大值，總共比較次數為 (n-1)+(n-2)+...+1 = n(n-1)/2，
 * 故最壞情況下時間複雜度為 O(n²)。
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

