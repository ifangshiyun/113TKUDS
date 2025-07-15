package midterm;

import java.util.Scanner;

public class Q10_ArrayToStringUtil {

    // 仿 Arrays.toString() 實作
    public static String arrayToString(int[] arr) {
        if (arr == null) return "null";
        if (arr.length == 0) return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 讀入陣列大小
        int n = Integer.parseInt(sc.nextLine());

        // 特殊情況：n 為 0，建立空陣列
        int[] arr = new int[n];

        if (n > 0) {
            // 讀入 n 個整數
            String[] tokens = sc.nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }
        }

        // 輸出轉為字串的陣列
        System.out.println(arrayToString(arr));

        sc.close();
    }
}
