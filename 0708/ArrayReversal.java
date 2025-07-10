public class ArrayReversal {
    /**
     * 原地反轉演算法：使用雙指標技術
     * 時間複雜度：O(n/2) = O(n)
     * 空間複雜度：O(1) - 只使用固定的額外空間
     */
    /**
     * In-place reversal algorithm: using dual-index technique
     * Time complexity: O(n/2) = O(n)
     * Space complexity: O(1) - only uses fixed extra space
     */
    public static void reverseInPlace(int[] array) {
        int left = 0;                    // 左指標，從陣列開頭開始 Left index, starting from the beginning of the array
        int right = array.length - 1;   // 右指標，從陣列結尾開始 Right index, starting from the end of the array
        int swapCount = 0;               // 計算交換次數 Calculate the number of exchanges
        
        System.out.println("反轉過程 Reversal process：");
        
        while (left < right) {
            // 顯示當前要交換的元素
            // Display the element currently to be swapped
            System.out.printf("Swap index %d (value: %d) with index %d (value: %d）\n", 
                            left, array[left], right, array[right]);
            
            // 交換元素：使用暫存變數的三步驟交換法
            // Swapping elements: three-step swapping method using temporary variables
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            
            swapCount++;
            
            // 指標向中間移動 The indicator moves to the middle
            left++;
            right--;
        }
        
        System.out.printf("總共進行了 %d 次交換\n", swapCount);
    }
    
    /**
     * 建立新陣列的反轉方法：不修改原陣列
     * 空間複雜度：O(n) - 需要額外的陣列空間
     */
    /**
     * Inversion method to create a new array: do not modify the original array
     * Space complexity: O(n) - requires additional array space
     */
    static int[] reverseToNew(int[] array) {
        int[] reversed = new int[array.length];
        
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        
        return reversed;
    }
    
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        int[] originalCopy = numbers.clone();  // 保留原始資料的副本 Keep a copy of the original material
        
        System.out.println("原始陣列 original array：" + java.util.Arrays.toString(numbers));
        
        // 方法一：原地反轉（修改原陣列）
        // Method 1: Reverse in place (modify the original array)
        reverseInPlace(numbers);
        System.out.println("原地反轉後 After reversing in place：" + java.util.Arrays.toString(numbers));
        
        // 方法二：建立新陣列（不修改原陣列）
        // Method 2: Create a new array (do not modify the original array)
        int[] newReversed = reverseToNew(originalCopy);
        System.out.println("原始陣列（未修改）：" + java.util.Arrays.toString(originalCopy));
        System.out.println("新反轉陣列 New reverse array：" + java.util.Arrays.toString(newReversed));
    }   
}
