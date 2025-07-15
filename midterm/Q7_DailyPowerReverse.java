package midterm;

import java.util.Scanner;

public class Q7_DailyPowerReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 讀入 7 個整數
        String[] tokens = sc.nextLine().split(" ");
        int[] power = new int[7];
        for (int i = 0; i < 7; i++) {
            power[i] = Integer.parseInt(tokens[i]);
        }

        // 原地反轉：使用 two-pointer 交換
        int left = 0, right = 6;
        while (left < right) {
            int temp = power[left];
            power[left] = power[right];
            power[right] = temp;
            left++;
            right--;
        }

        // 輸出反轉後的結果
        for (int i = 0; i < 7; i++) {
            System.out.print(power[i]);
            if (i < 6) {
                System.out.print(" ");
            }
        }
        System.out.println();

        sc.close();
    }
}

