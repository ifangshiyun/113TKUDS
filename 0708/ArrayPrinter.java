public class ArrayPrinter {
    /**
     * 將整數陣列轉換為字串表示法
     * 模仿 Arrays.toString() 的功能
     * 這個方法展示了如何透過索引來循序存取陣列元素
     */
    /**
     * Converts an integer array to string representation
     * Mimics the functionality of Arrays.toString()
     * This method demonstrates how to access array elements sequentially by index
     */
    public static String arrayToString(int[] array) {
        // Handle special cases of empty arrays
        if (array == null) {
            return "null";
        }
        
        if (array.length == 0) {
            return "[]";
        }
        
        StringBuilder sb = new StringBuilder("[");
        
        // Use a traditional for loop to control the format output
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        
        sb.append("]");
        return sb.toString();
    }
    
    /**
     * Print detailed information of the array, including the relationship between the index and the value.
     */
    static void printArrayWithIndex(int[] array) {
        System.out.println("index\tvalue");
        System.out.println("----\t---");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d\t%d\n", i, array[i]);
        }
    }
    
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int[] emptyArray = {};
        int[] nullArray = null;
        
        System.out.println("general array: " + arrayToString(numbers));
        System.out.println("empty array: ：" + arrayToString(emptyArray));
        System.out.println("null array:：" + arrayToString(nullArray));
        
        System.out.println("\nDetails：");
        printArrayWithIndex(numbers);
    }
}
