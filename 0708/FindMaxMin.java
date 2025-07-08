public class FindMaxMin {
    /**
     * 線性搜尋演算法的應用：尋找陣列中的最大值和最小值
     * 時間複雜度：O(n)，空間複雜度：O(1)
     */
    /**
     * Application of linear search algorithm: Find the maximum and minimum values ​​in an array
     * Time complexity: O(n), space complexity: O(1)
     */
    public static void main(String[] args) {
        int[] numbers = {45, 23, 67, 89, 12, 34, 78, 56, 91, 38};
        
        // 初始化：假設第一個元素為最大值和最小值
        // Initialization: Assume the first element is the maximum and minimum value
        int max = numbers[0];
        int min = numbers[0];
        int maxIndex = 0;
        int minIndex = 0;
        int comparisons = 0;  // 計算比較次數 Calculate the number of comparisons 
        
        // 從第二個元素開始比較
        // Start comparing from the second element
        for (int i = 1; i < numbers.length; i++) {
            comparisons += 2;  // 每次迴圈進行兩次比較 Two comparisons are performed in each loop
            
            if (numbers[i] > max) {
                max = numbers[i];
                maxIndex = i;
                System.out.printf("Find a new maximum: %d（location：%d）\n", max, maxIndex);
            }
            
            if (numbers[i] < min) {
                min = numbers[i];
                minIndex = i;
                System.out.printf("Find a new minimum: %d（location：%d）\n", min, minIndex);
            }
        }
        
        System.out.println("\n=== 搜尋結果 Search Result ===");
        System.out.printf("Array size：%d\n", numbers.length);
        System.out.printf("Number of comparisons：%d\n", comparisons);
        System.out.printf("Maximum value：%d（Index location：%d）\n", max, maxIndex);
        System.out.printf("Minimum value：%d（Index location：%d）\n", min, minIndex);
        System.out.printf("The difference between the maximum and minimum values：%d\n", max - min);
        
        // 計算最大值和最小值在陣列中的相對位置
        // Calculate the relative position of the maximum and minimum values ​​in the array
        int distance = Math.abs(maxIndex - minIndex);
        System.out.printf("The index distance between the maximum and minimum values:%d\n", distance);
    }
}
