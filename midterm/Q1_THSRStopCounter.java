package midterm;

import java.util.Scanner;
import java.util.Arrays;

public class Q1_THSRStopCounter {
    /*
     * Time Complexity: O(n)
     * 說明：需遍歷停靠站陣列一次來尋找起點與終點索引，故為線性時間。
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 讀入停靠站數
        int n = Integer.parseInt(sc.nextLine());

        // 讀入 n 個站代碼
        String[] stops = sc.nextLine().split(" ");

        // 讀入起點與終點
        String[] line = sc.nextLine().split(" ");
        String start = line[0];
        String end = line[1];

        // 尋找 start 與 end 的索引
        int startIdx = -1;
        int endIdx = -1;

        for (int i = 0; i < n; i++) {
            if (stops[i].equals(start)) {
                startIdx = i;
            }
            if (stops[i].equals(end)) {
                endIdx = i;
            }
        }

        // 若任一找不到則輸出 Invalid
        if (startIdx == -1 || endIdx == -1) {
            System.out.println("Invalid");
        } else {
            // 計算站數（包含起訖）
            System.out.println(Math.abs(endIdx - startIdx) + 1);
        }

        sc.close();
    }
}

