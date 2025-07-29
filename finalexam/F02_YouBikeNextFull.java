package finalexam;

import java.util.*;

public class F02_YouBikeNextFull {
    // 時間轉分鐘
    public static int timeToMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    // 分鐘轉回 HH:mm 字串
    public static String minutesToTime(int minutes) {
        int h = minutes / 60;
        int m = minutes % 60;
        return String.format("%02d:%02d", h, m);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] times = new int[n];

        for (int i = 0; i < n; i++) {
            times[i] = timeToMinutes(scanner.nextLine());
        }

        int queryTime = timeToMinutes(scanner.nextLine());

        // 使用 binary search 找第一個大於 query 的時間
        int left = 0, right = n - 1;
        int resultIndex = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (times[mid] > queryTime) {
                resultIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (resultIndex == -1) {
            System.out.println("No bike");
        } else {
            System.out.println(minutesToTime(times[resultIndex]));
        }

        scanner.close();
    }
}

/*
 * 下一站 YouBike 有車時間 Time Complexity: O(log n)
 * 說明：輸入時間已遞增排序，使用二分搜尋法找出第一個大於查詢時間的時間點。
 * 二分搜尋最多只需 log₂n 次比較，故時間複雜度為 O(log n)。
 */

