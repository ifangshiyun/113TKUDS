package finalexam;

import java.util.*;

public class F06_ArraySecondLargest {

    // 儲存 max 與 second 最大值的 pair 結構
    static class Pair {
        int max;
        int second;

        Pair(int max, int second) {
            this.max = max;
            this.second = second;
        }
    }

    // 遞迴找最大與第二大值
    public static Pair findSecondMax(int[] arr, int left, int right) {
        if (left == right) {
            return new Pair(arr[left], Integer.MIN_VALUE);
        }

        int mid = (left + right) / 2;
        Pair p1 = findSecondMax(arr, left, mid);
        Pair p2 = findSecondMax(arr, mid + 1, right);

        int max, second;
        if (p1.max > p2.max) {
            max = p1.max;
            second = Math.max(p1.second, p2.max);
        } else {
            max = p2.max;
            second = Math.max(p2.second, p1.max);
        }

        return new Pair(max, second);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Pair result = findSecondMax(arr, 0, n - 1);
        System.out.println("SecondMax: " + result.second);

        scanner.close();
    }
}

/*
 * 陣列第二大值（遞迴） Time Complexity: O(n)
 * 說明：每次遞迴分成兩半，最後每個元素被訪問一次，並逐層合併結果；
 * 合併時只需常數次比較，總共進行 n-1 次合併，故整體為 O(n)。
 */
