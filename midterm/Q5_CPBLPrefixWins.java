package midterm;

import java.util.Scanner;

public class Q5_CPBLPrefixWins {
/*
 * 職棒戰績前綴勝場 Time Complexity: O(n)
 * 說明：先建立 prefix sum 陣列，需走訪原始資料一次，再輸出前 k 筆結果，合併為一次線性走訪，
 * 因此總時間複雜度為 O(n)。
 */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 輸入比賽場數
        int n = Integer.parseInt(sc.nextLine());

        // 輸入勝敗陣列（1=勝，0=敗）
        String[] tokens = sc.nextLine().split(" ");
        int[] results = new int[n];
        for (int i = 0; i < n; i++) {
            results[i] = Integer.parseInt(tokens[i]);
        }

        // 輸入要查詢的場數 k
        int k = Integer.parseInt(sc.nextLine());

        // 建立 prefix sum 陣列
        int[] prefixSum = new int[n];
        prefixSum[0] = results[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + results[i];
        }

        // 輸出前 k 場的累積勝場
        System.out.print("PrefixSum:");
        for (int i = 0; i < k; i++) {
            System.out.print(" " + prefixSum[i]);
        }
        System.out.println();

        sc.close();
    }
}

