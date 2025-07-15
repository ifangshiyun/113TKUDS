package midterm;

import java.util.*;

public class Q2_NextTHSRDeparture {
    /*
     * Time Complexity: O(log n)
     * 說明：使用二分搜尋法找尋第一個大於查詢時間的班次，因此時間複雜度為 O(log n)。
     */

    // 將 HH:mm 字串轉成總分鐘數
    public static int timeToMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] timeStrings = new String[n];
        int[] times = new int[n];

        // 讀入時刻表並轉為分鐘
        for (int i = 0; i < n; i++) {
            String t = sc.nextLine();
            timeStrings[i] = t;
            times[i] = timeToMinutes(t);
        }

        // 查詢時間
        String query = sc.nextLine();
        int queryMin = timeToMinutes(query);

        // 二分搜尋找第一個大於 queryMin 的時間
        int left = 0, right = n - 1;
        int resultIdx = n; // 若沒找到，預設為 n（無車）

        while (left <= right) {
            int mid = (left + right) / 2;
            if (times[mid] > queryMin) {
                resultIdx = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // 輸出結果
        if (resultIdx == n) {
            System.out.println("No train");
        } else {
            System.out.println(timeStrings[resultIdx]);
        }

        sc.close();
    }
}

