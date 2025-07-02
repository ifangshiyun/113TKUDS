import java.util.Scanner;

public class Q5binary_search_trace {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入要搜尋的數字：");
        int target = sc.nextInt();

        int left = 0, right = arr.length - 1;
        boolean found = false;

        while (left <= right) {
            int mid = (left + right) / 2;
            System.out.println("搜尋範圍：left = " + left + ", right = " + right + ", mid = " + mid + " → arr[mid] = " + arr[mid]);

            if (arr[mid] == target) {
                found = true;
                break;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println("結果：" + (found ? "已找到！" : "找不到"));
        sc.close();
    }
}
