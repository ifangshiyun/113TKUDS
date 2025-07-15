package midterm;

import java.util.Scanner;

public class Q8_MergeTHSRPriceTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 讀入站數
        int n = Integer.parseInt(sc.nextLine());

        // 宣告陣列：站名陣列與票價陣列
        String[] stations = new String[n];
        int[][] prices = new int[n][2]; // [][0] = 標準票價, [][1] = 商務票價

        // 逐行輸入資料：站名、標準票價、商務票價
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            stations[i] = parts[0];
            prices[i][0] = Integer.parseInt(parts[1]); // 標準票價
            prices[i][1] = Integer.parseInt(parts[2]); // 商務票價
        }

        // 輸出表格標題
        System.out.println("Station|Standard|Business");

        // 輸出每一筆資料
        for (int i = 0; i < n; i++) {
            System.out.printf("%s|%d|%d\n", stations[i], prices[i][0], prices[i][1]);
        }

        sc.close();
    }
}
