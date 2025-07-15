package midterm;

import java.util.Scanner;

public class Q6_NightMarketMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 建立 10x10 地圖，預設為 #
        char[][] map = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                map[i][j] = '#';
            }
        }

        // 讀入座標數
        int m = Integer.parseInt(sc.nextLine());

        // 將合法座標標記為 *
        for (int i = 0; i < m; i++) {
            String[] tokens = sc.nextLine().split(" ");
            int r = Integer.parseInt(tokens[0]);
            int c = Integer.parseInt(tokens[1]);

            if (r >= 0 && r < 10 && c >= 0 && c < 10) {
                map[r][c] = '*';
            }
        }

        // 輸出地圖
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

        sc.close();
    }
}

