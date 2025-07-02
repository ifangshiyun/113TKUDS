import java.util.Scanner;

public class Q2linear_search_trace {
    public static void main(String[] args) {
        int[] s = {1, 3, 5, 7, 9};
        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入要搜尋的數字：");
        int target = sc.nextInt();
        boolean found = false;

        for (int i = 0; i < s.length; i++) {
            System.out.println("比對中：" + target + " vs " + s[i]);
            if (s[i] == target) {
                found = true;
                break;
            }
        }

        System.out.println("結果：" + (found ? "找到" : "找不到"));
        sc.close();
    }
}
