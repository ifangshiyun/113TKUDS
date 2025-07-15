package midterm;

import java.util.Scanner;

public class Q9_FindFiveStarStalls {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 讀入攤位數量
        int n = Integer.parseInt(sc.nextLine());

        // 讀入評分
        String[] tokens = sc.nextLine().split(" ");
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(tokens[i]);
        }

        // 第一次走訪：統計評分為 5 的數量
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (scores[i] == 5) {
                count++;
            }
        }

        // 如果沒有五星評分，輸出 None
        if (count == 0) {
            System.out.println("None");
        } else {
            // 第二次走訪：收集所有索引
            int[] indices = new int[count];
            int idx = 0;
            for (int i = 0; i < n; i++) {
                if (scores[i] == 5) {
                    indices[idx++] = i;
                }
            }

            // 輸出索引
            for (int i = 0; i < indices.length; i++) {
                System.out.print(indices[i]);
                if (i < indices.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        sc.close();
    }
}

