public class ArrayTraversal {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};
        
        System.out.println("方法一: Traditional for 迴圈（需要索引時使用）");
        // Applicable to situations where you need to know the position of an element or need to modify an element
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("index %d：value %d，memory relative address：%d\n", 
                            i, numbers[i], i * 4);
        }
        
        System.out.println("\n方法二: Enhanced for 迴圈（只需要值時使用）");
        // Applicable to situations where you only need to read element values ​​and do not need to modify them
        int sum = 0;
        for (int num : numbers) {
            sum += num;
            System.out.println("currently processed value: " + num + ", cummulative total: " + sum);
        }
        
        System.out.println("\n方法三：反向走訪 reverse visit");
        // Sometimes you need to process elements from back to front
        System.out.print("reverse output: ");
        for (int i = numbers.length - 1; i >= 0; i--) {
            System.out.print(numbers[i]);
            if (i > 0) System.out.print(" -> ");
        }
        System.out.println();
        
        System.out.println("\n方法四：跳躍式走訪 jump visit");
        // Only process elements with even indexes
        System.out.print("elements with even indexes ");
        for (int i = 0; i < numbers.length; i += 2) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}
