package finalexam;

import java.util.*;

public class F03_ConvenienceHotItems {
    static class Item {
        String name;
        int qty;

        Item(String name, int qty) {
            this.name = name;
            this.qty = qty;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Item> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = scanner.nextLine().split(" ");
            String name = parts[0];
            int qty = Integer.parseInt(parts[1]);

            // 插入排序：找到正確插入位置
            int j = 0;
            while (j < items.size() && qty < items.get(j).qty) {
                j++;
            }
            items.add(j, new Item(name, qty));
        }

        // 輸出前 10 名
        for (int i = 0; i < Math.min(10, items.size()); i++) {
            System.out.println(items.get(i).name + " " + items.get(i).qty);
        }

        scanner.close();
    }
}

/*
 * 便利商店熱銷商品排名 Time Complexity: O(n^2)
 * 說明：每新增一筆資料時，需從頭掃描已排序清單來找插入點，最壞情況下每筆都需移動 n 筆資料，
 * 因此總次數為 1 + 2 + ... + (n-1) = n(n-1)/2，時間複雜度為 O(n²)。
 */

