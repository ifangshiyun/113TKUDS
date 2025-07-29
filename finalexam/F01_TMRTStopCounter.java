package finalexam;

import java.util.*;

public class F01_TMRTStopCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 站數
        List<String> stations = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            stations.add(scanner.next());
        }

        String start = scanner.next();
        String end = scanner.next();

        int startIndex = stations.indexOf(start);
        int endIndex = stations.indexOf(end);

        if (startIndex == -1 || endIndex == -1) {
            System.out.println("Invalid");
        } else {
            int count = Math.abs(startIndex - endIndex) + 1;
            System.out.println(count);
        }

        scanner.close();
    }
}

/*
 * 北捷區間停靠統計 Time Complexity: O(n)
 * 說明：使用一次掃描 `.indexOf()` 來查找起訖站的索引值，
 * 每次查找最多掃描 n 個元素，因此總共最多進行 2n 次比較。
 * 因此時間複雜度為 O(n)。
 */

