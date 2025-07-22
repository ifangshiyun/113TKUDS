import java.util.Scanner;

public class StringReverse {

    public static String reverseString(String str) {
        // 基底條件：長度為 0 或 1，直接回傳
        if (str.length() <= 1) {
            return str;
        }
        // 遞迴反轉：最後一個字元 + 前面部分的反轉
        return str.charAt(str.length() - 1) + 
               reverseString(str.substring(0, str.length() - 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入一個單字：");
        String input = scanner.nextLine();

        // 驗證輸入是否為單字（不含空格）
        if (input.trim().contains(" ") || input.isEmpty()) {
            System.out.println("請只輸入一個單字（不能有空格或空白）！");
        } else {
            String reversed = reverseString(input);
            System.out.println("反轉結果是：" + reversed);
        }

        scanner.close();
    }
}
